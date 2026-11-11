package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import com.site.actor_management.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    // CREATE
    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

    // READ ALL
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<Actor> getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Actor updateActor(
            @PathVariable int id,
            @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable int id) {
        actorService.deleteActor(id);
    }
}