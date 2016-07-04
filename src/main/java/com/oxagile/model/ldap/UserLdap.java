package com.oxagile.model.ldap;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entry(objectClasses = {"user"}, base = "OU=Users,OU=Users,OU=Oxagile,DC=belhard,DC=com")
public class UserLdap implements Serializable {

    private Integer lastLogoff;

    private Integer logonCount;

    @Attribute(name = "mail")
    private String mail;

    private LocalDateTime accountExpires;

    private LocalDateTime lastLogonTimestamp;

    private Integer msExchRecipientTypeDetails;

    private String msExchHomeServerName;

    private String homeMTA;

    private Integer msExchRecipientDisplayType;

    private String msExchMailboxGuid;

    private Integer msExchVersion;

    private String userAccountControl;

    private String legacyExchangeDN;

    @Attribute(name = "mailNickname")
    private String mailNickname;

    @Attribute(name = "ipPhone")
    private String ipPhone;

    private LocalDateTime whenCreated;

    private String physicalDeliveryOfficeName;

    private Integer uSNChanged;

    private String sAMAccountName;

    @Attribute(name = "givenName")
    private String givenName;

    @Attribute(name = "name")
    private String name;

    private LocalDateTime pwdLastSet;

    private String telephoneNumber;

    @Attribute(name = "displayName")
    private String displayName;

    @Attribute(name = "title")
    private String title;

    private String objectGUID;

    @Attribute(name = "company")
    private String company;

    @Attribute(name = "cn")
    private String cn;

    private List<String> memberOf;

    @Attribute(name = "department")
    private String department;

    @Attribute(name = "userPrincipalName")
    private String userPrincipalName;

    private LocalDateTime lastLogon;

    @Attribute(name = "manager")
    private String manager;

    private Integer instanceType;

    private String o;

    @Attribute(name = "streetAddress")
    private String streetAddress;

    private Integer primaryGroupID;

    public Integer getLastLogoff() {
        return lastLogoff;
    }

    public void setLastLogoff(Integer lastLogoff) {
        this.lastLogoff = lastLogoff;
    }

    public Integer getLogonCount() {
        return logonCount;
    }

    public void setLogonCount(Integer logonCount) {
        this.logonCount = logonCount;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getAccountExpires() {
        return accountExpires;
    }

    public void setAccountExpires(LocalDateTime accountExpires) {
        this.accountExpires = accountExpires;
    }

    public LocalDateTime getLastLogonTimestamp() {
        return lastLogonTimestamp;
    }

    public void setLastLogonTimestamp(LocalDateTime lastLogonTimestamp) {
        this.lastLogonTimestamp = lastLogonTimestamp;
    }

    public Integer getMsExchRecipientTypeDetails() {
        return msExchRecipientTypeDetails;
    }

    public void setMsExchRecipientTypeDetails(Integer msExchRecipientTypeDetails) {
        this.msExchRecipientTypeDetails = msExchRecipientTypeDetails;
    }

    public String getMsExchHomeServerName() {
        return msExchHomeServerName;
    }

    public void setMsExchHomeServerName(String msExchHomeServerName) {
        this.msExchHomeServerName = msExchHomeServerName;
    }

    public String getHomeMTA() {
        return homeMTA;
    }

    public void setHomeMTA(String homeMTA) {
        this.homeMTA = homeMTA;
    }

    public Integer getMsExchRecipientDisplayType() {
        return msExchRecipientDisplayType;
    }

    public void setMsExchRecipientDisplayType(Integer msExchRecipientDisplayType) {
        this.msExchRecipientDisplayType = msExchRecipientDisplayType;
    }

    public String getMsExchMailboxGuid() {
        return msExchMailboxGuid;
    }

    public void setMsExchMailboxGuid(String msExchMailboxGuid) {
        this.msExchMailboxGuid = msExchMailboxGuid;
    }

    public Integer getMsExchVersion() {
        return msExchVersion;
    }

    public void setMsExchVersion(Integer msExchVersion) {
        this.msExchVersion = msExchVersion;
    }

    public String getUserAccountControl() {
        return userAccountControl;
    }

    public void setUserAccountControl(String userAccountControl) {
        this.userAccountControl = userAccountControl;
    }

    public String getLegacyExchangeDN() {
        return legacyExchangeDN;
    }

    public void setLegacyExchangeDN(String legacyExchangeDN) {
        this.legacyExchangeDN = legacyExchangeDN;
    }

    public String getMailNickname() {
        return mailNickname;
    }

    public void setMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
    }

    public String getIpPhone() {
        return ipPhone;
    }

    public void setIpPhone(String ipPhone) {
        this.ipPhone = ipPhone;
    }

    public LocalDateTime getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(LocalDateTime whenCreated) {
        this.whenCreated = whenCreated;
    }

    public String getPhysicalDeliveryOfficeName() {
        return physicalDeliveryOfficeName;
    }

    public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public Integer getuSNChanged() {
        return uSNChanged;
    }

    public void setuSNChanged(Integer uSNChanged) {
        this.uSNChanged = uSNChanged;
    }

    public String getsAMAccountName() {
        return sAMAccountName;
    }

    public void setsAMAccountName(String sAMAccountName) {
        this.sAMAccountName = sAMAccountName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPwdLastSet() {
        return pwdLastSet;
    }

    public void setPwdLastSet(LocalDateTime pwdLastSet) {
        this.pwdLastSet = pwdLastSet;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjectGUID() {
        return objectGUID;
    }

    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public List<String> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(List<String> memberOf) {
        this.memberOf = memberOf;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public LocalDateTime getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(LocalDateTime lastLogon) {
        this.lastLogon = lastLogon;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(Integer instanceType) {
        this.instanceType = instanceType;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Integer getPrimaryGroupID() {
        return primaryGroupID;
    }

    public void setPrimaryGroupID(Integer primaryGroupID) {
        this.primaryGroupID = primaryGroupID;
    }

}
