package com.sofka.spring_boot.SpringBoot_Sofka.models;

import javax.persistence.*;//Importación de todas las bibliotecas de JPA

@Entity//Para deicrle al programa que este es un Modelo Real
@Table(name = "usuario")//--> Nombre de la Tabla en la Base de Datos
public class usuario_model {
    @Id//Indica que es una ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Que se Autogenere/Autoincrement
    @Column(unique = true, nullable = true)//Idica que es unica y no puede ser nulo
    //--------------------------//
    //Atributos
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;
    //--------------------------//


    //--------------------------------------------//
    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
    //--------------------------------------------//

}

