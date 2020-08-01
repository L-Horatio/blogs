package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/8/1
 * @time 17:41
 */

/**
 * 密码错误异常
 */
public class PasswordNotMatchException extends ServiceException{

    private static final long serialVersionUID = 5481632723719935246L;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
