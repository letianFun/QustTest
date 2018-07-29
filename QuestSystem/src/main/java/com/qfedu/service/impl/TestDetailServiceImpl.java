package com.qfedu.service.impl;

import com.qfedu.common.vo.TestDetailVO;
import com.qfedu.dao.TestDetailDao;
import com.qfedu.domain.TestDetail;
import com.qfedu.service.TestDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDetailServiceImpl implements TestDetailService {

    @Autowired
    private TestDetailDao dao;

    //新增详情
    @Override
    public boolean insertTDtail(TestDetail testDetail) {
        return dao.insertTDtail(testDetail) > 0;
    }

    @Override
    public List<TestDetailVO> queryByTid(int uid,int tid) {
        return dao.queryByTid(uid,tid);
    }
}
