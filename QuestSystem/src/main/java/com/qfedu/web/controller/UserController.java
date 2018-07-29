package com.qfedu.web.controller;


import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //检查用户名是否重复'
    @RequestMapping("/checkname.do")
    @ResponseBody
    public ResultVo checkName(String username){
        if (service.queryByStuName(username,1) == null) {
            return ResultVo.setOK("用户名可用");
        }else{
            return ResultVo.setERROR("用户名重复,换一个试试吧");
        }
    }

    //注册
    @RequestMapping(name = "/useradd.do",method = {RequestMethod.POST})
    public String userAdd(User user){
        if(service.insert(user).getCode() == 1000){
            return "login";
        }else {
            return "register";
        }
    }
    //登录
    @RequestMapping("/login.do")
    public String stuLogin(String username,String password,int role, HttpSession session){
        User user = service.queryByName(username, password,role);
        if (user != null) {
            session.setAttribute("user",user);
            if(role == 1){
                return "stuindex";
            }else{
                return "index";
            }

        }else{
            return "login";
        }
    }


    //注销
    @RequestMapping("/loginout.do")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
}



