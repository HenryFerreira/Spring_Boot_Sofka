package com.sofka.spring_boot.SpringBoot_Sofka.controllers;

import com.sofka.spring_boot.SpringBoot_Sofka.models.usuario_model;
import com.sofka.spring_boot.SpringBoot_Sofka.services.usuario_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController//--> Indica que es un controlador
@RequestMapping("/usuario")//Indica en que direccion del servidor se activan los metodos de esta clase
public class usuario_controller {
    @Autowired//Esto es una notación que le indica a Spring que esto es una instancia y que la puede utilizar
    usuario_service usuario_service;

    @GetMapping()//Indica que cuando llegue una petición GET ejecite este flujo
    public ArrayList<usuario_model> obtener_usuarios(){
        return usuario_service.obtener_usuarios();//implementa el metodo de usuario_service
    }

    @PostMapping()//
    public usuario_model guardar_usuario(@RequestBody usuario_model usuario){/*Con el RequestBody todos los clientes
         pueden enviar informacion dentro del cuerpo de la solicitud HTTP*/
        return usuario_service.guardar_usuario(usuario);//implementa el metodo de usuario_service
    }
}

