package com.assistme.skeleton.jpa.user.dao;

import com.assistme.skeleton.jpa.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Transactional
    @Modifying
    @Query("update UserEntity u set u.enabled = ?1, u.role = ?2, u.password = ?3 where u.username = ?4")
    int updateEnabledAndRoleAndPasswordByUsername(boolean enabled, String role, String password, String username);


}

