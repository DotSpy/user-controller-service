package com.oxagile.service;

import com.oxagile.model.database.UserDb;
import com.oxagile.model.dto.UserDTO;

import java.util.List;

public interface UserDtoToDbConverter {

    UserDb convertUserDtoToDb(UserDTO userDto);

    List<UserDb> convertUserDtoListToDb(List<UserDTO> userDTOs);

}
