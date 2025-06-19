package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping("")
    public List<Actor> getActor(){
        return  actorService.findAll();
    }
    @GetMapping("/{id}")
    public Actor getActor(@PathVariable long id){
        return  actorService.findById(id);
    }
    @PutMapping("/{id}")
    public Actor update(@PathVariable long id, @RequestBody Actor actor) {
        return actorService.update(id, actor);
    }
    @PostMapping()
    public Actor save(@RequestBody Actor actor){
        return  actorService.save(actor);
    }
    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id){
        return  actorService.delete(id);
    }
}
