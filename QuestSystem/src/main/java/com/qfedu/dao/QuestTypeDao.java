package com.qfedu.dao;

import com.qfedu.domain.QuestType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuestTypeDao {

    //新增
    @Insert("insert into t_questtype(name,flag,type)"
            + "values(#{name},1,#{type})")
    int insert(QuestType questType);

    //删除
    @Update("update t_questtype set flag=2 where id = #{id}")
    int delete(int id);

    //修改
    @Update("update t_questtype set name = #{name},type = #{type} where id = #{id}")
    int update(QuestType questType);

    //分页查询
    @Select("select * from t_questtype where flag = 1 limit #{rowindex},#{index}")
    @ResultType(QuestType.class)
    List<QuestType> queryByPage(@Param("rowindex")int index, @Param("index")int count);

    //查询总数
    @Select("select count(*) from t_questtype where flag = 1")
    @ResultType(QuestType.class)
    Long queryCount();

}
