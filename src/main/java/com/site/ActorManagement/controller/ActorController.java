
package com.site.ActorManagement.controller;

import com.site.ActorManagement.model.Actor;
import com.site.ActorManagement.service.ActorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    // Constructor injection
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    // CREATE ACTOR
    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {

        Actor savedActor = actorService.addActor(actor);

        return new ResponseEntity<>(
                savedActor,
                HttpStatus.CREATED
        );
    }

    // GET ALL ACTORS
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {

        List<Actor> actors = actorService.getAllActors();

        return ResponseEntity.ok(actors);
    }

    // GET ACTOR BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable int id) {

        return actorService.getActorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE ACTOR
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(
            @PathVariable int id,
            @RequestBody Actor actor) {

        return actorService.updateActor(id, actor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE ACTOR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable int id) {

        boolean deleted = actorService.deleteActor(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
