package com.seacleaver.example.project.repositories;

import com.seacleaver.example.project.models.Kraken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends JpaRepository<Kraken, Long> {
}
