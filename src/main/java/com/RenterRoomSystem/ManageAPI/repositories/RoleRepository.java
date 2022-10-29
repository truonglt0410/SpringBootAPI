package com.RenterRoomSystem.ManageAPI.repositories;

import com.RenterRoomSystem.ManageAPI.models.Building;
import com.RenterRoomSystem.ManageAPI.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByRole(String Role);
}
