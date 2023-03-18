package garlance.admin.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import garlance.admin.serve.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    @Update("update sys_user set nickname = #{nickname} , password = #{password},salt = #{salt} where account = #{account}")
    int updateAdmin(String account,String nickname,String password,String salt);
}
