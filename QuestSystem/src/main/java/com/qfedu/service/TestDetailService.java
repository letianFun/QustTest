package com.qfedu.service;

import com.qfedu.common.vo.TestDetailVO;
import com.qfedu.domain.TestDetail;

import java.util.List;

public interface TestDetailService {
    //新增测试详情
    boolean insertTDtail(TestDetail testDetail);

    //查询测试详情
    List<TestDetailVO> queryByTid(int uid,int tid);

}
