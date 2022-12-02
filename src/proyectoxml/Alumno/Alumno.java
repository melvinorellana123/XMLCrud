/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoxml.Alumno;
import java.util.UUID;
/**
 *
 * @author melvi
 */
public class Alumno {
   String nombre;
    String edad;
    String telefono;
    String identidad;
    String email;
    String sexo;

    UUID id;

    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Alumno(String nombre, String edad, String telefono, String identidad, String email, String sexo, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.identidad = identidad;
        this.email = email;
        this.sexo = sexo;
        this.id = UUID.fromString(id);
    }

    public Alumno(String nombre, String edad, String telefono, String identidad, String email, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.identidad = identidad;
        this.email = email;
        this.sexo = sexo;
        this.id = UUID.randomUUID();
    }

    public Alumno() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getEdad() + " " + this.getTelefono() + " " + this.getIdentidad() + " " + this.getEmail() + " " + this.getSexo() + " " + this.getId();
    }
}

