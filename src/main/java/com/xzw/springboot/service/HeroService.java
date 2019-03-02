package com.xzw.springboot.service;

import com.xzw.springboot.pojo.Hero;

import java.util.List;

public interface HeroService {

    int add(Hero hero);

    void delete(int id);

    void update(Hero hero);

    Hero get(int id);

    List<Hero> list();

}
