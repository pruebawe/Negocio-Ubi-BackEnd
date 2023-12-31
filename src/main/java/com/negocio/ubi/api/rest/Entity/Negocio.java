package com.negocio.ubi.api.rest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity(name = "negocio")
@Table(name = "negocios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Negocio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "latitud", nullable = false)
    private Double latitud;

    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Column(name = "horarioinicio")
    private java.sql.Time horarioInicio;

    @Column(name = "horariofin")
    private java.sql.Time horarioFin;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    public Negocio(String nombre, String descripcion, String direccion, Double latitud, Double longitud, Time horarioInicio, Time horarioFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }
}
