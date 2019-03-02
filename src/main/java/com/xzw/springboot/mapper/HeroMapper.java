package com.xzw.springboot.mapper;

import com.xzw.springboot.pojo.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "heroMapper")    //防止在Autowired注入时报假错
public interface HeroMapper {

    int add(Hero hero);

    void delete(int id);

    void update(Hero hero);

    Hero get(int id);

    List<Hero> list();

}
