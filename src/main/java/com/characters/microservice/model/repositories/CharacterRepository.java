package com.characters.microservice.model.repositories;

import com.characters.microservice.model.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
