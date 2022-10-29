package com.RenterRoomSystem.ManageAPI.controller;

import com.RenterRoomSystem.ManageAPI.models.Building;
import com.RenterRoomSystem.ManageAPI.models.ResponseObject;
import com.RenterRoomSystem.ManageAPI.models.Role;
import com.RenterRoomSystem.ManageAPI.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    @Autowired
    private RoleRepository repository;
    @GetMapping("")
        //http://localhost:8080/api/v1/Buildings
    List<Role> getAllRole(){
        return repository.findAll();
    }
    //get detail building
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Integer id){
        Optional<Role> foundRole = repository.findById(id);
        return foundRole.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query role success", foundRole)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false","Can't find id =" + id, "")
                );

    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertRole(@RequestBody Role newRole){
        //2 building must not have the same name
        List<Role> foundRoleExsit = repository.findByRole(newRole.getRole().trim());
        if(foundRoleExsit.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed","Building name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "insert Role success", repository.save(newRole))
        );
    }
}
