package com.characters.microservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterTypeRepository extends JpaRepository<CharacterType, Integer> {
}
