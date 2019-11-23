package com.wky.oa.service;

import com.wky.oa.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll();

    public void delete(Role model);

    public void edit(Role model);

    public Role getById(Long id);

    public void save(Role model);
}
