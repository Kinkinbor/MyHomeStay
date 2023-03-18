package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价表-用户评价房源的信息
 */

@Data
@TableName("review")
public class ReviewEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;

    //预订ID
    private Long BookingID;

    //房源ID
    private Long UserID;

    //评价内容
    private String Content;

    //评分
    private String Rating;

    private String Status;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date UpdateTime;   //更新时间
}
