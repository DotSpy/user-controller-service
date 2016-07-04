package com.oxagile.service;

import com.oxagile.model.dto.UserTokenExample;


public interface AuthorizeService {

    String getTokenForUser(UserTokenExample userTokenExample);

}
