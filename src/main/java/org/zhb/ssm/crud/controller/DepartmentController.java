package org.zhb.ssm.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhb.ssm.crud.bean.Department;
import org.zhb.ssm.crud.bean.Msg;
import org.zhb.ssm.crud.service.DepartmentService;

import java.util.List;

/**
 * @author zhb
 * @create 2022-03-17 3:19
 */
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 返回所有部门信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("dept",list);
    }
}
