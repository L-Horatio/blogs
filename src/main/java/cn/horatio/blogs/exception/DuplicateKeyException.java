package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:35
 */

/**
 * 违反了Unique约束的异常
 */
public class DuplicateKeyException extends ServiceException{

    private static final long serialVersionUID = 3328403087381934260L;

    public DuplicateKeyException() {
        super();
    }

    public DuplicateKeyException(String message) {
        super(message);
    }

    public DuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateKeyException(Throwable cause) {
        super(cause);
    }

    protected DuplicateKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
