package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "null";
    }
}

