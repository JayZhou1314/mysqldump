package cn.tellsea.mysqldump.common.handler;

import cn.tellsea.mysqldump.common.entity.ResponseResult;
import cn.tellsea.mysqldump.common.enums.StatusEnums;
import cn.tellsea.mysqldump.common.exception.BaseException;
import cn.tellsea.mysqldump.common.exception.ConnectionException;
import cn.tellsea.mysqldump.common.exception.CrudException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Tellsea
 * @date 2020/3/5
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(Exception e) {
        log.error("Exception：{}", "服务器错误");
        e.printStackTrace();
        return ResponseResult.error(StatusEnums.SERVER_ERROR);
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleBaseException(BaseException e) {
        log.error("BaseException：{}", e.getMessage());
        return ResponseResult.errorMsg(e.getMessage());
    }

    @ExceptionHandler(value = CrudException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleCrudException(CrudException e) {
        log.error("CrudException：{}", e.getMessage() + "：影响数据库行数为0");
        return ResponseResult.errorMsg(e.getMessage());
    }

    @ExceptionHandler(value = ConnectionException.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleConnectionException(ConnectionException e) {
        log.error("ConnectionException：{}", e.getMessage());
        return ResponseResult.errorMsg(e.getMessage());
    }
}
