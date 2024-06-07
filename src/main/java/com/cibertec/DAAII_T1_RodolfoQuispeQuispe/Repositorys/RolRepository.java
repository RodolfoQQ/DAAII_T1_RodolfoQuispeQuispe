package com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Repositorys;

import com.cibertec.DAAII_T1_RodolfoQuispeQuispe.Models.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

   public Rol findByNomrol(String nomrol);
}