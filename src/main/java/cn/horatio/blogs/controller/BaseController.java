package cn.horatio.blogs.controller;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 0:21
 */

import cn.horatio.blogs.exception.*;
import cn.horatio.blogs.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 当前项目中所有控制器类的基类
 */
public abstract class BaseController {

    /**
     * 正确响应时的代号
     */
    public static final Integer SUCCESS = 200;

    @ExceptionHandler(ServiceException.class)   //表示这个方法是处理异常的
    @ResponseBody   //表示响应是正文，而不是转发或重定向
    public ResponseResult<Void> handleException(Exception e) {

        Integer state = null;

        if (e instanceof DuplicateKeyException) {
            // DuplicateKeyException 400-违反了Unique约束的异常
            state = 400;
        } else if (e instanceof UserNotFoundException) {
            // UserNotFoundException 401-用户名不存在异常
            state = 401;
        } else if (e instanceof PasswordNotMatchException) {
            // PasswordNotMatchException 402-密码错误异常
            state = 402;
        } else if (e instanceof InsertException) {
            // InsertException 500-插入数据异常
            state = 500;
        } else if (e instanceof UpdateException) {
            // UpdateException 501-更新数据异常
            state = 501;
        }
        return new ResponseResult<>(state, e);
    }

    /**
     * 从session中获取uid
     * @param session HttpSession对象
     * @return 当前登录的用户id
     */
    protected Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
}
