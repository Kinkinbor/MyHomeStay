package garlance.admin.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("front_home")
public class FrontHomeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;        //房源id

    private Long userId;    //绑定的用户id

    private String name;     //房源名称

    private String photo;        //房源照片

    private String location;    //房源位置

    private String price;        //房源价格(元/天)

    private Long info_id;        //绑定的房源拥有属性id-是否有wifi、床铺数等等

    private String status;       //房源状态-0审核中/1已上架/2已下架

    private String isDel;       //是否删除 0：正常 1.删除

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date createTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    private Date updateTime;   //更新时间
}
