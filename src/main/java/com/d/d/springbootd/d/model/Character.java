package com.d.d.springbootd.d.model;

public class Character {

    private int id;
    private String name;
    private CharacterType characterType;


    public Character() {
    }

    public Character(int id, String name, CharacterType characterType) {
        this.id = id;
        this.name = name;
        this.characterType = characterType;
    }

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

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", characterType=" + characterType +
                '}';
    }
}
