package garlance.admin.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.admin.serve.entity.FrontHomeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FrontHomeMapper extends BaseMapper<FrontHomeEntity> {
    @Update("update front_home set is_del = 1 where id = #{id} and is_del = '0'")
    int del(int id);

    @Update("update front_home set status = #{state} where id =#{id} and  is_del = '0'")
    int status(int id,String state);
}
