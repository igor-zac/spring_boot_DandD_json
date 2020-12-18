package com.characters.microservice.web.controller;

import com.characters.microservice.exceptions.CharacterIdMismatchException;
import com.characters.microservice.exceptions.CharacterNotFoundException;
import com.characters.microservice.exceptions.CharacterTypeNotFoundException;
import com.characters.microservice.exceptions.IncorrectCharacterTypeDataException;
import com.characters.microservice.model.entities.Character;
import com.characters.microservice.model.entities.CharacterType;
import com.characters.microservice.model.repositories.CharacterRepository;
import com.characters.microservice.model.repositories.CharacterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterTypeRepository characterTypeRepository;


    @GetMapping
    public List<Character> index()
    {
        return characterRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Character store(@RequestBody @Valid Character character)
    {
        characterTypeRepository.findById(character.getCharacterType().getId())
                .orElseThrow(CharacterTypeNotFoundException::new);

        Character savedCharacter = characterRepository.save(character);

        return characterRepository.save(savedCharacter);
    }

    @GetMapping(value = "/{id}")
    public Character show(@PathVariable int id)
    {
        return characterRepository.findById(id).orElseThrow(CharacterNotFoundException::new);
    }

    @PutMapping(value = "/{id}")
    public Character update(@PathVariable int id, @RequestBody @Valid Character character)
            throws CharacterIdMismatchException
    {
        if (character.getId() != id) {
            throw new CharacterIdMismatchException();
        }

        characterTypeRepository.findById(character.getCharacterType().getId())
                .orElseThrow(CharacterTypeNotFoundException::new);

        characterRepository.findById(id).orElseThrow(CharacterNotFoundException::new);

        return characterRepository.save(character);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id)
    {
        characterRepository.findById(id).orElseThrow(CharacterNotFoundException::new);
        characterRepository.deleteById(id);
    }

}
