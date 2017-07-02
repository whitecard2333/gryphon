package com.oraclecube.whitecard.core.data.entity.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Role
 * Created by zhouhu on 1/7/2017.
 */
@Entity
@Table(name = "t_role_permission", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "permission"}), @UniqueConstraint(columnNames = {"value"})})
public class RolePermission extends BaseEntity {
    private static final long serialVersionUID = -4030326809341972343L;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "value", nullable = false)
    private int value;

    @Column(name = "permission", nullable = false, length = 20)
    private String permission;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolePermission")
    private List<UserRolePermission> userRolePermissions;
}
