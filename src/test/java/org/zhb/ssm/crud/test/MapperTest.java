package org.zhb.ssm.crud.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.zhb.ssm.crud.bean.Department;
import org.zhb.ssm.crud.bean.Employee;
import org.zhb.ssm.crud.dao.DepartmentMapper;
import org.zhb.ssm.crud.dao.EmployeeMapper;

import java.util.UUID;

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

        //插入员工数据测试
        employeeMapper.insertSelective(new Employee(null,"张三","M","zhangsan@qq.com",1));
        employeeMapper.insertSelective(new Employee(null,"李四","M","lisi@163.com",1));
        employeeMapper.insertSelective(new Employee(null,"王五","M","wangwu@sina.com",1));

        //批量插入员工数据
        EmployeeMapper mapper = sqlsession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 100; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,uid,"W",uid+"@gmail.com",2));

        }
    }
}
