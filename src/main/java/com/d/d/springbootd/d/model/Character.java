package com.d.d.springbootd.d.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = Character.TABLE_NAME)
public class Character {

    public static final String TABLE_NAME = "dd_character";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "character_type_id")
    private CharacterType characterType;

    public Character() {}

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
                ", characterType=" + characterType.toString() +
                '}';
    }
}
