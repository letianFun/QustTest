package com.qfedu.web.controller;

import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;

import com.qfedu.domain.QuestType;
import com.qfedu.service.QuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestTypeController {

	
	@Autowired
	private QuestTypeService service;
	
	//新增
	@RequestMapping(value="/questtypeadd.do",method= {RequestMethod.POST})
	public String insert(QuestType course) {
		if (service.insert(course)) {
			return "questtypelist";
		}else {
			return "questtypeadd";
		}
	}
	/*//修改 基于Ajax
	@RequestMapping(value = "/questtypeupdate1.do",method= {RequestMethod.POST})
	public ResultVo updateAjax(QuestType course) {
		return service.update(course);
	}
	*/
	//基于form表单
	@RequestMapping(value = "/questtypeupdate.do", method= {RequestMethod.POST})
	
	public String updateForm(QuestType course) {
		if (service.update(course).getCode() == 1000) {
			return "questtypelist";
		}else {
			return "questtypeupdate";
		}
	}
	
	//删除
	@RequestMapping(value = "/questtypedelete.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}
	
	//查询
	@RequestMapping(value = "/cquesttypepage.do")
	@ResponseBody
	public PageVo<QuestType> queryByPage(int page, @RequestParam("limit")int count) {
		return service.queryBypage(page, count);
	}
	
}
