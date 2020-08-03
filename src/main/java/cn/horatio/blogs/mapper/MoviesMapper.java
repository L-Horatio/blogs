package cn.horatio.blogs.mapper;

import cn.horatio.blogs.entity.Movies;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 21:12
 */
public interface MoviesMapper {

    /**
     * 新增电影
     * @param movies 电影数据
     * @return
     */
    Integer addnew(Movies movies);
}
