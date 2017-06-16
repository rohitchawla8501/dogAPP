package com.app.repository;

import com.app.domain.Dog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rohit on 6/7/2017.
 */

@Repository
    public interface DogRepository extends CrudRepository<Dog, Long> {

    List<Dog> findAllByOrderByVoteDesc();  //list all ordered by vote

    @Query("select p from Dog p where p.type = ?1 order by vote desc")  //list by breed type
    List<Dog> findDogByType(String type);

    @Query("select p from Dog p  order by p.type  ,p.vote desc")  //list all by group and vote
    List<Dog> findDogByGroup();

    @Query("select description from Dog where id =?1")             //list the description of a dog
    List<Dog> findDetails(long id);

    }

