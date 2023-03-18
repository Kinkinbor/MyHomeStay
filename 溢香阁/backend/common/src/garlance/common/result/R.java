package garlance.common.result;

import lombok.Data;

@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private Long count;

    private T data; //数据


    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 0;
        return r;
    }

    public static <T> R<T> success(T object,long count) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 0;
        r.count = count;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 1;
        r.count = 0l;
        return r;
    }
    public static <T> R<T> error(String msg,long count) {
        R r = new R();
        r.msg = msg;
        r.code = 1;
        r.count = count;
        return r;
    }
}
