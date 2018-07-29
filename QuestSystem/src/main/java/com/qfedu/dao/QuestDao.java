package com.qfedu.dao;

import com.qfedu.domain.Quest;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuestDao {

    //新增
    @Insert("insert into t_quest(quest,answer,createtime,createuid,flag,qtid) "
            + "value(#{quest},#{answer},now(),#{createuid},1,#{qtid})")
    int insert(Quest quest);
    //删除
    @Update("update t_quest set flag = 2 where id = #{id}")
    int delete(String id);
    //修改
    @Update("update t_quest set quest = #{quest},answer=#{answer} where id = #{id} and flag = 1")
    int update(Quest quest);
    @Select("select q.*,qt.name qtname,u.username uname from t_quest q left join t_questtype qt on q.qtid= qt.id left join t_user u on u.id = q.createuid where q.flag = 1 limit #{rowindex},#{index}")
    @ResultType(Quest.class)
    List<Quest> queryByPage(@Param("rowindex")int page, @Param("index") int index);
    //查询  分页

    //总数量
    @Select("select count(*) from t_quest where flag = 1")
    @ResultType(Long.class)
    Long queryCount();

    @Select("select * from t_quest where id=#{id} and flag = 1")
    @ResultType(Quest.class)
    Quest queryById(int id);

    @Select("select * from t_quest order by rand() limit 0,#{count}")
    @ResultType(Quest.class)
    List<Quest> queryOfRandom(int count);



}
