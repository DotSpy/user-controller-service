package com.oxagile.service.impl;

import com.oxagile.dao.DepartmentDao;
import com.oxagile.dao.UserDao;
import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;
import com.oxagile.service.UserDtoToDbConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoToDbConverterImpl implements UserDtoToDbConverter {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional
    public UserDb convertUserDtoToDb(UserDTO userDto) {
        UserDb userDb = new UserDb();
        userDb.setName(userDto.getName());
        userDb.setTitle(userDto.getTitle());
        userDb.setDepartment(departmentDao.findByName(userDto.getDepartment()));
        userDb.setManager(userDao.findByName(userDto.getManager()));
        userDb.setMail(userDto.getEmail());
        userDb.setId(userDto.getId());
        return userDb;
    }

    @Override
    public List<UserDb> convertUserDtoListToDb(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(this::convertUserDtoToDb).collect(Collectors.toList());
    }
}
