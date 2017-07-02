package com.oraclecube.whitecard.core.data.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by zhouhu on 1/7/2017.
 */
public class UserRolePermission extends BaseEntity {
    private static final long serialVersionUID = -4883692401141864978L;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_permission_id", referencedColumnName = "id", nullable = false)
    private RolePermission rolePermission;
}
