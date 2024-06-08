package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Controllers;

import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seguridad")
@AllArgsConstructor
public class ControllerSeguridad {

//muestra el modal cambiode pasword
    @GetMapping("/cambioPasword")
    public String cambioPasword(Model model){

        //muestra el modal para cambiar la contraeña
        model.addAttribute("modal",true);
        //muestra el error de pasword no cumple requsitos
        model.addAttribute("modalpasword",false);
        return "auth/home";
    }


}
