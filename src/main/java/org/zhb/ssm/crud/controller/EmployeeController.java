package org.zhb.ssm.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.zhb.ssm.crud.bean.Employee;
import org.zhb.ssm.crud.bean.Msg;
import org.zhb.ssm.crud.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhb
 * @create 2022-03-17 3:53
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 批量删除（支持单个删除）
     */
    @DeleteMapping("/emp/{ids}")
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("ids") String ids){
        if(ids.contains("-")) {
            String[] strIds = ids.split("-");
            List<Integer> del_ids = new ArrayList<>();
            for (String strId: strIds) {
                del_ids.add(Integer.parseInt(strId));
            }
            employeeService.deleteBatch(del_ids);
        }else {
            Integer empId = Integer.parseInt(ids);
            employeeService.deleteEmpById(empId);
        }
        return Msg.success();
    }

    /**
     * 修改员工信息
     */
    @PutMapping("/emp/{empId}")
    @ResponseBody
    public Msg updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
     * 查询员工信息
     * @return
     */
    @GetMapping("/emp/{empId}")
    @ResponseBody
    public Msg getEmp(@PathVariable("empId") Integer empId) {
        Employee employee = employeeService.getEmp(empId);
        return Msg.success().add("emp",employee);
    }

    /**
     * 检验用户名是否可用
     */
    @GetMapping("/checkUser")
    @ResponseBody
    public Msg checkUser(@RequestParam("empName") String empName) {
        String regEx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if(!empName.matches(regEx)) {
            return Msg.fail().add("va_msg","用户名必须是2-5位中文或者6-16位英文和数字的组合");
        }
        if(employeeService.checkUser(empName)) {
            return Msg.success();
        }
        return Msg.fail().add("va_msg","用户名已存在");
    }


    /**
     * JSP303校验，保存新存用户数据
     *
     */
    @PostMapping("/emp")
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result) {
        if(result.hasErrors()) {
            //校验失败，在模态框中显示错误信息
            Map<String, Object> map = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }
        employeeService.saveEmp(employee);
        return Msg.success();
    }

    /**
     * index.jsp匹配这个url
     * 分页查询所有员工的数据，需要导入Jackson的包
     * MVCtest时，需注释掉
     */
    @GetMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn,7);
        List<Employee> emps = employeeService.getAll();
        PageInfo pageInfo = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo",pageInfo);
    }


    /**
     * 用于MVCtest,测试成功将注释掉
     */
/*    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn,5);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);
        return "list" ;
    }*/


}
