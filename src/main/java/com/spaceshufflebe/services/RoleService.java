package com.spaceshufflebe.services;

import com.spaceshufflebe.models.RoleDto;
import org.springframework.stereotype.Service;

//false = driver
//true = passenger

@Service
public class RoleService {

    public boolean Role(RoleDto role) {
        if (role.equals(false)) {
            return false;
        } else {
            return true;
        }
    }


}
