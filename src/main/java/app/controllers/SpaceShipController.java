package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.SpaceCrewRepo;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    private final SpaceShipRepo spaceShipRepo;
    private final SpaceCrewRepo spaceCrewRepo;

    @Autowired
    public SpaceShipController(SpaceShipRepo spaceShipRepo, SpaceCrewRepo spaceCrewRepo) {
        this.spaceShipRepo = spaceShipRepo;
        this.spaceCrewRepo = spaceCrewRepo;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/spaceships"})
    public String showSpaceships(Model model) {

        List<SpaceShip> spaceShipList = (List<SpaceShip>) spaceShipRepo.findAll();
        model.addAttribute("spaceshipall", spaceShipList);

        return "spaceships";
    }

    @GetMapping(value = {"/result"})
    public String findByActive(Model model) {

        List<SpaceShip> spaceShipList = (List<SpaceShip>) spaceShipRepo.findSpaceShipByisActiveTrue();
        model.addAttribute("results", spaceShipList);

        return "result";
    }

    @GetMapping(value = {"/allcrewdata"})
    public String allCrewData(Model model) {

        List<Crew> CrewList = (List<Crew>) spaceCrewRepo.findAll();
        model.addAttribute("alldataofmembers", CrewList);

        return "allcrewdata";
    }
}
