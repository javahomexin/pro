package com.wky.oa.service.impl;


import com.wky.oa.dao.IRoleDao;
import com.wky.oa.domain.Role;
import com.wky.oa.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleDao iRoleDao;

    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    public void delete(Role model) {
        iRoleDao.delete(model.getId());
    }

    public void edit(Role model) {
        iRoleDao.update(model);
    }

    public Role getById(Long id) {
        return iRoleDao.getById(id);
    }

    @Override
    public void save(Role model) {
        if(model.getId() != null){
             iRoleDao.update(model);
        }else {
            iRoleDao.save(model);
        }
    }
}
