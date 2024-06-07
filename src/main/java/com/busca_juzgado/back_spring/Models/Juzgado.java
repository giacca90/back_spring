package com.busca_juzgado.back_spring.Models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "juzgados")
public class Juzgado implements Serializable {
    @Id
    private Long id;
    private String nombre;
    private String direccion;
    private String codigo_postal;
    private String pueblo;
    private String provincia;
    private String comunidad;
    private String telefono;
    private String fax;
    private String correo;
    private String juez;
}