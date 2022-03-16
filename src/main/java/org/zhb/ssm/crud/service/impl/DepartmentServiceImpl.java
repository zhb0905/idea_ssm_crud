package org.zhb.ssm.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhb.ssm.crud.bean.Department;
import org.zhb.ssm.crud.dao.DepartmentMapper;
import org.zhb.ssm.crud.service.DepartmentService;

import java.util.List;

/**
 * @author zhb
 * @create 2022-03-17 2:23
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepts() {
        return departmentMapper.selectByExample(null);
    }
}
