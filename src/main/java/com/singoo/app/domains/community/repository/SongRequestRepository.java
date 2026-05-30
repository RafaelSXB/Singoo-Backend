package com.singoo.app.domains.community.repository;

import com.singoo.app.domains.community.model.SongRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SongRequestRepository extends JpaRepository<SongRequest, UUID> {
}