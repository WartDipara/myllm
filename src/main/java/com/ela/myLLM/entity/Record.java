package com.ela.myLLM.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Record {
    private Integer id; //自增长，其实不用理
    private Integer userId; //操作的人是谁
    private Integer token; //使用了多少token
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date oprtime;   //操作时间
    private Integer pay; //支付积分
    private String question; //提问
    private String response; //回答

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String userNickname;//增加外键字段 承载join表的结果

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Date getOprtime() {
        return oprtime;
    }

    public void setOprtime(Date oprtime) {
        this.oprtime = oprtime;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
