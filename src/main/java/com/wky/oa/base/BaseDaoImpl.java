package com.wky.oa.base;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements IBaseDao<T> {

    @Resource
    private SessionFactory sessionFactory;

    private Class<T> clazz;


    public BaseDaoImpl() {

        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();

        Type[] types = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void delete(Long id) {
        getSession().delete(sessionFactory.getCurrentSession().get(clazz,id));
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public T getById(Long id) {

        return (T) getSession().get(clazz,id);
    }

    public List<T> getByIds(Long[] ids) {

        String hql = "FROM " + clazz.getSimpleName() + " WHERE id in (:ids)";
        Query query = getSession().createQuery(hql);
        query.setParameter("ids",ids);
        return query.list();
    }

    public List<T> findAll() {
        String hql = "FROM "+ clazz.getSimpleName();
        return getSession().createQuery(hql).list();
    }

    public Session getSession(){
       return sessionFactory.getCurrentSession();
    }
}
