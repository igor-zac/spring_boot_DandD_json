package com.d.d.springbootd.d.dao;

import com.d.d.springbootd.d.model.Character;
import com.d.d.springbootd.d.model.CharacterType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDao implements ICharacterDao{
    public static List<Character> characters = new ArrayList<>();
    private static int id;
    static {
        characters.add(new Character(1, "Dumbledore", CharacterType.WIZARD));
        characters.add(new Character(2, "Gandalf", CharacterType.WIZARD));
        characters.add(new Character(3, "Charlemagne", CharacterType.WARRIOR));
        id = 4;
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if(character.getId() == id) {
                return character;
            }
        };

        return null;
    }

    @Override
    public Character save(Character newCharacter) {
        Character existingCharacter = findById(newCharacter.getId());

        if (existingCharacter != null) {
            characters.set(characters.indexOf(existingCharacter), newCharacter);
        } else {
            newCharacter.setId(nextId());
            characters.add(newCharacter);
        }

        return characters.get(characters.indexOf(newCharacter));
    }

    @Override
    public boolean deleteById(int id) {
        return characters.remove(findById(id));
    }

    private int nextId() {
        CharacterDao.id++;
        return CharacterDao.id - 1;
    }
}
