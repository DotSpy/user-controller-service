package com.oxagile.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Token {

    private String login;

    private LocalDateTime timestamp;

    private int id;

    private String pass;

    private List<UserRoleEnum> userRoleEnumList;

    private Token(Builder builder) {
        login = builder.login;
        timestamp = builder.timestamp;
        id = builder.id;
        pass = builder.pass;
        userRoleEnumList = builder.userRoleEnumList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public List<UserRoleEnum> getUserRoleEnumList() {
        return userRoleEnumList;
    }

    public static final class Builder {
        private String login;
        private LocalDateTime timestamp;
        private int id;
        private String pass;
        private List<UserRoleEnum> userRoleEnumList;

        private Builder() {
        }

        public Builder withLogin(String val) {
            login = val;
            return this;
        }

        public Builder withTimestamp(LocalDateTime val) {
            timestamp = val;
            return this;
        }

        public Builder withId(int val) {
            id = val;
            return this;
        }

        public Builder withPass(String val) {
            pass = val;
            return this;
        }

        public Builder withUserRoleEnumList(List<UserRoleEnum> val) {
            userRoleEnumList = val;
            return this;
        }

        public Token build() {
            return new Token(this);
        }
    }

    @Override
    public String toString() {
        return "Token{" +
                "login='" + login + '\'' +
                ", timestamp=" + timestamp +
                ", id=" + id +
                ", pass='" + pass + '\'' +
                ", userRoleEnumList=" + userRoleEnumList +
                '}';
    }
}
