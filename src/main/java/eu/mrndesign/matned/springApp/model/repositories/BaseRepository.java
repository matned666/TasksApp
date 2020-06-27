package eu.mrndesign.matned.springApp.model.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<Entity> {

    List<Entity> findAll();

    Optional<Entity> findById(Integer id);

    Entity save(Entity entity);
}
