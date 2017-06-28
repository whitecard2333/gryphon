package com.oraclecube.whitecard.repository;

import com.oraclecube.whitecard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by xiongbanglong on 2017/6/28.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
