package org.zhb.ssm.crud.test;

/**
 * @author zhb
 * @create 2022-03-17 19:29
 */

import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zhb.ssm.crud.bean.Employee;

import java.util.List;

/**
 * 需要先开启 EmployeeController.getEmps()
 * 需注释掉 EmployeeController.getEmpsWithJson()
 */

@WebAppConfiguration
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class MVCTest {

    //传入MVC的IOC容器
    @Autowired
    WebApplicationContext context;

    //虚拟MVC请求，处理获取结果
    MockMvc mockMvc;

    @BeforeEach
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求，返回result
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
       //请求成功后，取请求域中的PageInfo来验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+pi.getPageNum());
        System.out.println("总页码数："+pi.getPages());
        System.out.println("总记录数"+pi.getTotal());
        System.out.println("连续显示的页码");
        for (int i:
             pi.getNavigatepageNums()) {
            System.out.println(" "+i);
        }

        //获取员工信息
        List<Employee> list = pi.getList();
        for (Employee employee:
             list) {
            System.out.println("ID:"+employee.getEmpId()+"==Name:"+employee.getEmpName());
        }

    }
}

