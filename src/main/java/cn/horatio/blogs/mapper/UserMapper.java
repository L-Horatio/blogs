package cn.horatio.blogs.mapper;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 14:53
 */

import cn.horatio.blogs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {

    /**
     * 新增用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer addnew(User user);

    /**
     * 修改密码
     * @param uid 用户id
     * @param password 新密码
     * @param modifiedUser 最后修改者
     * @param modifiedTime 最后修改时间
     * @return 受影响的行数
     */
    Integer updatePassword(@Param("uid") Integer uid,
                           @Param("password") String password,
                           @Param("modifiedUser") String modifiedUser,
                           @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，没有则返回null
     */
    User findByUsername(String username);

    /**
     * 根据用户id查询用户数据
     * @param id 用户id
     * @return 匹配的用户数据，没有则返回null
     */
    User findById(Integer id);
}
