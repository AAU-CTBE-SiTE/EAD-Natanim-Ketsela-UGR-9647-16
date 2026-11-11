package com.site.actor_management.service;

import com.site.actor_management.model.Actor;
import com.site.actor_management.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // CREATE
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // READ ALL
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    // READ ONE
    public Optional<Actor> getActorById(int id) {
        return actorRepository.findById(id);
    }

    // UPDATE
    public Actor updateActor(int id, Actor updatedActor) {
        Actor existingActor = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor not found"));

        existingActor.setName(updatedActor.getName());
        existingActor.setMovieName(updatedActor.getMovieName());

        return actorRepository.save(existingActor);
    }

    // DELETE
    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }
}