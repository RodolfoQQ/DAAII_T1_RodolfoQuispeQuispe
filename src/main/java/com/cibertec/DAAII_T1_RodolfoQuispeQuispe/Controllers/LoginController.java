package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Controllers;

import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Usuario;
import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(Model model) {
        return "auth/frmlogin";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){

        return "redirect:/auth/dashboard";
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model){
            model.addAttribute("modal",false);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        model.addAttribute("modalpasword",false);

        return "auth/home";
    }

    @GetMapping ("/registro")
    public String registroVista(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "auth/registro";
    }


   @PostMapping("/save")
   public String saveUsuario(@ModelAttribute Usuario usuario) {

       usuarioService.guardarUsuario(usuario);

       return "redirect:/auth/login";
   }

    @PostMapping("/savePaswordNew")
    public String savePaswordNew(@RequestParam("password") String password,
                                 @RequestParam("repitapassword") String repitapassword,
                                 Model model) {

        String patrones = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        if (!password.equals(repitapassword)) {
            model.addAttribute("error", "pasword no son iguales!");
            model.addAttribute("modal", true);
            model.addAttribute("modalpasword", true);

            return "auth/home";
        }

        if (!password.matches(patrones)) {
            model.addAttribute("error", "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un carácter especial.");
            model.addAttribute("modalpasword", true);
            return "auth/home";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioService.buscarUsuarioXNomUsuario(username);
        usuario.setPassword(password);
        usuarioService.guardarUsuario(usuario);

        return "redirect:/auth/dashboard";
    }



}
