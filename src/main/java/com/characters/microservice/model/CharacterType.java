package com.characters.microservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = CharacterType.TABLE_NAME)
public class CharacterType {

    public static final String TABLE_NAME = "character_type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "characterType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Character> characters = new HashSet<>();

    public CharacterType(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;

        for (Character character : characters) {
            character.setCharacterType(this);
        }
    }
}
