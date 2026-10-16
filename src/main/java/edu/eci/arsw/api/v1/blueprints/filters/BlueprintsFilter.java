package edu.eci.arsw.api.v1.blueprints.filters;

import edu.eci.arsw.api.v1.blueprints.model.Blueprint;

public interface BlueprintsFilter {
    Blueprint apply(Blueprint bp);
}
