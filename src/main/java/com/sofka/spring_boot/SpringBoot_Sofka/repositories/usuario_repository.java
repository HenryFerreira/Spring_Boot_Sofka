package com.sofka.spring_boot.SpringBoot_Sofka.repositories;

import com.sofka.spring_boot.SpringBoot_Sofka.models.usuario_model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository//--> Indica que es una clase de tipo Repositorio
//CrudRepository es la clase que implementa la Mayoria de los metodos que se quieren usuar con la Base de Datos
public interface usuario_repository extends CrudRepository<usuario_model, Long> {
    //Permite buscar a todos los usuarios con una prioridad en espesifico
    public abstract ArrayList<usuario_model> findByPrioridad(Integer prioridad);
}
