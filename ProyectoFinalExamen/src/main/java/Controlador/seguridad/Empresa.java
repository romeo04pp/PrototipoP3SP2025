/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author visitante
 */
public class Empresa {
    
    int carnet_alumno;
    String nombre_alumno;
    String direccion_alumno;
    String telefono_alumno;
    String email_alumno;
    String estatus_alumno;
    
    public Empresa() { //sin nada, sin parametros
    }
    
    public int getCarnet_alumno() {
        return carnet_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    public String getEmail_alumno() {
        return email_alumno;
    }

    /*Atributos para campos de alumnos--------------*/
    public String getEstatus_alumno() {
        return estatus_alumno;
    }

    public void setCarnet_alumno(int carnet_alumno) {
        this.carnet_alumno = carnet_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    public void setEmail_alumno(String email_alumno) {
        this.email_alumno = email_alumno;
    }

    public void setEstatus_alumno(String estatus_alumno) {
        this.estatus_alumno = estatus_alumno;
    }
    
    public Empresa(int carnet_alumno) { //mas especifico
        this.carnet_alumno = carnet_alumno;
    }

    public Empresa(String nombre_alumno, String direccion_alumno, String telefono_alumno, String email_alumno, String estatus_alumno) {
        
        this.nombre_alumno = nombre_alumno;
        this.direccion_alumno = direccion_alumno;
        this.telefono_alumno = telefono_alumno;
        this.email_alumno = email_alumno;
        this.estatus_alumno = estatus_alumno;
    }

    @Override
    public String toString() {
        return "Alumno{" + "carnet_alumno=" + carnet_alumno + ", nombre_alumno=" + nombre_alumno + ", direccion_alumno=" + direccion_alumno + ", telefono_alumno=" + telefono_alumno + ", email_alumno=" + email_alumno + ", estatus_alumno=" + estatus_alumno + '}';
    }

    

}
