package com.ela.myLLM.service.impl;

import com.ela.myLLM.entity.Record;
import com.ela.myLLM.entity.User;
import com.ela.myLLM.mapper.RecordMapper;
import com.ela.myLLM.mapper.UserMapper;
import com.ela.myLLM.service.RecordService;
import com.ela.myLLM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    //除了操作record还能操作user，因为要通过user来操作，所以权限以下操作两个
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addRecord(Integer token, Integer userId,String question,String response) {
        try{
//            tran.beginTrain(); 伪代码，表示事务开始
            Record r=new Record();
            r.setUserId(userId);
            r.setToken(token);
            r.setPay(0);
            r.setQuestion(question);
            r.setResponse(response);
            Integer tt=0;
            int count=recordMapper.selectCountByDate(new Date(),userId);
            System.out.println("已消费"+count+"次");
            if(count>5){
                tt=token/10;
            }
            //先查用户的分 确认分到底够不够
            r.setPay(tt);
            User user=userMapper.selectById(userId);
            if(user.getScore()<tt)
                throw new RuntimeException("积分不够");
            user.setScore(user.getScore()-tt);
            userMapper.update(user);
            recordMapper.insert(r);
        }catch(RuntimeException e){
            e.printStackTrace();
//            tran.rollback(); 伪代码，表示事务异常需要回滚
            throw e;
        }
    }

    @Override
    public List<Record> selectByUser(Integer userId) {
        List<Record>list=recordMapper.selectByUser(userId);
        return list;
    }

    @Override
    public Integer queryCountByDate(Integer userId) {
        return recordMapper.selectCountByDate(new Date(),userId);
    }
}
