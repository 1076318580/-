package com.atguigu.team.junit;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0;i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id =1;
        try{
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
