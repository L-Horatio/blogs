package cn.horatio.blogs.mapper;

import cn.horatio.blogs.entity.Movies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 20:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesMapperTestCase {

    @Autowired
    private MoviesMapper moviesMapper;

    @Test
    public void addnew(){
        Movies movies = new Movies();
        movies.setImages("iamge/4545.jpg");
        movies.setDownload("iamge/48522.jpg");
        movies.setIsDelete(0);
        movies.setType("ggh");
        Integer rows = moviesMapper.addnew(movies);
        System.err.println("rows=" + rows);
    }
}
