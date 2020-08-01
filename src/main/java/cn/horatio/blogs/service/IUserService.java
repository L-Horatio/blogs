package cn.horatio.blogs.service;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:25
 */

import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.exception.DuplicateKeyException;
import cn.horatio.blogs.exception.InsertException;

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
}
