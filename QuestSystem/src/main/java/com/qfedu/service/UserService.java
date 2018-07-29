package com.qfedu.service;

import com.qfedu.common.vo.ResultVo;
import com.qfedu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface UserService {

    User queryByName(String username, String password,int role);
    User queryByStuName(String useruname,int role);
    ResultVo insert(User user);
    boolean updateLoginTime(String username);
}
