package com.oraclecube.whitecard.core.data.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;

import javax.persistence.*;

/**
 * Created by zhouhu on 1/7/2017.
 */
@Entity
@Table(name = "t_user_organization")
public class UserOrganization extends BaseEntity {
    private static final long serialVersionUID = 2260694218108703000L;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "id", nullable = false)
    private Organization organization;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
