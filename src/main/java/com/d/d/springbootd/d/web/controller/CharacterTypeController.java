package com.d.d.springbootd.d.web.controller;

import com.d.d.springbootd.d.model.CharacterType;
import com.d.d.springbootd.d.model.CharacterTypeRepository;
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
    public ResponseEntity<List<CharacterType>> index() {
        return ResponseEntity.ok(characterTypeRepository.findAll());
    }
}
