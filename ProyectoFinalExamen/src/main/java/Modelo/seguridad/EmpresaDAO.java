/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Empresa; 
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class EmpresaDAO {

    private static final String SQL_SELECT = "SELECT idEmpresa, nit, nombre, direccion, telefono, estatus FROM empresa";
    private static final String SQL_INSERT = "INSERT INTO empresa(idEmpresa, nit, nombre, direccion, telefono, estatus) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE empresa SET nit=?, nombre=?, direccion=?, telefono=?, estatus=? WHERE idEmpresa = ?"; //comodines son los =?
    private static final String SQL_DELETE = "DELETE FROM empresa WHERE idEmpresa=?";
    private static final String SQL_QUERY = "SELECT idEmpresa, nit, nombre, direccion, telefono, estatus FROM empresa WHERE idEmpresa = ?";

    public List<Empresa> select() { //primer mantenimiento, va a consultar
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empresa alumno = null; //vendedor = alumno, Vendedor = Alumno
        List<Empresa> alumnos = new ArrayList<Empresa>(); //vendedores = alumnos

        try { //try es un if, permite condicionar y captar un error
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idEmpresa = rs.getString("idEmpresa");
                String nit = rs.getString("nit");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String estatus = rs.getString("estatus");
                
                alumno = new Empresa();
                alumno.setIdEmpresa(idEmpresa);
                alumno.setNit(nit);
                alumno.setNombre(nombre);
                alumno.setDireccion(direccion);
                alumno.setTelefono(telefono);
                alumno.setEstatus(estatus);
                
                
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return alumnos;
    }

    public int insert(Empresa alumno) { //segundo metodo, permite establecer informacion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(1, alumno.getIdEmpresa());
            stmt.setString(2, alumno.getNit());
            stmt.setString(3, alumno.getNombre());
            stmt.setString(4, alumno.getDireccion());
            stmt.setString(5, alumno.getTelefono());
            stmt.setString(6, alumno.getEstatus());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Empresa alumno) { //tercer mantenimiento, actualiza
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, alumno.getNit());
            stmt.setString(2, alumno.getNombre());
            stmt.setString(3, alumno.getDireccion());
            stmt.setString(4, alumno.getTelefono());
            stmt.setString(5, alumno.getEstatus());
            stmt.setString(6, alumno.getIdEmpresa());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Empresa alumno) {//cuarto metodo, borra
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, alumno.getIdEmpresa());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Empresa query(Empresa alumno) {    //Select enfocado
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Empresa> alumnos = new ArrayList<Empresa>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, alumno.getIdEmpresa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idEmpresa = rs.getString("idEmpresa");
                String nit = rs.getString("nit");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String estatus = rs.getString("estatus");
                
                alumno = new Empresa();
                alumno.setIdEmpresa(idEmpresa);
                alumno.setNit(nit);
                alumno.setNombre(nombre);
                alumno.setDireccion(direccion);
                alumno.setTelefono(telefono);
                alumno.setEstatus(estatus);
                //con los set, enviamos los objetos
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return alumno; //retorna el objeto unico
    }
        
}
