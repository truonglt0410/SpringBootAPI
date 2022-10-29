package com.RenterRoomSystem.ManageAPI.repositories;

import com.RenterRoomSystem.ManageAPI.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findByName(String buildingName);

}
