package com.app.services;

import com.app.domain.Dog;
import com.app.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Rohit on 6/7/2017.
 */

@Service
public class DogService {
    private DogRepository dogRepository;


    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;}


    public Iterable<Dog> listAll() {
        return dogRepository.findAllByOrderByVoteDesc();
    }


    public List<Dog> findByType(String type)
    {
        return dogRepository.findDogByType(type);
    }

    public List<Dog> findDogByGroup(){return dogRepository.findDogByGroup();}

    public List<Dog> findDetails(long id)
    {
     return dogRepository.findDetails(id);
    }

    public int update(long id)              //updating vote up value
    {
        Dog dog = dogRepository.findOne(id);
        dog.setVote(dog.getVote()+1);


        dogRepository.save(dog);
    return 1;
    }
}
