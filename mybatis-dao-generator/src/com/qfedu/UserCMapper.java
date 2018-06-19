package com.qfedu;

import com.qfedu.mybatisuser.pojo.UserC;
import com.qfedu.mybatisuser.pojo.UserCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCMapper {
    long countByExample(UserCExample example);

    int deleteByExample(UserCExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserC record);

    int insertSelective(UserC record);

    List<UserC> selectByExample(UserCExample example);

    UserC selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserC record, @Param("example") UserCExample example);

    int updateByExample(@Param("record") UserC record, @Param("example") UserCExample example);

    int updateByPrimaryKeySelective(UserC record);

    int updateByPrimaryKey(UserC record);
}