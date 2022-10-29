package com.RenterRoomSystem.ManageAPI.controller;

import com.RenterRoomSystem.ManageAPI.models.Building;
import com.RenterRoomSystem.ManageAPI.models.ResponseObject;
import com.RenterRoomSystem.ManageAPI.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Buildings")
public class BuildingController {
    //DI = dependentcy injection
    @Autowired
    private BuildingRepository repository;

    @GetMapping("")
    //http://localhost:8080/api/v1/Buildings
    List<Building> getAllBuilding(){
        return repository.findAll();
    }
    //get detail building
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id){
        Optional<Building> foundBuilding = repository.findById(id);
        return foundBuilding.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query building success", foundBuilding)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false","Can't find id =" + id, "")
                );

    }
    //insert new Buiding with post method
    //insert new Building with Post method
    //Postman: Raw, JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertBuilding(@RequestBody Building newBuilding){
        //2 building must not have the same name
        List<Building> foundBuildings = repository.findByName(newBuilding.getName().trim());
        if(foundBuildings.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed","Building name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "insert Building success", repository.save(newBuilding))
        );
    }
}
