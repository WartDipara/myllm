package com.ela.myLLM.service.impl;

import com.ela.myLLM.entity.User;
import com.ela.myLLM.mapper.UserMapper;
import com.ela.myLLM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service //加这个注解可以放进spring容器里面去，才可以在界面层找到他
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User searched=userMapper.selectByLoginName(user.getLoginName());
        if(searched!=null&&user.getLoginPwd().equals(searched.getLoginPwd())){
            return searched;
        }
        return null;
    }
    @Override
    @Transactional
    public User register(User user) {
//        boolean check=vaildateUser(user);
//        if(check){
//            userMapper.insert(user);
//            return userMapper.selectByLoginName(user.getLoginName());
//        }
//        return null;
        try{
            boolean check=vaildateUser(user);
            if(check){
                userMapper.insert(user);
                return userMapper.selectByLoginName(user.getLoginName());
            }
        }catch(Exception e){
            throw new RuntimeException("用户名已存在");
        }
        throw new RuntimeException("错误注册");
    }

    private boolean vaildateUser(User user){
        if(user.getNickName().trim().isEmpty() || user.getNickName()==null ){
            throw new RuntimeException("用户名不能为空");
        }
        if(user.getLoginName().trim().isEmpty() || user.getLoginName()==null){
            throw new RuntimeException("账号不能为空");
        }
        if(user.getLoginPwd().trim().isEmpty() || user.getLoginPwd()==null){
            throw new RuntimeException("登录密码不能为空");
        }
        return true;
    }
}
