package com.graigjin.localhostbackend.dao;

import com.graigjin.localhostbackend.model.ActionItem;
import com.graigjin.localhostbackend.model.enums.EActionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {
    Optional<ActionItem> findByName(EActionItem actionItem);
}
