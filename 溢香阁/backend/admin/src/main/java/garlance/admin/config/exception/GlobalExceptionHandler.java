package garlance.admin.config.exception;

import garlance.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
/*
*
* 全局异常处理器，如果插入用户的时候id重复或者用户名重复，执行此异常
*
* */

@RestControllerAdvice(annotations = {RestController.class})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException e){
        e.getMessage().split(" ");
        if (e.getMessage().contains("Duplicate entry")){
            String arr[] = e.getMessage().split(" ");
            String msg = arr[2] + "当前用户已存在-_-!";
            return R.error(msg);
        }
        return R.error("操作失败-_-!");
    }


    @ExceptionHandler(CustomException.class)
    public R<String> MyExceptionHandler(CustomException e){
        String message = e.getMessage();
        return R.error(message);
    }
}
