package org.zhb.ssm.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhb.ssm.crud.bean.Employee;
import org.zhb.ssm.crud.bean.EmployeeExample;
import org.zhb.ssm.crud.dao.EmployeeMapper;
import org.zhb.ssm.crud.service.EmployeeService;

import java.util.List;

/**
 * @author zhb
 * @create 2022-03-17 2:30
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    @Override
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    @Override
    public Boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        //count 当前用户名数量
        long count = employeeMapper.countByExample(example);
        return count == 0; //true代表用户名可用
    }

    @Override
    public Employee getEmp(Integer empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public void deleteEmpById(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
