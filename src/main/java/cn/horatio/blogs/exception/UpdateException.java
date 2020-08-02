package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/8/2
 * @time 21:50
 */

/**
 * 修改密码异常
 */
public class UpdateException extends ServiceException{

    private static final long serialVersionUID = -3516518395195429824L;

    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
