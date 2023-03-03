package com.seacleaver.example.project.repositories;

import com.seacleaver.example.project.models.Raid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaidRepository extends JpaRepository<Raid,Long> {
}
