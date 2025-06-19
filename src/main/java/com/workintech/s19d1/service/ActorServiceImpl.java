package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        Optional<Actor> actor= actorRepository.findById(id);
        if(actor.isPresent()){
            return actor.get();
        }
        throw  new ApiException("actor is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, Actor updatedMovie) {
      Actor actor=   this.findById(id);
      if(actor==null){
          actorRepository.save(updatedMovie);
      }
        return null;
    }

    @Override
    public Actor delete(long id) {
        Actor actor=  this.findById(id);
        actorRepository.delete(actor);
        return actor;

    }

    @Override
    public void delete(Actor actor) {
         actorRepository.delete(actor);
    }
}
