package cn.horatio.blogs.controller;

import cn.horatio.blogs.entity.User;
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
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @PostMapping("/reg.do")
    public ResponseResult<Void> handleReg(User uesr) {
        userService.reg(uesr);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/login.do")
    public ResponseResult<Void> handleLogin(@RequestParam("username") String username,
                                            @RequestParam("password") String password,
                                            HttpSession session) {
        // 执行登录
        User user = userService.login(username, password);
        // 将相关信息存入到session中
        session.setAttribute("uid", user.getId()); //存入session中的用户id名设置为uid
        session.setAttribute("username", user.getUsername());
        return new ResponseResult<Void>(SUCCESS);
    }

    @RequestMapping("/password.do")
    public ResponseResult<Void> changePassword(@RequestParam("old_password") String oldPassword,@RequestParam("new_password") String newPassword, HttpSession session) {
        // 获取当前登录的用户的id
        Integer uid = getUidFromSession(session);
        // 执行修改密码
        userService.changePassword(uid, oldPassword, newPassword);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
}
