package cn.horatio.blogs.controller;

import cn.horatio.blogs.entity.Movies;
import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.service.IMoviesService;
import cn.horatio.blogs.service.IUserService;
import cn.horatio.blogs.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 14:19
 */
@RestController
@RequestMapping("/movies")
public class MoviesController extends BaseController{

    @Autowired
    private IMoviesService moviesService;

    @PostMapping("/add.do")
    public ResponseResult<Void> handleCreate(String username, Movies movies) {
        moviesService.create(username, movies);
        return new ResponseResult<Void>(SUCCESS);
    }
}
