package com.oxagile.service.impl;

import com.oxagile.dao.DepartmentDao;
import com.oxagile.dao.UserDao;
import com.oxagile.ldap.UserRepositoryIntf;
import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;
import com.oxagile.model.ldap.UserLdap;
import com.oxagile.service.UserDbToDtoConverter;
import com.oxagile.service.UserDtoToDbConverter;
import com.oxagile.service.UserLdapToDbConverter;
import com.oxagile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLdapToDbConverter userLdapToDbConverter;

    @Autowired
    private UserRepositoryIntf userRepository;

    @Autowired
    private UserDbToDtoConverter userDbToDtoConverter;

    @Autowired
    private UserDtoToDbConverter userDtoToDbConverter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        return userDbToDtoConverter.convertUsersDbToDto(getAllUsersDb());
    }

    @Override
    @Transactional
    public List<UserLdap> getAllUsersLdap() {
        return userRepository.getAllUsers();
    }

    @Override
    @Transactional
    public List<UserDb> getAllUsersDb() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUsersDb(List<UserDb> userDbs) {
        userDao.saveUsers(userDbs);
    }

    @Override
    @Transactional
    public void saveUserDb(UserDb userDb) {
        userDao.saveUser(userDb);
    }

    @Override
    @Transactional
    public void saveUserLdap(UserLdap userLdap) {
        saveUserDb(userLdapToDbConverter.convertUserLdapToDb(userLdap));
    }

    @Override
    @Transactional
    public void saveUsersLdap(List<UserLdap> userLdaps) {
        saveUsersDb(userLdapToDbConverter.convertUsersLdapToDb(userLdaps));
    }

    @Override
    @Transactional
    public void deleteUserDb(UserDTO userDto) {
        userDao.deleteUser(userDtoToDbConverter.convertUserDtoToDb(userDto));
    }

    @Override
    @Transactional
    public List<UserDTO> findUsersByDepartment(String departmentName) {
        if (departmentDao.findByName(departmentName) != null) {
            return userDbToDtoConverter.convertUsersDbToDto(userDao.findByDepartment(departmentDao.findByName(departmentName)));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void updateUsersLdap(List<UserLdap> userLdaps) {
        updateUsersDb(userLdapToDbConverter.convertUsersLdapToDb(userLdaps));
    }

    @Override
    @Transactional
    public void updateUsersDb(List<UserDb> userDbs) {
    }

    @Override
    @Transactional
    public void synchronizeLdapAndDb() {
        List<UserDb> userLdap = userLdapToDbConverter.convertUsersLdapToDb(userRepository.getAllUsers());
        List<UserDb> userDbs = userDao.getAllUsers();
        for (UserDb userDb : userLdap) {
            if(userDbs.contains(userDb)){
                userDbs.remove(userDb);
            } else {
                userDao.saveUser(userDb);
            }
        }
        userDbs.stream().forEach(userDb -> userDao.deleteUser(userDb));
    }


}
