package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 17:36
 */

/**
 * 用户名不存在异常
 */
public class UserNotFoundException extends ServiceException{

    private static final long serialVersionUID = -3872503126503614617L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
