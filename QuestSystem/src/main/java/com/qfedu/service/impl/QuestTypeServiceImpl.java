package com.qfedu.service.impl;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;

import com.qfedu.dao.QuestTypeDao;

import com.qfedu.domain.QuestType;

import com.qfedu.service.QuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestTypeServiceImpl implements QuestTypeService {

	@Autowired
	private QuestTypeDao mapper;

	@Override
	public boolean insert(QuestType questType) {
		return mapper.insert(questType) > 0;
	}

	@Override
	public ResultVo delete(int id) {
		if (mapper.delete(id) > 0) {
			return ResultVo.setOK("删除成功");
		}else {
			return ResultVo.setERROR("删除失败");
		}
	}

	@Override
	public ResultVo update(QuestType questType) {
		if (mapper.update(questType) > 0) {
			return ResultVo.setOK("修改类型成功");
		}else {
			return ResultVo.setERROR("修改类型失败");
		}
	}

	@Override
	public PageVo<QuestType> queryBypage(int page, int count) {
		
		PageVo<QuestType> vo = new PageVo<>();
		
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		
		List<QuestType> list = mapper.queryByPage(index, count);
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
		return null;
	}
	
	
}
