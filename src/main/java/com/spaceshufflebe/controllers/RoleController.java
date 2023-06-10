package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.dtos.RoleDto;
import com.spaceshufflebe.services.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/choose-a-role")
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public boolean chooseRole(@RequestBody RoleDto role) {
        return roleService.Role(role);
    }


}




