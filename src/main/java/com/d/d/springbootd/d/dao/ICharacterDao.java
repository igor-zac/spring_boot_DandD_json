package com.d.d.springbootd.d.dao;

import com.d.d.springbootd.d.model.Character;
import java.util.List;

public interface ICharacterDao {
    public List<Character> findAll();
    public Character findById(int id);
    public Character save(Character character);
    public boolean deleteById(int id);
}
