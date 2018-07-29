package com.qfedu.service;


import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.QuestType;

public interface QuestTypeService {

	boolean insert(QuestType questType);
	ResultVo delete(int id);
	ResultVo update(QuestType questType);
	PageVo<QuestType> queryBypage(int page, int count);
	Long queryCount();
}
