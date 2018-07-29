package com.qfedu.web.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.common.vo.PageVo;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.common.vo.TestDetailVO;
import com.qfedu.domain.TestDetail;
import com.qfedu.domain.User;
import com.qfedu.service.TestDetailService;
import com.qfedu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class TestDetailController {

    @Autowired
    private TestDetailService detailService;

    @Autowired
    private TestService service;


    //用户做题完成，拿到用户做题的数据
    @RequestMapping("/testdetailadd.do")
    @ResponseBody
    public ResultVo testDeatilAdd(String testdetails,int truenum,HttpSession session) {

        //已经获得到了qid,uanswer,istf
        try {
            User user =(User) session.getAttribute("user");
            //查询当前用户测试表的ID,目前仅为结束时间为空就表示是用户要获取的ID
            int testid = service.queryTestID(user.getId()).intValue();

            //将编码过得url数据进行解码
            String decode = java.net.URLDecoder.decode(testdetails, "UTF-8");
            //去掉编码数据里的
            String tests = (String) JSON.parse(decode);
            //将json数据进行解析
            List<TestDetail> list = JSON.parseArray(tests,TestDetail.class);
            //将用户数据插入数据库
            for (TestDetail detail : list){
                //System.err.println(detail);
                detail.setTid(testid);
                detailService.insertTDtail(detail);
            }
            //插入用户的完成时间和做对的题
            service.updateEndtime(testid,truenum);
            return ResultVo.setOK("提交成功,是否继续做题？");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResultVo.setERROR("提交失败,请重新提交！！");
        }
    }


    //查询测试详情
    @RequestMapping("/stuquestdetail.do")
    @ResponseBody
    public List<TestDetailVO> testDetailVOList(int tid,HttpSession session){
        User user =(User) session.getAttribute("user");

        return detailService.queryByTid(user.getId(),tid);
    }
    //查询测试详情
    @RequestMapping("/admindetail.do")
    @ResponseBody
    public List<TestDetailVO> adminDetailVOList(int tid,int uid){
        return detailService.queryByTid(uid,tid);
    }




}
