package cn.horatio.blogs.service;

import cn.horatio.blogs.entity.Movies;
import cn.horatio.blogs.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 22:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesServiceTestCase {

    @Autowired
    private IMoviesService moviesService;

    @Test
    public void create(){
        try {
            String username = "root";
            Movies movies = new Movies();
            movies.setImages("sfsdfs.jpg");
            movies.setDescription("32");
            movies.setLevel("12");
            movies.setDownload("sdfsdf.jpg");
            Movies data = moviesService.create(username, movies);
            System.err.println("data=" + data);
        }catch (ServiceException e) {
            System.err.println("错误类型:" + e.getClass().getName());
            System.err.println("错误描述:" + e.getMessage());
        }
    }
}
