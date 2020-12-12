package com.d.d.springbootd.d.web.controller;
import com.d.d.springbootd.d.model.Character;
import com.d.d.springbootd.d.model.CharacterRepository;
import com.d.d.springbootd.d.model.CharacterType;
import com.d.d.springbootd.d.model.CharacterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterTypeRepository characterTypeRepository;


    @GetMapping
    public ResponseEntity<List<Character>> index() {
        return ResponseEntity.ok(characterRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Character> show(@PathVariable int id) {

        Optional<Character> optionalCharacter = characterRepository.findById(id);

        return optionalCharacter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.unprocessableEntity().build());

    }

    @PostMapping()
    public ResponseEntity<Character> store(@RequestBody @Valid Character character) {

        Optional<CharacterType> optionalCharacterType = characterTypeRepository.findById(character.getCharacterType().getId());
        if (optionalCharacterType.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }

        character.setCharacterType(optionalCharacterType.get());

        Character savedCharacter = characterRepository.save(character);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCharacter.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedCharacter);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Character> update(@PathVariable int id, @RequestBody @Valid Character character) {
        Optional<CharacterType> optionalCharacterType = characterTypeRepository.findById(character.getCharacterType().getId());
        if(optionalCharacterType.isEmpty())
            return ResponseEntity.unprocessableEntity().build();

        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if(optionalCharacter.isEmpty())
            return ResponseEntity.unprocessableEntity().build();

        character.setCharacterType(optionalCharacterType.get());
        character.setId(optionalCharacter.get().getId());
        characterRepository.save(character);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Character> delete(@PathVariable int id) {

        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if(optionalCharacter.isEmpty())
            return ResponseEntity.unprocessableEntity().build();

        characterRepository.delete(optionalCharacter.get());

        return ResponseEntity.noContent().build();
    }

}
