package com.atguigu.team.service;
//自定义异常类
public class TeamException extends Exception{
    static final long serialVersionUID = -33875169939948L;

    public TeamException(){

    }
    public TeamException(String msg){
        super(msg);
    }
}
