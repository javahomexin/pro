package com.wky.oa.service.impl;

import com.wky.oa.dao.IDepartmentDao;
import com.wky.oa.domain.Department;
import com.wky.oa.service.IDepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {


    @Resource
    private IDepartmentDao iDepartmentDao;

    @Override
    public void save(Department book) {
        iDepartmentDao.save(book);
    }

    @Override
    public void delete(Long id) {
        iDepartmentDao.delete(id);
    }

    @Override
    public void update(Department book) {
        iDepartmentDao.update(book);
    }

    @Override
    public Department getById(Long id) {
        return iDepartmentDao.getById(id);
    }

    @Override
    public List<Department> getByIds(Long[] ids) {
        return iDepartmentDao.getByIds(ids);
    }

    @Override
    public List<Department> findAll() {
        return iDepartmentDao.findAll();
    }
}
