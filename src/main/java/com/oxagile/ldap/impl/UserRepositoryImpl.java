package com.oxagile.ldap.impl;

import com.oxagile.ldap.UserRepositoryIntf;
import com.oxagile.model.ldap.LdapFields;
import com.oxagile.model.ldap.UserLdap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import java.util.List;
import java.util.Optional;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Repository
public class UserRepositoryImpl implements UserRepositoryIntf {


    @Autowired
    private LdapTemplate ldapTemplate;

    private class UserAttributesMapper implements AttributesMapper<UserLdap> {
        @Override
        public UserLdap mapFromAttributes(Attributes attrs) throws NamingException {
            UserLdap userLdap = new UserLdap();
            try {

                Optional<Attribute> mail = Optional.ofNullable(attrs.get(LdapFields.MAIL));
                if (mail.isPresent()) {
                    userLdap.setMail((String) mail.get().get());
                }

                Optional<Attribute> mailNickname = Optional.ofNullable(attrs.get(LdapFields.MAIL_NICKNAME));
                if (mailNickname.isPresent()) {
                    userLdap.setMailNickname((String) mailNickname.get().get());
                }

                Optional<Attribute> ipPhone = Optional.ofNullable(attrs.get(LdapFields.IP_PHONE));
                if (ipPhone.isPresent()) {
                    userLdap.setIpPhone((String) ipPhone.get().get());
                }

                Optional<Attribute> givenName = Optional.ofNullable(attrs.get(LdapFields.GIVEN_NAME));
                if (givenName.isPresent()) {
                    userLdap.setGivenName((String) givenName.get().get());
                }

                Optional<Attribute> name = Optional.ofNullable(attrs.get(LdapFields.NAME));
                if (name.isPresent()) {
                    userLdap.setName((String) name.get().get());
                }

                Optional<Attribute> displayName = Optional.ofNullable(attrs.get(LdapFields.DISPLAY_NAME));
                if (displayName.isPresent()) {
                    userLdap.setDisplayName((String) displayName.get().get());
                }

                Optional<Attribute> title = Optional.ofNullable(attrs.get(LdapFields.TITLE));
                if (title.isPresent()) {
                    userLdap.setTitle((String) title.get().get());
                }

                Optional<Attribute> company = Optional.ofNullable(attrs.get(LdapFields.COMPANY));
                if (company.isPresent()) {
                    userLdap.setCompany((String) company.get().get());
                }

                Optional<Attribute> cn = Optional.ofNullable(attrs.get(LdapFields.CN));
                if (cn.isPresent()) {
                    userLdap.setCn((String) cn.get().get());
                }

                Optional<Attribute> department = Optional.ofNullable(attrs.get(LdapFields.DEPARTMENT));
                if (department.isPresent()) {
                    userLdap.setDepartment((String) department.get().get());
                }

                Optional<Attribute> userPrincipalName = Optional.ofNullable(attrs.get(LdapFields.USER_PRINCIPAL_NAME));
                if (userPrincipalName.isPresent()) {
                    userLdap.setUserPrincipalName((String) userPrincipalName.get().get());
                }

                Optional<Attribute> manager = Optional.ofNullable(attrs.get(LdapFields.MANAGER));
                if (manager.isPresent()) {
                    userLdap.setManager((String) manager.get().get());
                }

                Optional<Attribute> streetAddress = Optional.ofNullable(attrs.get(LdapFields.STREET_ADDRESS));
                if (streetAddress.isPresent()) {
                    userLdap.setStreetAddress((String) streetAddress.get().get());
                }
            } catch (javax.naming.NamingException e) {
                e.printStackTrace();
            }
            return userLdap;
        }

    }

    @Override
    public List<UserLdap> getAllUsers() {
        return ldapTemplate.search(query().where(LdapFields.FILTER_FIELD).is(LdapFields.CRITERIA), new UserAttributesMapper());
    }
}
