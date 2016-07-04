package com.oxagile.dao.impl;

import com.oxagile.dao.CustomHibernateDaoSupport;
import com.oxagile.dao.DepartmentDao;
import com.oxagile.model.database.DepartmentDb;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl extends CustomHibernateDaoSupport implements DepartmentDao {

    private Class<DepartmentDb> getPersistentClass() {
        return DepartmentDb.class;
    }

    @Override
    public List<DepartmentDb> getAllDepartments() {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        return (List<DepartmentDb>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public DepartmentDb findByName(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.eq("name", name));
        if (getHibernateTemplate().findByCriteria(criteria).size() == 0) {
            return null;
        } else {
            return ((List<DepartmentDb>) getHibernateTemplate().findByCriteria(criteria)).get(0);
        }
    }

    @Override
    public void saveDepartment(DepartmentDb departmentDb) {
        getHibernateTemplate().save(departmentDb);
    }

    @Override
    public void deleteDepartment(DepartmentDb departmentDb) {
        getHibernateTemplate().delete(departmentDb);
    }
}
