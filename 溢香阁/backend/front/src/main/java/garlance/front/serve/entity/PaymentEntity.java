package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("payment")
public class PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long BookingID;

    private Long UserID;

    private String Amount;

    private String PaymentMethod;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date PayTime;

    private String Status;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date UpdateTime;




}
