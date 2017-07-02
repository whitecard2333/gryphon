package com.oraclecube.whitecard.core.data.config;

import com.oraclecube.whitecard.core.data.entity.BaseEntity;
import com.oraclecube.whitecard.core.data.repository.BaseRepositoryImpl;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.provider.QueryExtractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Actual bean to generate implementation for Repository interface by cglib,
 * instead spring default class {@link JpaRepositoryFactoryBean}
 *
 * Created by zhouhu on 27/3/2017.
 */
public class BaseJpaRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, ID> {
    /**
     * Creates a new {@link JpaRepositoryFactoryBean} for the given repository interface.
     *
     * @param repositoryInterface must not be {@literal null}.
     */
    public BaseJpaRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new BaseJpaRepositoryFactory<T, ID>(entityManager);
    }

    /**
     * Actual JpaRepositoryFactory bean to get implementation for Repository interface,
     * default get {@link BaseRepositoryImpl}
     * instead {@link JpaRepositoryFactory}
     *
     * @param <T>
     * @param <ID>
     */
    public static class BaseJpaRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

        private final EntityManager entityManager;
        private final QueryExtractor extractor;

        /**
         * Creates a new {@link JpaRepositoryFactory}.
         *
         * @param entityManager must not be {@literal null}
         */
        public BaseJpaRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
            this.extractor = PersistenceProvider.fromEntityManager(entityManager);
        }

        @Override
        protected Object getTargetRepository(RepositoryInformation information) {
            Class<?> domainType = information.getDomainType();
            if (BaseEntity.class.isAssignableFrom(domainType)) {
                return new BaseRepositoryImpl<>((Class<BaseEntity>) domainType, entityManager);
            } else {
                return super.getTargetRepository(information);
            }
        }

        @Override
        protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
                RepositoryInformation information, EntityManager entityManager) {
            Class<?> domainType = information.getDomainType();
            if (BaseEntity.class.isAssignableFrom(domainType)) {
                return new BaseRepositoryImpl<BaseEntity, ID>((Class<BaseEntity>) domainType, entityManager);
            } else {
                return super.getTargetRepository(information, entityManager);
            }
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseEntity.class.isAssignableFrom(metadata.getDomainType()) ?
                    BaseRepositoryImpl.class : super.getRepositoryBaseClass(metadata);
        }
    }
}
