package cn.tellsea.mysqldump.common.exception;

/**
 * 连接异常异常
 *
 * @author Tellsea
 * @date 2020/4/4
 */
public class ConnectionException extends BaseException {

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message) {
        super(message);
    }
}
