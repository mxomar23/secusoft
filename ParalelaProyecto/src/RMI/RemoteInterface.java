/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author dec0d
 */
public interface RemoteInterface extends Remote{
    public ArrayList login(String usuario, String password) throws Exception;
    public void eliminar(String eliminacion) throws Exception;
    public int returnIDUser(int id)throws Exception;
    public void insertarUsuario( String usuario, String contraseña, int id_ususario )throws Exception;
    public void insertarMaestro(int id_alumno, String nombre, String apellido, int matricula, int grupo, int semestre)throws Exception;
    public void insertarHorario(int inicio, int fin, int maestro, int materia, int grupo, int salon)throws Exception;
    public void insertarServe(int id_alumno, String nombre, String apellido)throws Exception;
    public void insertarAlumno(int id_alumno, String nombre, String apellido, int matricula, int grupo, int semestre, int carrera, int ciclo, int turno)throws Exception;
    public void cerrarConexion()throws Exception;
    public ArrayList retornodeUsuario(String user)throws Exception;
    public ArrayList retornodeAlumnoDocente(String user)throws Exception;
    public ArrayList retornodeAlumno(int id)throws Exception;
    public ArrayList datosAlumno(int Dgrupo ,int Dsemestre, int Dcarrera ,int Dciclo ,int Dturno )throws Exception;
    public ArrayList retornodeDocente(int id)throws Exception;
    public ArrayList retornodeServe(int id)throws Exception;
    public ArrayList llenarAlumnosDocente(int id)throws Exception;
    public ArrayList llenarMaterias(int Dsemestre, int Dcarrera)throws Exception;
    public void capturaCalificacion(int id, String materia, int valor)throws Exception;
    public ArrayList calificacion(int id, String materia)throws Exception;
    public Connection conexion()throws Exception;
}
