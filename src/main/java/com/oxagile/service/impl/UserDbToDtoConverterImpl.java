package com.oxagile.service.impl;

import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;
import com.oxagile.service.UserDbToDtoConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDbToDtoConverterImpl implements UserDbToDtoConverter {

    @Override
    public UserDTO convertUserDbToDto(UserDb userDb) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userDb.getName());
        userDTO.setTitle(userDb.getTitle() == null ? null : userDb.getTitle());
        userDTO.setDepartment(userDb.getDepartment() == null ? null : userDb.getDepartment().getName());
        userDTO.setManager(userDb.getManager() == null ? null : userDb.getManager().getName());
        userDTO.setEmail(userDb.getMail() == null ? null : userDb.getMail());
        userDTO.setId(userDb.getId() == null ? null : userDb.getId());
        return userDTO;
    }
}
