package org.zhb.ssm.crud.service;


import org.zhb.ssm.crud.bean.Employee;

import java.util.List;

/**
 * @author zhb
 * @create 2022-03-17 2:09
 */
public interface EmployeeService {
    List<Employee> getAll();

    void saveEmp(Employee employee);

    Boolean checkUser(String empName);

    Employee getEmp(Integer empId);

    void updateEmp(Employee employee);

    void deleteEmpById(Integer empId);

    void deleteBatch(List<Integer> ids);
}
