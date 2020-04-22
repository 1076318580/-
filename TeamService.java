package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Progammer;

public class TeamService {
    private static int count = 1;//给memberId赋值使用
    private final int MAX_MEMBER = 5;//限制开发团队的人数
    private Progammer[] team = new Progammer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队中实际的人数

    public TeamService() {
    }
    public Progammer[] getTeam(){
        Progammer[] team = new Progammer[total];
        for (int i =0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }
    public void addMember(Employee e)throws TeamException{
//        成员已满，无法添加
        if (total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//        该成员不是开发人员，无法添加
        if (!(e instanceof Progammer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
//        该成员已在本开发团队中
        if (isExist(e)){
            throw new TeamException("该成员已在本开发团队中");
        }
//        该员工已是某团队成员

//        该员工正在休假，无法参加
        Progammer p = (Progammer)e;
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }else if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");

        }
//        团队中至少只能由一名架构师
//        团队中至少只能有两名设计师
//        团队中至多只能有3名程序员
        //获取team已有成员中架构师，设计师，程序员的人数
        int numOfArch =0,numOfDes = 0,nuOfPro = 0;
        for (int i=0;i<total;i++){
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;

            } else if (team[i] instanceof Progammer){
                nuOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if (p instanceof Designer){
            if (numOfDes>=2){
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Progammer) {
            if (nuOfPro>=3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //错误的
//        if (p instanceof Architect && numOfArch >= 1){
//            throw new TeamException("团队中至多只能有一名架构师");
//        }else if (p instanceof Designer&&numOfDes>=2){
//            throw new TeamException("团队中至多只能有两名设计师");
//        } else if (p instanceof Progammer && nuOfPro >= 3) {
//            throw new TeamException("团队中至多只能有三名程序员");
//        }
        //将p（或e）添加到现有的team中
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(count++);

    }

    private boolean isExist(Employee e) {
        for (int i=0;i<total;i++){
           return team[i].getId() ==e.getId();
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i=0;
        for (;i<total;i++){
            if (team[i].getMemberId() ==memberId){
               team[i].setStatus(Status.FREE);
               break;
            }
        }
        //为找到指定memberId的情况
        if (i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int j =i+1;j<total;j++){
            team[j-1] = team[j];
        }
        team[--total] = null;


    }
}
