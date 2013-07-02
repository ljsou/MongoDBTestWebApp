/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mongodb.control;

import java.util.Date;

/**
 *
 * @author javier
 */
public class User {
    private String _id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacimiento;
    private String [] premios;

    public User() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String[] getPremios() {
        return premios;
    }

    public void setPremios(String[] premios) {
        this.premios = premios;
    }       
}
