package garlance.admin.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.admin.serve.entity.FrontOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FrontOrderMapper extends BaseMapper<FrontOrderEntity> {
    @Update("update front_order set is_del = 1 where id = #{id} and is_del = '0'")
    int del(int id);

}
