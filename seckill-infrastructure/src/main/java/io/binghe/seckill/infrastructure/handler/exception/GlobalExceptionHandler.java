package io.binghe.seckill.infrastructure.handler.exception;

import io.binghe.seckill.domain.code.HttpCode;
import io.binghe.seckill.domain.exception.SeckillException;
import io.binghe.seckill.domain.response.ResponseMessage;
import io.binghe.seckill.domain.response.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YouChuande
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(SeckillException.class)
    public ResponseMessage<String> handleSeckillException(SeckillException e) {
        logger.error("发生异常", e);
        return ResponseMessageBuilder.build(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseMessage<String> handleException(Exception e) {
        logger.error("发生异常", e);
        return ResponseMessageBuilder.build(HttpCode.SERVER_EXCEPTION.getCode(), e.getMessage());
    }
}
