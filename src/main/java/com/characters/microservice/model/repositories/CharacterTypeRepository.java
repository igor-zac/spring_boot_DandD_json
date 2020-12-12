package com.characters.microservice.model.repositories;

import com.characters.microservice.model.entities.CharacterType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterTypeRepository extends JpaRepository<CharacterType, Integer> {
}
