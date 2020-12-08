package com.d.d.springbootd.d.web.controller;
import com.d.d.springbootd.d.dao.CharacterDao;
import com.d.d.springbootd.d.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    @GetMapping(value = "/characters")
    public List<Character> index() {
        return characterDao.findAll();
    }

    @GetMapping(value = "/characters/{id}")
    public Character show(@PathVariable int id) {
        return characterDao.findById(id);
    }

    @PostMapping(value = "/characters")
    public ResponseEntity<Void> store(@RequestBody Character character) {

        Character addedCharacter = characterDao.save(character);

        if(addedCharacter == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedCharacter.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/characters/{id}")
    public ResponseEntity<Character> update(@PathVariable int id, @RequestBody Character character) {

        if(id != character.getId() || characterDao.findById(id) == null)
            return ResponseEntity.badRequest().build();


        Character updatedCharacter = characterDao.save(character);

        return ResponseEntity.ok(updatedCharacter);
    }

    @DeleteMapping(value = "/characters/{id}")
    public ResponseEntity<Void> destroy(@PathVariable int id) {

        if(characterDao.findById(id) == null)
            return ResponseEntity.notFound().build();

        characterDao.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
