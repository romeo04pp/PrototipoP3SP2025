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

    public Empresa(String idEmpresa, String nit, String nombre, String direccion, String telefono, String estatus_alumno) {
        this.idEmpresa = idEmpresa;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estatus_alumno = estatus_alumno;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstatus_alumno() {
        return estatus_alumno;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEstatus_alumno(String estatus_alumno) {
        this.estatus_alumno = estatus_alumno;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nit=" + nit + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", estatus_alumno=" + estatus_alumno + '}';
    }
    
    String idEmpresa;
    String nit;
    String nombre;
    String direccion;
    String telefono;
    String estatus_alumno;
    
    public Empresa() { //sin nada, sin parametros
    }
    
    

    

}
