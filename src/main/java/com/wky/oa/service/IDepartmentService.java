package com.wky.oa.service;


import com.wky.oa.domain.Department;

import java.util.List;

public interface IDepartmentService {

    /**
     * 添加
     */
    public void save(Department book);

    /**
     * 根据id删除
     */
    public void delete(Long id);

    /**
     * 根据id修改
     */
    public void update(Department book);

    /**
     * 根据id查询
     */
    public Department getById(Long id);

    /**
     * 一次查询多个对象
     */
    public List<Department> getByIds(Long[] ids);

    /**
     * 查询所有
     */
    public List<Department> findAll();
}
