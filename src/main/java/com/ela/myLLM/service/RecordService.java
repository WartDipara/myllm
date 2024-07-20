package com.ela.myLLM.service;

import com.ela.myLLM.entity.Record;

import java.util.Date;
import java.util.List;


public interface RecordService {
    //添加记录
    public void addRecord(Integer token,Integer userId,String question,String response);
    //根据用户查记录
    public List<Record> selectByUser(Integer userId);
    //查询 查询次数
    public Integer queryCountByDate(Integer userId);
}
