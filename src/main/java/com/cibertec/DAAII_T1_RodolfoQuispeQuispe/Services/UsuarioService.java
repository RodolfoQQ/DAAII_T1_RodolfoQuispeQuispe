package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Services;


import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Rol;
import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Usuario;
import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Repositorys.RolRepository;
import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Repositorys.UsuarioRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;


    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }




}
