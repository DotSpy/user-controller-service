package com.oxagile.dao.impl;

import com.oxagile.dao.CustomHibernateDaoSupport;
import com.oxagile.dao.UserDao;
import com.oxagile.model.database.DepartmentDb;
import com.oxagile.model.database.UserDb;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends CustomHibernateDaoSupport implements UserDao {

    private Class<UserDb> getPersistentClass() {
        return UserDb.class;
    }


    @Override
    public List<UserDb> getAllUsers() {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        return (List<UserDb>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public void saveUser(UserDb userDb) {
        getHibernateTemplate().save(userDb);
    }

    @Override
    public void saveUsers(List<UserDb> userDbs) {
        userDbs.forEach(this::saveUser);
    }

    @Override
    public UserDb findByName(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.conjunction()
                .add(Restrictions.eq("name", name)));
        if (getHibernateTemplate().findByCriteria(criteria).size() == 0) {
            return null;
        } else {
            return ((List<UserDb>) getHibernateTemplate().findByCriteria(criteria)).get(0);
        }
    }

    @Override
    public UserDb findByMailNickName(String nickName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.conjunction()
                .add(Restrictions.eq("mailNickname", nickName)));
        if (getHibernateTemplate().findByCriteria(criteria).size() == 0) {
            return null;
        } else {
            return ((List<UserDb>) getHibernateTemplate().findByCriteria(criteria)).get(0);
        }
    }

    @Override
    public List<UserDb> findByDepartment(DepartmentDb departmentDb) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.eq("department",departmentDb));
        return (List<UserDb>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public void deleteUser(UserDb userDb) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.conjunction()
                .add(Restrictions.eq("email", userDb.getMail())));
        getHibernateTemplate().delete(criteria);
    }

    @Override
    public UserDb findByEmail(String email) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
        criteria.add(Restrictions.conjunction()
                .add(Restrictions.eq("email", email)));
        if (getHibernateTemplate().findByCriteria(criteria).size() == 0) {
            return null;
        } else {
            return ((List<UserDb>) getHibernateTemplate().findByCriteria(criteria)).get(0);
        }
    }

    @Override
    public void updateUser() {

    }
}
