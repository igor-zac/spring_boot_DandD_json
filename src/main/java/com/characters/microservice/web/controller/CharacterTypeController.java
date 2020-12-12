package com.characters.microservice.web.controller;

import com.characters.microservice.model.CharacterType;
import com.characters.microservice.model.CharacterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/character-types")
public class CharacterTypeController {

    @Autowired
    private CharacterTypeRepository characterTypeRepository;

    @GetMapping
    public List<CharacterType> index() {
        return characterTypeRepository.findAll();
    }
}
