package com.site.ActorManagement.repo;



import com.site.ActorManagement.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}