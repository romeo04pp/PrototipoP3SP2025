/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import domain.Alumno; 
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

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_alumno=? WHERE carnet_alumno = ?"; //comodines son los =?
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet_alumno=?";
    private static final String SQL_QUERY = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM alumnos WHERE carnet_alumno = ?";

    public List<Alumno> select() { //primer mantenimiento, va a consultar
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno alumno = null; //vendedor = alumno, Vendedor = Alumno
        List<Alumno> alumnos = new ArrayList<Alumno>(); //vendedores = alumnos

        try { //try es un if, permite condicionar y captar un error
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnetAlumno = rs.getInt("carnet_alumno");
                String nombreAlumno = rs.getString("nombre_alumno");
                String direccionAlumno = rs.getString("direccion_alumno");
                String telefonoAlumno = rs.getString("telefono_alumno");
                String emailAlumno = rs.getString("email_alumno");
                String estatusAlumno = rs.getString("estatus_alumno");
                
                alumno = new Alumno();
                alumno.setCarnet_alumno(carnetAlumno);
                alumno.setNombre_alumno(nombreAlumno);
                alumno.setDireccion_alumno(direccionAlumno);
                alumno.setTelefono_alumno(telefonoAlumno);
                alumno.setEmail_alumno(emailAlumno);
                alumno.setEstatus_alumno(estatusAlumno);
                
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

    public int insert(Alumno alumno) { //segundo metodo, permite establecer informacion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(1, alumno.getNombre_alumno());
            stmt.setString(2, alumno.getDireccion_alumno());
            stmt.setString(3, alumno.getTelefono_alumno());
            stmt.setString(4, alumno.getEmail_alumno());
            stmt.setString(5, alumno.getEstatus_alumno());

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

    public int update(Alumno alumno) { //tercer mantenimiento, actualiza
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, alumno.getNombre_alumno());
            stmt.setString(2, alumno.getDireccion_alumno());
            stmt.setString(3, alumno.getTelefono_alumno());
            stmt.setString(4, alumno.getEmail_alumno());
            stmt.setString(5, alumno.getEstatus_alumno());
            stmt.setInt(6, alumno.getCarnet_alumno());
            
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

    public int delete(Alumno alumno) {//cuarto metodo, borra
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getCarnet_alumno());
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
    public Alumno query(Alumno alumno) {    //Select enfocado
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, alumno.getCarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnetAlumno = rs.getInt("carnet_alumno");
                String nombreAlumno = rs.getString("nombre_alumno");
                String direccionAlumno = rs.getString("direccion_alumno");
                String telefonoAlumno = rs.getString("telefono_alumno");
                String emailAlumno = rs.getString("email_alumno");
                String estatusAlumno = rs.getString("estatus_alumno");
                
                alumno = new Alumno();
                alumno.setCarnet_alumno(carnetAlumno);
                alumno.setNombre_alumno(nombreAlumno);
                alumno.setDireccion_alumno(direccionAlumno);
                alumno.setTelefono_alumno(telefonoAlumno);
                alumno.setEmail_alumno(emailAlumno);
                alumno.setEstatus_alumno(estatusAlumno);
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
