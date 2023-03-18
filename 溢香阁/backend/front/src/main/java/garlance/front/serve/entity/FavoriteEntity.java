package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * 收藏表 - 用户收藏的房源信息
 */

@Data
@TableName("favorite")
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private String id;

    //房源ID
    @TableField("HouseID")
    private String HouseID;

    //用户ID
    @TableField("UserID")
    private String UserID;

    private String Status;

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @TableField("CreateTime")
    private Date CreateTime;   //创建时间

    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss")
    @TableField("UpdateTime")
    private Date UpdateTime;   //更新时间
}
