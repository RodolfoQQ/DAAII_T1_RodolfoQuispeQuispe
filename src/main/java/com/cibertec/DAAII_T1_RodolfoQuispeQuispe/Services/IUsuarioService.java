package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Services;

import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);

}