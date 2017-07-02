package com.oraclecube.whitecard.core.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oraclecube.whitecard.core.constant.CoreConstant;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base entity used as parent Object for other entity Objects
 *
 * @see MappedSuperclass
 * Created by zhouhu on 17/4/2017.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2361851878363949519L;
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    @JsonIgnore
    protected String id;

    @Column(name = "create_millis", nullable = false)
    @JsonIgnore
    protected long createMillis = System.currentTimeMillis();

    @Column(name = "update_millis", nullable = false)
    @JsonIgnore
    protected long updateMillis = System.currentTimeMillis();

    @Column(name = "last_updater")
    @JsonIgnore
    protected String lastUpdater;

    @Column(name = "remarks")
    protected String remarks;

    /**
     * 1: not deleted
     * 0: has been deleted
     */
    @Column(name = "delete_status", nullable = false)
    @JsonIgnore
    protected int deleteStatus = CoreConstant.DELETE_STATUS_FALSE;

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty
    public long getCreateMillis() {
        return createMillis;
    }

    @JsonIgnore
    public void setCreateMillis(long createMillis) {
        this.createMillis = createMillis;
    }

    @JsonProperty
    public long getUpdateMillis() {
        return updateMillis;
    }

    @JsonIgnore
    public void setUpdateMillis(long updateMillis) {
        this.updateMillis = updateMillis;
    }

    @JsonProperty
    public String getLastUpdater() {
        return lastUpdater;
    }

    @JsonIgnore
    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonProperty
    public int getDeleteStatus() {
        return deleteStatus;
    }

    @JsonIgnore
    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
