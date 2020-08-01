package cn.horatio.blogs.controller;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 0:21
 */

import cn.horatio.blogs.exception.DuplicateKeyException;
import cn.horatio.blogs.exception.InsertException;
import cn.horatio.blogs.exception.ServiceException;
import cn.horatio.blogs.util.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

        if (e instanceof DuplicateKeyException) {
            // DuplicateKeyException 400-违反了Unique约束的异常
            return new ResponseResult<>(400, e);
        } else if (e instanceof InsertException) {
            // InsertException 500-插入数据异常
            return new ResponseResult<>(500, e);
        }

        return null;
    }
}
