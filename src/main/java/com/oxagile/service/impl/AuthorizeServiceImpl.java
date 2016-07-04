package com.oxagile.service.impl;

import com.oxagile.model.dto.Token;
import com.oxagile.model.dto.UserRoleEnum;
import com.oxagile.model.dto.UserTokenExample;
import com.oxagile.service.AuthorizeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    @Transactional
    @Override
    public String getTokenForUser(UserTokenExample userTokenExample) {
        List<UserRoleEnum> userRoleEnumList = new ArrayList<>();
        userRoleEnumList.add(UserRoleEnum.ACCOUNT_ADMIN);
        userRoleEnumList.add(UserRoleEnum.ACCOUNT_OWNER);
        Token token = Token.newBuilder()
                .withId(1)
                .withPass(userTokenExample.getPassword())
                .withTimestamp(LocalDateTime.now())
                .withLogin(userTokenExample.getUsername())
                .withUserRoleEnumList(userRoleEnumList)
                .build();
        Key key = MacProvider.generateKey();
        Map<String, Object> stringTokenMap = new HashMap<>();
        stringTokenMap.put("User", token);
        String tokenString = Jwts.builder().setClaims(stringTokenMap)
                .signWith(SignatureAlgorithm.HS512, key).compact();
        String s = Jwts.builder().setPayload(token.toString()).signWith(SignatureAlgorithm.HS512, key).compact();
        //        assert Jwts.parser().setSigningKey(key).parseClaimsJws(s).getBody().getSubject().equals("Joe");
        return tokenString;
    }
}
