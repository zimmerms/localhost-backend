package com.graigjin.localhostbackend.dao;

import com.graigjin.localhostbackend.model.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
