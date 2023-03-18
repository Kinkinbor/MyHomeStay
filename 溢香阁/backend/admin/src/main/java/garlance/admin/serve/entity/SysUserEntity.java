package garlance.admin.serve.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Long id;        //id

    @TableField("account")
    private String account;     //账号

    @TableField("password")
    private String password;        //密码

    @TableField("nickname")
    private String nickname;    //昵称

    @TableField("salt")
    private String salt;        //盐

    @TableField("is_del")
    private String isDel;       //是否删除 0：正常 1.删除

    @TableField("create_time")
    private Date createTime;   //创建时间

    @TableField("update_time")
    private Date updateTime;   //更新时间
}
