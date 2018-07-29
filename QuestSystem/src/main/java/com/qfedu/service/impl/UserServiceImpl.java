package com.qfedu.service.impl;

import com.qfedu.common.utils.MD5Utils;
import com.qfedu.common.vo.ResultVo;
import com.qfedu.dao.UserDao;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    @Override
    public User queryByName(String username,String password, int role) {

        User user = dao.queryByName(username, role);

        if (user != null) {
            if (Objects.equals(user.getPassword(),MD5Utils.md5(password))){
                return user;
            }
        }

        return null;
    }
    @Override
    public User queryByStuName(String username, int role) {
        return dao.queryByName(username,role);
    }

    @Override
    public ResultVo insert(User user) {
        //将用户的密码进行加密放入数据库
        user.setPassword(MD5Utils.md5(user.getPassword()));
        if(dao.insert(user) > 0){
            return  ResultVo.setOK("注册成功");
        }else{
            return ResultVo.setERROR("注册失败");
        }

    }


    @Override
    public boolean updateLoginTime(String username) {
        return dao.updateLoginTime(username) > 0;
    }
}
