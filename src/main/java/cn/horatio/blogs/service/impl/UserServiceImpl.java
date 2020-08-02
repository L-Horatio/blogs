package cn.horatio.blogs.service.impl;

import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.exception.*;
import cn.horatio.blogs.mapper.UserMapper;
import cn.horatio.blogs.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:41
 */

/**
 * 处理用户数据的业务层实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User reg(User user) throws DuplicateKeyException, InsertException {
        // 根据尝试注册的用户名查询用户数据
        User result = findByUsername(user.getUsername());
        // 判断查询到到数据是否为null
        if(result == null) {
            // 是：用户名不存在，允许注册
            // 【补充非用户提交的数据】
            // 是否已经被删除：否
            user.setIsDelete(0);
            // 四项日志
            Date now = new Date();
            user.setCreatedUser(user.getUsername());
            user.setCreatedTime(now);
            user.setModifiedUser(user.getUsername());
            user.setModifiedTime(now);
            // ------------------
            // 【处理密码加密】
            // 加密-1：获取随机的UUID作为盐值
            String salt = UUID.randomUUID().toString();
            // 加密-2：获取用户提交的原始密码
            String srcPassword = user.getPassword();
            // 加密-3：基于原始密码和盐值，获取通过md5加密的密码
            String md5Password = getMd5Password(srcPassword, salt);
            // 加密-4：将加密后的密码封装在user对象中
            user.setPassword(md5Password);
            // 加密-5：将盐值存入user
            user.setSalt(salt);

            // 执行注册
            addnew(user);
            // -- 返回注册的用户对象
            return user;
        } else {
            // 否：用户名已经被占用，抛出异常DuplicateKeyException异常
            throw new DuplicateKeyException("注册失败！尝试注册的用户名(" + user.getUsername() +")已经被注册！");
        }
    }

    @Override
    public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        // 根据参数数据查询用户数据
        User data = findByUsername(username);
        // 判断用户数据是否为null
        if (data == null) {
            // 是：为null，用户名不存在，抛出UserNotFoundException异常
            throw new UserNotFoundException("登录失败，您输入的用户名不存在！");
        } else {
            // 否：非null，用户名存在，找到了数据，取出盐值
            String salt = data.getSalt();
            // 对参数password执行加密
            String md5Passwrod = getMd5Password(password, salt);
            // 判断密码是否匹配
            if (data.getPassword().equals(md5Passwrod)) {      // equals(md5Passwrod == data.getPassword())
                // 是：匹配，密码正确，则判断是否被删除
                if (data.getIsDelete() == 1) {
                    //     是：已被删除，则抛出UserNotFoundException异常
                    throw new UserNotFoundException("登录失败，您输入的用户名不存在！");
                } else {
                    //     否：没被删除，则登陆成功，将第1步查询的用户数据中的盐值和密码设置为null
                    data.setSalt(null);
                    data.setPassword(null);
                    //     返回用户数据
                    return data;
                }
            } else {
                // 否：抛出PasswordNotMatchException异常
                throw new PasswordNotMatchException("登录失败，您输入的密码不正确！");
            }
        }
    }

    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword) throws UserNotFoundException, PasswordNotMatchException, UserNotFoundException {
        // 根据uid查询用户数据
        User data = findById(uid);
        // 判断查询结果是否为null
        if (data == null) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("修改失败，用户名不存在！");
        }

        // 判断查询结果中的idDelete是否为1
        if (data.getIsDelete() == 1) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("修改失败，用户名不存在！");
        }

        // 取出查询结果中的盐值
        String salt = data.getSalt();
        // 对参数oldPassword执行md5加密
        String oldMd5Password = getMd5Password(oldPassword, salt);
        // 将加密结果与查询结果中的password进行对比，看是否匹配
        if (data.getPassword().equals(oldMd5Password)) {
            // 是：原密码正确，对参数newPassword进行md5加密
            String newMd5Password = getMd5Password(newPassword, salt);
            //    获取当前时间
            Date now = new Date();
            //    执行修改
            updatePassword(uid, newMd5Password, data.getUsername(), now);
        } else {
            // 否：原密码错误，抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("修改失败，原密码错误！");
        }
    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取md5版加密后的密码
     * @param srcPassword
     * @param salt
     * @return
     */
    private String getMd5Password(String srcPassword, String salt) {
        // [注意]以下加密规则是自由设计
        // ---------------------------
        // 盐值 拼接 原密码 拼接 盐值
        String str = salt + srcPassword + salt;
        // 循环执行10次摘要运算
        for (int i = 0; i < 10; i ++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes());
        }
        // 返回摘要结果
        return str;
    }

    /**
     * 新增用户数据
     * @param user 用户数据
     * @throws InsertException
     */
    private void addnew(User user) {
        Integer rows = userMapper.addnew(user);
        if(rows != 1) {
            throw new InsertException("增加用户数据时发生未知错误！");
        }
    }

    /**
     * 修改密码
     * @param uid 用户id
     * @param password 新密码
     * @param modifiedUser 最后修改者
     * @param modifiedTime 最后修改时间
     */
    private void updatePassword(Integer uid, String password, String modifiedUser, Date modifiedTime) {
        Integer rows = userMapper.updatePassword(uid, password, modifiedUser, modifiedTime);
        if (rows != 1) {
            throw new UpdateException("修改密码失败，出现未知错误！");
        }
    }

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，没有则返回null
     */
    private User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 根据用户id查询用户数据
     * @param id 用户id
     * @return 匹配的用户数据，没有则返回null
     */
    private User findById(Integer id) {
        return userMapper.findById(id);
    }
}
