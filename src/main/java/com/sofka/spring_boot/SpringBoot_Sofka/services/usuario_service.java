package com.sofka.spring_boot.SpringBoot_Sofka.services;

import com.sofka.spring_boot.SpringBoot_Sofka.models.usuario_model;
import com.sofka.spring_boot.SpringBoot_Sofka.repositories.usuario_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service//--> Indica que es una clase de tipo Servicio
public class usuario_service {
    @Autowired//Esto es una notación que le indica a Spring que esto es una instancia y que la puede utilizar
    usuario_repository usuario_repository;

    //Obtiene todos los usuarios de la Tabla usuarios
    public ArrayList<usuario_model> obtener_usuarios(){
       return (ArrayList<usuario_model>) usuario_repository.findAll();
    }

    //Inserta un usuario en la Tabla usuario
    public usuario_model guardar_usuario(usuario_model usuario){
        return usuario_repository.save(usuario);
    }
}
