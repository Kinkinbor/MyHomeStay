package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 订单表 - 记录平台产生的订单
 */

@Data
@TableName("booking")
public class BookingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;

    //房源id
    private Long HouseID;

    //用户ID
    private Long UserID;

    //入住时间
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CheckInDate;

    //离开时间
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CheckOutDate;

    //成人数量
    private int Adults;

    //儿童数量
    private int Children;

    //交易金额
    private String TotalPrice;

    //状态
    private String Status;

    //创建时间
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;   //创建时间

    //更新时间
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;   //更新时间
}
