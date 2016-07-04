package com.oxagile.model.database;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_users")
public class UserDb implements Serializable {

    @Id
//    @GenericGenerator(name="generator", strategy="increment")
//    @GeneratedValue(generator="generator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_mail")
    private String mail;

    @Column(name = "c_mailnickname")
    private String mailNickname;

    @Column(name = "c_ipphone")
    private String ipPhone;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_displayname")
    private String displayName;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_company")
    private String company;

    @OneToOne
    @JoinColumn(name = "c_department")
    private DepartmentDb department;

    @ManyToOne
    @JoinColumn(name = "c_manager")
    private UserDb manager;

    public UserDb() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public DepartmentDb getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDb department) {
        this.department = department;
    }

    public UserDb getManager() {
        return manager;
    }

    public void setManager(UserDb manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDb userDb = (UserDb) o;

        return mailNickname.equals(userDb.mailNickname);

    }

    @Override
    public int hashCode() {
        return mailNickname.hashCode();
    }
}
