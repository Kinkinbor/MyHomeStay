package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 对话表 租客和房东对话
 */

@Data
@TableName("conversation")
public class ConversationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Long id;

    //发送者ID
    private Long SenderID;

    //发送者姓名
    private String SenderName;

    //接收者ID
    private Long ReceiverID;

    //接收者姓名
    private String ReceiverName;

    //发送内容
    private String Content;

    //是否删除
    private String Status;       //是否删除 0：正常 1.删除

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date UpdateTime;   //更新时间
}
