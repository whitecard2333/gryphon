package com.oraclecube.whitecard.core.data.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhouhu on 1/7/2017.
 */
@Entity
@Table(name = "t_organization")
public class Organization extends BaseEntity {
    private static final long serialVersionUID = -7241241715257678051L;
    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<UserOrganization> userOrganizations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserOrganization> getUserOrganizations() {
        return userOrganizations;
    }

    public void setUserOrganizations(List<UserOrganization> userOrganizations) {
        this.userOrganizations = userOrganizations;
    }
}
