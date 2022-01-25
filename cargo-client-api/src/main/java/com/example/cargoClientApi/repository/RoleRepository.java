package com.example.cargoClientApi.repository;


import com.example.cargoClientApi.models.ERole;
import com.example.cargoClientApi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
