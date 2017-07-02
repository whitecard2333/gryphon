package com.oraclecube.whitecard.core.data.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * User entity
 * Created by zhouhu on 1/7/2017.
 */
@Entity
@Table(name = "t_user", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class User extends BaseEntity {
    private static final long serialVersionUID = -6843486985264504045L;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "mail", nullable = false, length = 44)
    private String mail;

    @Column(name = "tel")
    private String tel;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserOrganization> userOrganizations;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRolePermission> userRolePermissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public String getSalt() {
        return salt;
    }

    @JsonProperty
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
