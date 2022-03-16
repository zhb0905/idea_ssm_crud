package org.zhb.ssm.crud.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.zhb.ssm.crud.bean.Department;
import org.zhb.ssm.crud.dao.DepartmentMapper;
import org.zhb.ssm.crud.dao.EmployeeMapper;

/**
 * @author zhb
 * @create 2022-03-16 21:59
 */

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlsession;

    @Test
    public void testMapper(){

        //部门测试
        departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));
    }
}
