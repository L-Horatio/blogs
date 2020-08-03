package cn.horatio.blogs.service;

import cn.horatio.blogs.entity.Movies;
import cn.horatio.blogs.exception.InsertException;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 23:19
 */

/**
 * 处理电影数据的业务层接口
 */
public interface IMoviesService {

    /**
     * 新增电影数据
     * @param username 用户姓名
     * @param movies 电影数据
     * @return
     * @throws InsertException
     */
    Movies create(String username, Movies movies) throws InsertException;

}
