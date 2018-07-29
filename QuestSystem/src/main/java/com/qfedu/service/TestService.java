package com.qfedu.service;

import com.qfedu.common.vo.AllUserTestVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.Test;
import com.qfedu.domain.TestDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestService {


    //新增测试
    boolean insert(int uid,int questnum);

    //记录完成时间
    boolean updateEndtime(int id,int truenum);

    //删除测试
    ResultVo testdelete(int id);

    //查询所有的用户测试
    PageVo<AllUserTestVo> queryAllTest(int page, int index);

    //查询分页---管理员
    PageVo<Test> queryByPage(int page, int index);
    Long queryCount(int id);

    //查询测试分页----单个用户
    PageVo<Test> queryByPageUser(int page,int index,int uid);
    Long queryCountUser(int uid);

    //根据UID查询
    Long queryTestID(int uid);
}
