package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.AdminDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

public List<AdminDto> GetAdmins(){
    List<AdminDto> result = new ArrayList<>();
    AdminDto a = new AdminDto("salih", "salihje");
    AdminDto b = new AdminDto("kenan", "kenanje");
    AdminDto x = new AdminDto("adna", "adnaje");
    AdminDto y = new AdminDto("amra", "amraje");
    result.add(x);
    result.add(y);
    result.add(a);
    result.add(b);
    return result;
}

}
