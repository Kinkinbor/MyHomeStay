package garlance.admin.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("front_order")
public class FrontOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;        //订单ID

    private Long userId;    //用户ID

    private Long homeId;    //房源ID

    private String homeName;    //房源名称

    private String homePrice;   //房源价格

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date inTime;     //入住时间

    private int inDays;        //入住天数

    private int inSum;    //入住人数

    private String transactionAmount;        //交易金额

    private String paymentStatus;        //支付状态 0-未支付，1-已支付，2-已取消

    private String paymentMethod;       //支付方法，微信，支付宝，银联等。。

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date payTime;       //支付时间

    private String isDel;       //是否删除 0：正常 1.删除

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;   //更新时间，充当订单完成时间
}
