package com.sofka.spring_boot.SpringBoot_Sofka.controllers;

import com.sofka.spring_boot.SpringBoot_Sofka.models.usuario_model;
import com.sofka.spring_boot.SpringBoot_Sofka.services.usuario_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController//--> Indica que es un controlador
@RequestMapping("/usuario")//Indica en que direccion del servidor se activan los metodos de esta clase
public class usuario_controller {
    @Autowired//Esto es una notación que le indica a Spring que esto es una instancia y que la puede utilizar
    usuario_service usuario_service;

    @GetMapping()//Indica que cuando llegue una petición GET ejecite este flujo
    public ArrayList<usuario_model> obtener_usuarios(){
        return this.usuario_service.obtener_usuarios();//implementa el metodo de usuario_service
    }

    @PostMapping()
    public usuario_model guardar_usuario(@RequestBody usuario_model usuario){/*Con el RequestBody todos los clientes
         pueden enviar informacion dentro del cuerpo de la solicitud HTTP*/
        return this.usuario_service.guardar_usuario(usuario);//implementa el metodo de usuario_service
    }

    @GetMapping( path = "/{id}")//Indica que la direccion se le debe incluir la ID del objeto
    public Optional<usuario_model> obtener_usuario_por_id(@PathVariable("id") Long id){/* Con PathVariable
         obtenemos la id de la URL y se la pasamos como parametro al metodo*/
        return this.usuario_service.obtener_usuario_por_id(id);//implementa el metodo de usuario_service
    }

    @GetMapping("/query")//Creando otro servicio - ej: localhost/query?paramtro=1
    public ArrayList<usuario_model> obtener_usaurio_por_prioridad(@RequestParam("prioridad") Integer prioridad){/* Obtiene
         el valor del parametro de la URL y se lo pasa por parametro al metodo*/
        return this.usuario_service.obtener_usuario_por_prioridad(prioridad);//implementa el metodo de usuario_service
    }

    @GetMapping("/byEmail")//Creando otro servicio - ej: localhost/query?email=1
    public ArrayList<usuario_model> obtener_usaurio_por_email(@RequestParam("email") String email){/* Obtiene
         el valor del parametro de la URL y se lo pasa por parametro al metodo*/
        return this.usuario_service.obtener_usuario_por_email(email);//implementa el metodo de usuario_service
    }

    @DeleteMapping(path = "/{id}")
    public String eliminar_usuario_por_id(@PathVariable("id") Long id){/* Con PathVariable
         obtenemos la id de la URL y se la pasamos como parametro al metodo*/
        if(this.usuario_service.eliminar_usuario(id)){//Si devuelve true
            return "Se elimino el usuario con ID: [" + id + "]";
        } else {// Si devuelve false
            return "No pudo eliminar el usuario con ID: [" + id + "]";
        }
    }


}

