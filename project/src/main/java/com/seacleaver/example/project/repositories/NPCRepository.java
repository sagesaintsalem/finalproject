package com.seacleaver.example.project.repositories;

import com.seacleaver.example.project.models.NPCs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NPCRepository extends JpaRepository<NPCs, Long> {
}
