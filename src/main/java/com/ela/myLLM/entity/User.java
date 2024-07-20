package com.ela.myLLM.entity;

public class User {
    private Integer userId;
    private String nickName;
    private String loginName;
    private String loginPwd;
    private Integer score;
    private String img;

    public User(){

    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer id){
        this.userId=id;
    }
    public String getNickName(){
        return nickName;
    }
    public void setNickName(String nickname){
        this.nickName=nickname;
    }
    public String getLoginName(){
        return loginName;
    }
    public void setLoginName(String loginname){
        this.loginName=loginname;
    }
    public String getLoginPwd(){
        return loginPwd;
    }
    public void setLoginPwd(String loginPwd){
        this.loginPwd=loginPwd;
    }
    public Integer getScore(){
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
}
