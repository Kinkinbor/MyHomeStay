package garlance.admin.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("front_user")
public class FrontUserEntity implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    private Long id;        //id

    private String account;     //账号

    private String password;        //密码

    private String nickname;    //昵称

    private String photo;        //照片路径

    private String name;        //真实姓名

    private String gender;        //性别

    private String balance;        //用户余额

    private String mobile;        //手机号

    private String isDisabled;        //是否禁用 0：未禁用 1 已禁用

    private String isDel;       //是否删除 0：正常 1.删除

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;   //更新时间
}
