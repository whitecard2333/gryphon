package com.oraclecube.whitecard.core.data.repository;

import com.oraclecube.whitecard.core.data.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Base repository implements {@link JpaSpecificationExecutor} and {@link PagingAndSortingRepository}
 *
 * @see NoRepositoryBean
 * Created by zhouhu on 27/3/2017.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends
        JpaSpecificationExecutor<T>, JpaRepository<T, ID> {
    /**
     * delete column by only adding delete tag
     * @param id
     * @param updater
     */
    void delete(ID id, String updater);

    /**
     * real delete column from DB
     * @param id
     */
    void realDelete(ID id);
}
