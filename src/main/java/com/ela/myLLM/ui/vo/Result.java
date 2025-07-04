package com.ela.myLLM.ui.vo;

public class Result {
    private Integer code;
    private String msg;
    private Object data;
    public Result(){
    }
    public Result(Integer code, String msg, Object data){
        this.code = code;
        this.msg=msg;
        this.data=data;
    }
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
