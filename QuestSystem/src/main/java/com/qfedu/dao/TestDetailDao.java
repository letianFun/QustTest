package com.qfedu.dao;

import com.qfedu.common.vo.TestDetailVO;
import com.qfedu.domain.TestDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDetailDao {

    //新增测试详情表
    @Insert("insert into t_testdetail(tid,qid,istf,uanswer) values(#{tid},#{qid},#{istf},#{uanswer})")
    int insertTDtail(TestDetail testDetail);

    //根据测试查询详情表每条记录
    @Select("select u.username uname,t.*,td.*,q.quest,q.answer from t_test t left join t_user u on t.uid=u.id " +
            "right join t_testdetail td on td.tid = t.id left join t_quest q on td.qid = q.id " +
            "where u.id = #{uid} and t.id=#{tid} and t.flag =1")
    @ResultType(TestDetailVO.class)
    List<TestDetailVO> queryByTid(@Param("uid") int uid,@Param("tid") int tid);






}
