package garlance.admin.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.admin.serve.entity.FrontUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FrontUserMapper extends BaseMapper<FrontUserEntity> {
    @Update("update front_user set is_del = 1 where id = #{id} and is_del = '0'")
    int del(int id);

    @Update("update front_user set is_disabled = #{state} where id =#{id} and  is_del = '0'")
    int status(int id,String state);

    @Update("update front_user set nickname = #{nickname},gender = #{gender},balance = #{balance}")
    int update(String account,String nickname,String gender,String balance);
}
