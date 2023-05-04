package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.AdminDto;
import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.models.RoleDto;
import com.spaceshufflebe.services.AdminService;
import com.spaceshufflebe.services.RideService;
import com.spaceshufflebe.services.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admins")
@RestController()
public class AdminController {

    private final AdminService adminService;

    AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/list")
    public List<AdminDto> getAdmins(){
        return adminService.GetAdmins();
    }

}
