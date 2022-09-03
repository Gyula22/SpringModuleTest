package app.repositories;

import app.models.Crew;
import app.models.SpaceShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceCrewRepo extends CrudRepository<Crew, Long> {

  //  List<Crew> findSByName(String Titanic);




}
