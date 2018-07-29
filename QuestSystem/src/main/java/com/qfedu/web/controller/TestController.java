package com.qfedu.web.controller;


import com.qfedu.common.vo.AllUserTestVo;
import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.Quest;
import com.qfedu.domain.Test;
import com.qfedu.domain.User;
import com.qfedu.service.TestDetailService;
import com.qfedu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    private TestService service;

    @Autowired
    private TestDetailService detailService;


    //用户开始做题进行对测试表的操作
    @RequestMapping("/testadd.do")
    public void testAdd(int num,HttpSession session){
        User user =(User) session.getAttribute("user");
        service.insert(user.getId(),num);
    }

    //删除test
    @RequestMapping("/testdelete.do")
    @ResponseBody
    public ResultVo testdelete(int id){
        return service.testdelete(id);
    }

    //查询所有用户的测试信息
    @RequestMapping("/allusertestpage.do")
    @ResponseBody
    public PageVo<AllUserTestVo> showAllUserPage(int page, @RequestParam("limit") int count){
        return service.queryAllTest(page,count);
    }


    //用户查询测试的分页
    @RequestMapping("/stutestpage.do")
    @ResponseBody
    public PageVo<Test> showPage(int page, @RequestParam("limit") int count,HttpSession session){

        User user = (User) session.getAttribute("user");
        return   service.queryByPageUser(page,count,user.getId());
    }

    //用户查询测试的分页
    @RequestMapping("/usertestpage.do")
    @ResponseBody
    public PageVo<Test> showPage(int uid,int page, @RequestParam("limit") int count){


        return   service.queryByPageUser(page,count,uid);
    }




}
