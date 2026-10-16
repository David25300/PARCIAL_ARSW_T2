package edu.eci.arsw.api.v1.blueprints.services;

import edu.eci.arsw.api.v1.blueprints.model.Blueprint;
import edu.eci.arsw.api.v1.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.api.v1.blueprints.persistence.BlueprintPersistence;
import edu.eci.arsw.api.v1.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.api.v1.blueprints.filters.BlueprintsFilter;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BlueprintsServices {

    private final BlueprintPersistence persistence;
    private final BlueprintsFilter filter;

    public BlueprintsServices(BlueprintPersistence persistence, BlueprintsFilter filter) {
        this.persistence = persistence;
        this.filter = filter;
    }

    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        persistence.saveBlueprint(bp);
    }

    public Set<Blueprint> getAllBlueprints() {
        return persistence.getAllBlueprints();
    }

    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        return persistence.getBlueprintsByAuthor(author);
    }

    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        return filter.apply(persistence.getBlueprint(author, name));
    }

    public void addPoint(String author, String name, int x, int y) throws BlueprintNotFoundException {
        persistence.addPoint(author, name, x, y);
    }
}
