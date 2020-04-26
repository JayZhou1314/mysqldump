package cn.tellsea.mysqldump.common.exception;

/**
 * 增删改查异常
 *
 * @author Tellsea
 * @date 2020/4/4
 */
public class CrudException extends BaseException {

    public CrudException() {
        super();
    }

    public CrudException(String message) {
        super(message);
    }
}
