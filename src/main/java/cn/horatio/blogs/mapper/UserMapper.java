package cn.horatio.blogs.mapper;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 14:53
 */

import cn.horatio.blogs.entity.User;

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
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 匹配的用户数据，没有则返回null
     */
    User findByUsername(String username);
}
