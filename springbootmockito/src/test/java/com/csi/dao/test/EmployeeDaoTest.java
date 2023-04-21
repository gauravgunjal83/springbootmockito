package com.csi.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    
    @Test
    public void saveDataTest(){

        Employee employee=new Employee(1,"gaurav","pcmc",87000,"gaurav@123");
         employeeDaoImpl.saveData(employee);
         verify(employeeRepoImpl,times(1)).save(employee);
    }
    @Test
    public void getAllDataTest(){

        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee (1,"Gaurav","pcmc",56000,"gaurav@123"),
                new Employee(2,"rohit","pune",60000,"rohit@123")).collect(Collectors.toList()));

        assertEquals(2, employeeDaoImpl.getAllData().size());
    }
    @Test
    public void updateDataTest(){

        Employee employee=new Employee(1,"Gaurav","pcmc",56000,"gaurav@123");
        employeeDaoImpl.updateData(employee);
        verify(employeeRepoImpl,times(1)).save(employee);
    }
    @Test
    public void deleteDatabyIdTest(){
        Employee employee=new Employee(1,"Gaurav","pcmc",56000,"gaurav@123");
        employeeDaoImpl.deleteDataById(employee.getEmpId());
        verify(employeeRepoImpl,times(1)).deleteById(employee.getEmpId());
    }
}
