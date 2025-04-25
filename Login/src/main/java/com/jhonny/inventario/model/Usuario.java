package com.jhonny.inventario.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "usuario_table")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre1", length = 100, nullable = false)
    private String nombre1;

    @Column(name = "nombre2", length = 100)
    private String nombre2;

    @Column(name = "apellido1", length = 100, nullable = false)
    private String apellido1;

    @Column(name = "apellido2", length = 100)
    private String apellido2;

    @Column(name = "usuario", length = 100, nullable = false, unique = true)
    private String usuario;

    @Column(name = "contrasena", length = 255, nullable = false)
    private String contrasena;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo_electronico", length = 150, unique = true)
    private String correoElectronico;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Timestamp fechaCreacion;

    // Constructor vacío
    public Usuario() { }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre1() { return nombre1; }
    public void setNombre1(String nombre1) { this.nombre1 = nombre1; }

    public String getNombre2() { return nombre2; }
    public void setNombre2(String nombre2) { this.nombre2 = nombre2; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public Timestamp getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    //Conmstrutor Completo
//    public Usuario (int id, String nombre1,String nombre2, String apellido, String apellido2, String usuario, String contrasena,
//                    String correoElectronico, String telefono){
//
//        this.id = id;
//        this.nombre1 = nombre1;
//        this.nombre2 = nombre2;
//        this.apellido1 = apellido;
//        this.apellido2 = apellido2;
//        this.usuario = usuario;
//        this.contrasena = contrasena;
//        this.correoElectronico = correoElectronico;
//        this.telefono = telefono;
//    }
}
