package com.qfedu.service;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.Quest;

import java.util.List;

public interface QuestService {


    //试题
    boolean insert(Quest quest);
    ResultVo update(Quest quest);
    ResultVo delete(String id);
    PageVo<Quest> queryByPage(int page, int count);
    Long queryCount();

    boolean insertBatch(List<Quest> list);
    Quest queryById(int id);
    List<Quest> queryOfRandom(int count);
}
