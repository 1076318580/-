package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Progammer extends  Employee {
    private  int memberId;//开发团队的id
    private Status status=Status.FREE;//枚举类
    private Equipment equipment;

    public Progammer() {
    }

    public Progammer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails()+"\t程序员\t" + status +"\t\t\t\t\t"+
                 equipment.getDescription() ;

    }
    public String getDetailsForTeam(){
        return memberId + "/" + getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员\t";
    }
}