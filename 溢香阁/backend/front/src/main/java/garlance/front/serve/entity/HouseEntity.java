package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 房源表 - 记录房源的信息
 */

@Data
@TableName("house")
public class HouseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @TableField("id")
    private String id;

    //房东id
    @TableField("HostID")
    private String HostID;

    //标题
    @TableField("Title")
    private String Title;

    //描述
    @TableField("Description")
    private String Description;

    //属性，存放json字段
    @TableField("Info")
    private String Info;

    //地址
    @TableField("Address")
    private String Address;

    //城市
    @TableField("City")
    private String City;

    //区域
    @TableField("District")
    private String District;

    //星级
    @TableField("StarRating")
    private String StarRating;

    //房源价格
    @TableField("Price")
    private int Price;

    //床位
    @TableField("Beds")
    private String Beds;

    //户型
    @TableField("Type")
    private String Type;

    //图片
    @TableField("Images")
    private String Images;

    //房源状态
    @TableField("Status")
    private String Status;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @TableField("CreateTime")
    private Date CreateTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    @TableField("UpdateTime")
    private Date UpdateTime;   //更新时间
}