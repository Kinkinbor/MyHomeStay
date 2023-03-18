package garlance.front.serve.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("district")
public class DistrictEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键id
    private Long id;

    //地区编码
    private String treeCode;

    //名称
    private String name;

    //全称
    private String fullName;
}
