package com.negocio.ubi.api.rest.Dto;

import com.negocio.ubi.api.rest.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoNegocio {

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "latitud", precision = 9, scale = 6, nullable = false)
    private Double latitud;

    @Column(name = "longitud", precision = 9, scale = 6, nullable = false)
    private Double longitud;

    @Column(name = "horarioinicio")
    private java.sql.Time horarioInicio;

    @Column(name = "horariofin")
    private java.sql.Time horarioFin;

    @Column(name = "radiomaximo", precision = 5, scale = 2, nullable = false)
    private Double radioMaximo;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;
}
