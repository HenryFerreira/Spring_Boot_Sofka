package com.sofka.spring_boot.SpringBoot_Sofka.services;

import com.sofka.spring_boot.SpringBoot_Sofka.models.usuario_model;
import com.sofka.spring_boot.SpringBoot_Sofka.repositories.usuario_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        //Con 'save' si no se le envia el Id se entiende que se quiere insertar un dato
        //pero si le pasamos el Id se entiende que queremos actualizar un dato
        return usuario_repository.save(usuario);
    }

    //Metodos por Defecto del Repositorio

    //Obtiene los usuarios de la Tabla usuarios mediante su ID
    //Optional nos devuelve algo si encuentra lo buscado y si no lo encuentra tambiém
    public Optional<usuario_model> obtener_usuario_por_id(Long id){
        return usuario_repository.findById(id);
    }
    //Se utiliza el metodo abstracto creado en usuario_repository
    //Obtiene los usuarios de la Tabla usuarios mediante si prioridad
    public ArrayList<usuario_model> obtener_usuario_por_prioridad(Integer prioridad){
        return usuario_repository.findByPrioridad(prioridad);
    }

    //Elimina un usuario de la Tabla usuarios
    public boolean eliminar_usuario(Long id){
        try {//Si lo elimina devuelve true
            usuario_repository.deleteById(id);
            return true;
        } catch (Exception e) {//En caso contrario devuelve false
            return false;
        }
    }


}
