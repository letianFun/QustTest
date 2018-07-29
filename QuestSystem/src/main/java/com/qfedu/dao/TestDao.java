package com.qfedu.dao;

import com.qfedu.common.vo.AllUserTestVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.domain.Quest;
import com.qfedu.domain.Test;
import com.qfedu.domain.TestDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TestDao {

    //新增测试
    @Insert("insert into t_test(uid,starttime,questnum,flag) values(#{uid},now(),#{questnum},1)")
    int insert(@Param("uid") int uid,@Param("questnum") int questnum);

    //做题完成时间和对题数目
    @Update("update t_test set endtime=now(),truenum =#{truenum} where id=#{id}")
    int updateEndtime(@Param("id") int id,@Param("truenum") int truenum);

    //按照id删除测试
    @Update("update t_test set flag = 2 where id = #{id}")
    int testdelete(int id);

    //#查询所有用户的测试信息
    @Select("select u.id uid,u.username uname,MAX(t.endtime) endtime,count(t.id) testnum from t_user u right JOIN t_test t on u.id = t.uid  where t.flag = 1 GROUP BY t.uid limit #{rowindex},#{index}")
    @ResultType(AllUserTestVo.class)
    List<AllUserTestVo> queryAllTest(@Param("rowindex")int page, @Param("index") int index);

    //查询  分页
    @Select("select u.username uname,u.role urole,t.* from t_test t left join t_user u on t.uid = u.id where t.flag = 1  limit #{rowindex},#{index}")
    @ResultType(Test.class)
    List<Test> queryByPage(@Param("rowindex")int page, @Param("index") int index);
    //总数量
    @Select("select count(*) from t_test where flag = 1")
    @ResultType(Long.class)
    Long queryCount();


    //查询个人测试分页
    //查询  分页
    @Select("select u.username uname,u.flag uflag,t.* from t_test t left join t_user u on t.uid = u.id where uid=#{uid} and t.flag = 1 limit #{rowindex},#{index}")
    @ResultType(Test.class)
    List<Test> queryByPageUser(@Param("rowindex")int page, @Param("index") int index,@Param("uid") int uid);
    //总数量
    @Select("select count(*) from t_test where uid=#{uid} and flag = 1")
    @ResultType(Long.class)
    Long queryCountUser(int uid);

    //根据用户UID查询当前要提交的test的ID
    @Select("select id from t_test where uid =#{uid} and endtime is null")
    Long queryTestID(int uid);
}
