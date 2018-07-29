package com.qfedu.service.impl;

import com.qfedu.common.vo.AllUserTestVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.dao.TestDao;
import com.qfedu.dao.UserDao;
import com.qfedu.domain.Test;
import com.qfedu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestDao dao;

    @Autowired
    private UserDao userDao;


    //新增测试
    @Override
    public boolean insert(int uid,int questnum) {
        return dao.insert(uid,questnum) > 0;
    }

    //完成时间
    @Override
    public boolean updateEndtime(int id,int truenum) {
        return dao.updateEndtime(id,truenum) > 0;
    }

    @Override
    public ResultVo testdelete(int id) {
        if (dao.testdelete(id) > 0) {
            return ResultVo.setOK("删除成功");
        }else{
            return ResultVo.setERROR("删除失败");
        }

    }

    @Override
    public PageVo<AllUserTestVo> queryAllTest(int page, int count) {

        PageVo<AllUserTestVo> vo = new PageVo<>();
        int index = 0;

        if (page > 0){
            index = (page - 1) * count;
        }
        List<AllUserTestVo> list = dao.queryAllTest(index,count);

        if (list != null){
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(userDao.queryUserCount().intValue());
        }else {
            vo.setCode(1);
            vo.setMsg("暂无人员做题");
            vo.setCount(0);
            vo.setData(new ArrayList<>());
        }


        return vo;
    }

    //分页查询
    @Override
    public PageVo<Test> queryByPage(int page, int count) {

        PageVo<Test> vo = new PageVo<>();
        int index = 0;

        if (page > 0){
            index = (page - 1) * count;
        }
        List<Test> list = dao.queryByPage(index,count);

        if (list != null){
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(dao.queryCount().intValue());
        }else {
            vo.setCode(1);
            vo.setMsg("暂无人员做题");
            vo.setCount(0);
            vo.setData(new ArrayList<>());
        }


        return vo;
    }

    @Override
    public Long queryCount(int id) {
        return dao.queryCount();
    }

    @Override
    public PageVo<Test> queryByPageUser(int page, int count, int uid) {

        PageVo<Test> vo = new PageVo<>();
        int index = 0;

        if (page > 0){
            index = (page - 1) * count;
        }
        List<Test> list = dao.queryByPageUser(index,count,uid);

        if (list != null){
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(dao.queryCountUser(uid).intValue());
        }else {
            vo.setCode(1);
            vo.setMsg("暂无练习题历史数据,快去做题吧");
            vo.setCount(0);
            vo.setData(new ArrayList<>());
        }


        return vo;
    }

    @Override
    public Long queryCountUser(int uid) {
        return dao.queryCountUser(uid);
    }

    @Override
    public Long queryTestID(int uid) {
        return dao.queryTestID(uid);
    }

}
