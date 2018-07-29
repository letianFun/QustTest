package com.qfedu.service.impl;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.dao.QuestDao;
import com.qfedu.domain.Quest;
import com.qfedu.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private QuestDao mapper;
    @Override
    public boolean insert(Quest quest) {

        return mapper.insert(quest) > 0;
    }

    @Override
    public Quest queryById(int id) {
        return mapper.queryById(id);
    }

    @Override
    public List<Quest> queryOfRandom(int count) {
        return mapper.queryOfRandom(count);
    }

    @Override
    public ResultVo update(Quest quest) {
        if (mapper.update(quest) >0) {
            return ResultVo.setOK("修改试题成功");
        }else {
            return ResultVo.setERROR("修改试题失败");
        }
    }

    @Override
    public ResultVo delete(String no) {
        if (mapper.delete(no) > 0) {
            return ResultVo.setOK("删除试题成功");
        }else {
            return ResultVo.setERROR("删除试题失败");
        }
    }

    @Override
    public PageVo<Quest> queryByPage(int page, int count) {
        PageVo<Quest> vo = new PageVo<>();
        int index = 0;
        if (page > 0) {
            index = (page - 1) * count;
        }
        List<Quest> list = mapper.queryByPage(index, count);

        if (list != null) {
            vo.setCode(0);
            vo.setMsg("");
            vo.setData(list);
            vo.setCount(mapper.queryCount().intValue());
        }else {
            vo.setCode(1);
            vo.setMsg("暂无数据");
            vo.setData(new ArrayList<>());
            vo.setCount(0);
        }

        return vo;
    }

    @Override
    public Long queryCount() {
        return mapper.queryCount();
    }



    @Override
    public boolean insertBatch(List<Quest> list) {

        try {
            for(Quest s:list) {
                mapper.insert(s);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
