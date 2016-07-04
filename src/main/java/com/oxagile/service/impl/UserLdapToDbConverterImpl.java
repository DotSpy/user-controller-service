package com.oxagile.service.impl;

import com.oxagile.dao.DepartmentDao;
import com.oxagile.dao.UserDao;
import com.oxagile.model.database.DepartmentDb;
import com.oxagile.model.database.UserDb;
import com.oxagile.model.ldap.UserLdap;
import com.oxagile.service.UserLdapToDbConverter;
import com.oxagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserLdapToDbConverterImpl implements UserLdapToDbConverter {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public UserDb convertUserLdapToDb(UserLdap userLdap) {
        UserDb userDb = new UserDb();
        if (userLdap.getDepartment() != null) {
            if (departmentDao.findByName(userLdap.getDepartment()) != null) {
                userDb.setDepartment(departmentDao.findByName(userLdap.getDepartment()));
            } else {
                DepartmentDb departmentDb = new DepartmentDb();
                departmentDb.setName(userLdap.getDepartment());
                departmentDao.saveDepartment(departmentDb);
                userDb.setDepartment(departmentDao.findByName(userLdap.getDepartment()));
            }
        }
        userDb.setCompany(userLdap.getCompany());
        userDb.setDisplayName(userLdap.getDisplayName());
        userDb.setIpPhone(userLdap.getIpPhone());
        userDb.setMail(userLdap.getMail());
        userDb.setMailNickname(userLdap.getMailNickname());
        userDb.setName(userLdap.getCn());
        userDb.setTitle(userLdap.getTitle());
        return userDb;
    }

    @Override
    @Transactional
    public List<UserDb> convertUsersLdapToDb(List<UserLdap> userLdapList) {
        List<UserDb> result = userDao.getAllUsers();
        for (UserLdap userLdap : userLdapList) {
            if (!result.stream().filter(userDb -> userDb.getName().equals(userLdap.getCn())).findAny().isPresent()) {
                putUserDb(result, userLdapList, userLdap);
            }
        }
        return result;
    }

    private UserDb putUserDb(List<UserDb> existingUsers, List<UserLdap> userLdapList, UserLdap userLdap) {
        UserDb userDb = convertUserLdapToDb(userLdap);
        existingUsers.add(userDb);
        if (userLdap.getManager() != null) {
                setManagerToUserDb(existingUsers, userLdapList, userLdap, userDb);

        }
        return userDb;
    }

    private void setManagerToUserDb(List<UserDb> result, List<UserLdap> userLdapList, UserLdap userLdap, UserDb userDb) {
        Optional<UserDb> userDbOptional = result.stream()
                .filter(user -> user.getName().equals(extractManager(userLdap.getManager()))).findAny();
        if (userDbOptional.isPresent()) {
            userDb.setManager(userDbOptional.get());
        } else {
            Optional<UserLdap> managerLdap =
                    userLdapList.stream()
                            .filter(userLdapListItem -> userLdapListItem.getName().equals(extractManager(userLdap.getManager())))
                            .findAny();
            UserDb manager = null;
            if (managerLdap.isPresent()) {
                manager = putUserDb(result, userLdapList, managerLdap.get());
            }
            userDb.setManager(manager);
        }
    }

    private String extractManager(String ldapString) {
        return ldapString.substring(ldapString.indexOf('=') + 1, ldapString.indexOf(','));
    }


}
