package app.services;

import app.helpers.DataLoader;
import app.models.Crew;
import app.models.SpaceShip;
import app.repositories.SpaceCrewRepo;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpaceShipService {

    private DataLoader dataLoader;

    private SpaceShipRepo spaceShipRepo;

    private SpaceCrewRepo spaceCrewRepo;

    @Autowired
    public SpaceShipService(DataLoader dataLoader, SpaceShipRepo spaceShipRepo) {
        this.dataLoader = dataLoader;
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAllSpaceShip() {
        return (List<SpaceShip>) spaceShipRepo.findAll();
    }

    public   List<Crew> getAllCrewMembers() {
        return (List<Crew>) spaceCrewRepo.findAll();
    }
}
