package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.dtos.AdminDto;
import com.spaceshufflebe.services.AdminService;
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
