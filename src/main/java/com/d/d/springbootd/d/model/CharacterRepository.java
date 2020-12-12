package com.d.d.springbootd.d.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
