package com.yhuk.account.restapi.handle;

import com.yhuk.common.object.ErrorCodeException;
import com.yhuk.common.object.ResponseVO;
import com.yhuk.common.object.status.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/7/5 14:04
 * @Version 1.0
 **/
@Slf4j(topic = "error")
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseVO exceptionHandler(Exception e) {
        log.error("error:", e);
        return new ResponseVO(CodeEnum.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseVO paramException(IllegalArgumentException e){
        log.error("error:{}",e);
        return new ResponseVO(CodeEnum.INVALID_PARAMETERS,e.getMessage());
    }
    @ExceptionHandler(value = ErrorCodeException.class)
    public ResponseVO errorCodeHandler(ErrorCodeException e) {
        log.info("ErrorCodeException:{}",e);
        return new ResponseVO(e.getCode());
    }
}
