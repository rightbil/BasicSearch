package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/")
    public String index(Model model    ){

        Person person1 = new Person();
        person1.setName("Ray");
        person1.setAge("28");
        person1.setHeight("5'11\"");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Bililign");
        person2.setAge("34");
        person2.setHeight("5'09\"");
        personRepository.save(person2);

        Person person3 = new Person();
        person3.setName("Bililign");
        person3.setAge("34");
        person3.setHeight("5'12\"");
        personRepository.save(person3);


        model.addAttribute("people",personRepository.findAll());
        return "index";

    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
       model.addAttribute("searchResult",personRepository.findByName(search));
       return "searchlist";
    }
}
