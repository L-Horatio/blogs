package cn.horatio.blogs.exception;

/**
 * @author L-Horatio
 * @date 2020/7/31
 * @time 21:30
 */

/**
 * 业务异常，是当前项目中所有业务异常的基类
 */
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -4230445086602648196L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
