package garlance.admin.config.exception;
/*
*
* 自定义异常，用于人工抛出错误信息
*
* */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
