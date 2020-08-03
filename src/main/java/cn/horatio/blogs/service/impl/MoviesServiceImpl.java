package cn.horatio.blogs.service.impl;

import cn.horatio.blogs.entity.Movies;
import cn.horatio.blogs.exception.InsertException;
import cn.horatio.blogs.mapper.MoviesMapper;
import cn.horatio.blogs.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author L-Horatio
 * @date 2020/8/3
 * @time 23:21
 */
@Service
public class MoviesServiceImpl implements IMoviesService {

    @Override
    public Movies create(String username, Movies movies) throws InsertException {
        //封装日志
        Date now = new Date();
        movies.setCreatedTime(now);
        movies.setCreatedUser(username);
        movies.setModifiedTime(now);
        movies.setModifiedUser(username);

        addnew(movies);
        return movies;
    }

    @Autowired
    private MoviesMapper moviesMapper;

    /**
     * 新增电影
     * @param movies 电影数据
     * @return
     */
    private void addnew(Movies movies) {
        Integer rows = moviesMapper.addnew(movies);
        if (rows != 1) {
            throw new InsertException("增加电影数据时出现未知错误！");
        }
    }
}
