package com.app.controller;

import com.app.domain.Dog;
import com.app.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rohit on 6/7/2017.
 */


@RestController
public class DogController {

private DogService dogService;


  @Autowired
  public DogController(DogService dogService){
       this.dogService = dogService;
   }
    @RequestMapping( value = "/")
    public Iterable<Dog> listAll()                      //listing all
    {

        return  dogService.listAll();
    }
    @RequestMapping("/breed/{type}")                 //display dogs of a particular breed
    public Iterable<Dog> findPostBySlug(@PathVariable(value="type") String type ) {
        return dogService.findByType(type);
    }
    @RequestMapping("/listgroup")                   //display all but grouped by breed
    public Iterable<Dog> findPostBySlug( ) {
        return dogService.findDogByGroup();
    }
    @RequestMapping("/details/{id}")               //description of the dog
    public List<Dog> finddetails(@PathVariable(value="id") long id ) {
        return dogService.findDetails(id);
    }
    @RequestMapping( value = "/voteup/{id}" )      //voteup a perticular dog
    public int update(@PathVariable(value="id") long id){
        return dogService.update(id);
    }
}
