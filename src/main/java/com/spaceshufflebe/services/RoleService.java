package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.RoleDto;
import com.spaceshufflebe.repositories.RoleRepository;
import org.springframework.stereotype.Service;

//false = driver
//true = passenger

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public int drivers=0;
    public int passengers=0;
    public boolean Role(RoleDto role) {
        if (role.isDriver()){
            drivers++;
            return false;
        } else {
            passengers++;
            return true;
        }
    }


}
