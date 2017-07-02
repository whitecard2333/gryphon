package com.oraclecube.whitecard.core.data.repository.auth;

import com.oraclecube.whitecard.core.data.entity.auth.User;
import com.oraclecube.whitecard.core.data.repository.BaseRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

/**
 * UserRepository {@link User}
 * Created by zhouhu on 21/4/2017.
 */
@ConditionalOnProperty(prefix = "gryphon.config.enableJpa.map", name = {"default"}, havingValue = "true")
public interface UserRepository extends BaseRepository<User, String> {
    User findByName(String name);

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="5000")})
    User findOne(String id);
}
