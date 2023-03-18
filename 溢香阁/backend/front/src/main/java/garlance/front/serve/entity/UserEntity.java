package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户表 - 记录用户的基本信息
 */

@TableName("user")
@ApiModel("用户实体")
@Data
public class UserEntity implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户账号")
    @TableField("UserName")
    private String UserName;

    @ApiModelProperty(value = "用户密码")
    private String Password;

    @ApiModelProperty(value = "用户昵称")
    private String Nickname;

    @ApiModelProperty(value = "用户头像")
    private String Avatar;

    @ApiModelProperty(value = "用户性别")
    private String Gender;


    @ApiModelProperty(value = "用户手机号")
    @TableField("PhoneNo")
    private String PhoneNo;

    @ApiModelProperty(value = "是否删除")
    private String Status;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @TableField("CreateTime")
    private Date CreateTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @TableField("UpdateTime")
    private Date UpdateTime;

    public UserEntity(String id, String userName, String password, String nickname, String avatar, String gender, String phoneNo, String status, Date createTime, Date updateTime) {
        this.id = id;
        UserName = userName;
        Password = password;
        Nickname = nickname;
        Avatar = avatar;
        Gender = gender;
        PhoneNo = phoneNo;
        Status = status;
        CreateTime = createTime;
        UpdateTime = updateTime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getAvatar() {
        return Avatar;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getStatus() {
        return Status;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

}
