package com.oxagile.service;

import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface UserDbToDtoConverter {

    default List<UserDTO> convertUsersDbToDto(List<UserDb> userDbs) {
        return userDbs.stream().map(this::convertUserDbToDto).collect(Collectors.toList());
    }

    UserDTO convertUserDbToDto(UserDb userDb);

}
