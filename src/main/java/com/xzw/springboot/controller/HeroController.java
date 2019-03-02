package com.xzw.springboot.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzw.springboot.pojo.Hero;
import com.xzw.springboot.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
@RequestMapping("")
public class HeroController {
    @Autowired
    HeroService heroService;

//  Restful方式的增删改查（全部用Vue.js 的 AJAX访问）
//  增加
    @PostMapping("heroes")
    public String addHero(@RequestBody Hero hero) throws Exception{
        heroService.add(hero);
        return "success";
    }
//  删除
    @DeleteMapping("heroes/{id}")
    public String deleteHero(@PathVariable("id") int id) throws Exception{
        heroService.delete(id);
        return "success";
    }
//  修改
    @PutMapping("heroes")
    public String updateHero(@RequestBody Hero hero) throws Exception{
        heroService.update(hero);
        return "success";
    }
//  查询单个
    @GetMapping("heroes/{id}")
    public Hero getHero(@PathVariable("id") int id) throws Exception{
        return heroService.get(id);
    }
//  查询全部
    @GetMapping("heroes")
    public PageInfo<Hero> list(@RequestParam(value = "start", defaultValue = "1")int start, @RequestParam(value = "count", defaultValue = "5")int count) throws Exception{
        PageHelper.startPage(start, count, "id desc");
        List<Hero> hs = heroService.list();//5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        System.out.println(hs.size());
        return new PageInfo<>(hs,5);
    }


    //页面访问跳转
    @RequestMapping("listHero")
    public ModelAndView listHero() throws Exception{
        ModelAndView mav = new ModelAndView("listHero");
        return mav;
    }

    @RequestMapping("editHero")
    public ModelAndView editHero() throws Exception{
        ModelAndView mav = new ModelAndView("editHero");
        return mav;
    }

}
