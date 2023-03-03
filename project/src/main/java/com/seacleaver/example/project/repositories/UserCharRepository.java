package com.seacleaver.example.project.repositories;

import com.seacleaver.example.project.models.UserCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCharRepository extends JpaRepository<UserCharacter, Long> {
}
