package com.qfedu.web.controller;


import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.Quest;
import com.qfedu.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class QuestController {
    @Autowired
    private QuestService service;



    //新增

    @RequestMapping(value="questadd.do",method= {RequestMethod.POST})

    public String fileupload(Quest quest) throws Exception {


        if (service.insert(quest)) {

            return "questlist";
        }else {
            return "questadd";
        }

    }
/*
    //修改--------基于Ajax
    @RequestMapping(value="/staffupdate1.do",method= {RequestMethod.POST})
    public ResultVo updateAjax(Quest quest) {
        return service.update(quest);
    }*/

    @RequestMapping(value = "/questupdate.do")
    public String updateForm(Quest quest) {

        if (service.update(quest).getCode() == 1000) {
            return "questlist";
        }else {
            return "questupdate";
        }

    }
    //删除
    @RequestMapping(value="/questdelete.do",method= {RequestMethod.POST})
    @ResponseBody
    public ResultVo delete(String id) {
        return service.delete(id);
    }


    //查询
    @RequestMapping(value = "/questpage.do")
    @ResponseBody
    public PageVo<Quest> queryPage(int page, @RequestParam("limit")int count){
        return service.queryByPage(page, count);
    }

    @RequestMapping(value = "/stuquestdo.do")
    @ResponseBody
    public List<Quest> queryNum(int num, HttpSession session){
        List<Quest> list =service.queryOfRandom(num);
        session.setAttribute("results",list);
        return list;
    }

}
