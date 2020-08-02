package cn.horatio.blogs.service;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:25
 */

import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.exception.DuplicateKeyException;
import cn.horatio.blogs.exception.InsertException;
import cn.horatio.blogs.exception.PasswordNotMatchException;
import cn.horatio.blogs.exception.UserNotFoundException;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {


    /**
     * 用户注册
     * @param user 用户注册信息
     * @return 成功注册的用户数据
     * @throws DuplicateKeyException
     * @throws InsertException
     */
    User reg(User user) throws DuplicateKeyException, InsertException;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功登录的用户数据
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     */
    User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;

    /**
     * 修改密码
     * @param uid 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     * @throws UserNotFoundException
     */
    void changePassword(Integer uid, String oldPassword, String newPassword) throws UserNotFoundException, PasswordNotMatchException, UserNotFoundException;
}
