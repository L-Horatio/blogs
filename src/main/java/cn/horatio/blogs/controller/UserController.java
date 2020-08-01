package cn.horatio.blogs.controller;

import cn.horatio.blogs.entity.User;
import cn.horatio.blogs.service.IUserService;
import cn.horatio.blogs.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 14:19
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @PostMapping("/reg.do")
    public ResponseResult<Void> handleReg(User uesr) {
        userService.reg(uesr);
        return new ResponseResult<Void>(SUCCESS);
    }
}
