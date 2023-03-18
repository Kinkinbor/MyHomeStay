package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("host")
public class HostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String HostName;

    private String PhoneNo;

    private Long IDNumber;

    private Long BackCard;

    private String Address;

    private String Balance;

    private String Status;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date UpdateTime;


}
