package com.resms.ssm.common.service.jdbc.impl;

import com.resms.ssm.common.dao.jdbc.JdbcBaseDao;
import com.resms.ssm.common.service.jdbc.JdbcBaseService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class JdbcBaseServiceImpl<T> implements JdbcBaseService<T> {

    protected abstract JdbcBaseDao<T> dao();

    @Override
    public void save(T entity) {
        dao().save(entity);
    }

    @Override
    public void update(T entity) {
        dao().update(entity);
    }

    @Override
    public void delete(T entity) {
        dao().delete(entity);
    }

    @Override
    public void delete(Serializable id) {
        dao().delete(id);
    }

    @Override
    public void deleteAll() {
        dao().deleteAll();
    }

    @Override
    public T findById(Serializable id) {
        return dao().findById(id);
    }

    @Override
    public List<T> findAll() {
        return dao().findAll();
    }

    @Override
    public void batchDelete(Serializable[] ids) {
        dao().batchDelete(ids);
    }

    @Override
    public void batchUpdate(List<T> list) {
        dao().batchUpdate(list);
    }

    @Override
    public void batchSave(List<T> list) {
        dao().batchSave(list);
    }

    @Override
    public abstract Map<String, Object> findOne(Object... args);

    @Override
    public abstract List<Map<String, Object>> findListMap(Object... args);
}
