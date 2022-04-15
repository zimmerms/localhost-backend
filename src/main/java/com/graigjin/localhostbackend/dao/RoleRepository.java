package com.graigjin.localhostbackend.dao;

import com.graigjin.localhostbackend.model.Role;
import com.graigjin.localhostbackend.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
