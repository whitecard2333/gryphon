package com.oraclecube.whitecard.core.data.repository;

import com.oraclecube.whitecard.core.constant.CoreConstant;
import com.oraclecube.whitecard.core.data.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * BaseRepository implementation
 *
 * @see Transactional
 * Created by zhouhu on 27/3/2017.
 */
@Transactional
public class BaseRepositoryImpl<T extends BaseEntity, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{
    private static final Logger logger = LoggerFactory.getLogger(BaseRepositoryImpl.class);
    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
        this.domainClass = domainClass;
    }

    @Override
    public <S extends T> S save(S entity) {
        entity.setUpdateMillis(System.currentTimeMillis());
        return super.save(entity);
    }

    @Override
    public void delete(ID id) {
        T entity = findOne(id);
        delete(entity);
    }

    @Override
    public void delete(ID id, String updater) {
        T entity = findOne(id);
        entity.setLastUpdater(updater);
        delete(entity);
    }

    @Override
    public void delete(T entity) {
        entity.setDeleteStatus(CoreConstant.DELETE_STATUS_TRUE);
        entity.setUpdateMillis(System.currentTimeMillis());
        save(entity);
    }

    @Override
    public void realDelete(ID id) {
        T entity = findOne(id);
        super.delete(entity);
    }
}
