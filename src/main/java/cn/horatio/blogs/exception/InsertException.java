package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:36
 */

/**
 * 插入数据异常
 */
public class InsertException extends ServiceException{

    private static final long serialVersionUID = -6793652919437422853L;

    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
