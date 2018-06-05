/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import RMI.RemoteInterface;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{
    
    public ServerImplements() throws Exception{
        
        super();
    
    }
    
    public Connection conexion(){
        Connection conexion;
        try{
            conexion = DriverManager.getConnection ("jdbc:mysql://localhost/proyecto","root", "");
            System.out.println("Si");
            return  conexion;
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Que paso?");
        return null;
    }
    
    public void cerrarConexion(){
        Connection c;
         try{
            c = DriverManager.getConnection ("jdbc:mysql://localhost/proyecto","root", "");
            System.out.println("Si");
            c.close();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int returnIDUser(int id){
        int idUser = id;
        return idUser;
    }
    
    public void eliminar(String eliminacion){
        try{
            Connection conexion = conexion();
            String SSQL="DELETE FROM `usuarios` WHERE usuario = '"+eliminacion+"' ";
            Statement s = conexion.createStatement();
            s.executeUpdate(SSQL);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList login(String usuario, String password){
        int resultado = 0;
        ArrayList al = new ArrayList();
        try {
            Connection conexion = conexion();
            String SSQL="SELECT * FROM usuarios WHERE usuario = '"+usuario+"' AND contra = '"+password+"'";
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(SSQL);
        if(rs.next()){
            al.add(rs.getInt(1));
            al.add(rs.getInt(4));
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
    }
    return al;
    }

    public void insertarAlumno(int id_alumno, String nombre, String apellido, int matricula, int grupo, int semestre, int carrera, int ciclo, int turno) throws Exception {
        try {
            Connection conexion = conexion();
            String SSQL="INSERT INTO `alumnos` (`id_usuario`, `nombre`, `apellido`, `matricula`,`id_grupo`, `id_semestre`,"
                        + " `id_carrera`, `id_ciclo`, `id_turno` ) VALUES ('"+id_alumno+"', '"+nombre+"', '"+apellido+"'"
                        + ",'"+matricula+"','"+grupo+"','"+semestre+"', '"+carrera+"', '"+ciclo+"', '"+turno+"') ";
            Statement s = conexion.createStatement();
            s.executeUpdate(SSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarMaestro(int id_alumno, String nombre, String apellido, int matricula, int grupo, int semestre) throws Exception {
        try {
            Connection conexion = conexion();
            String SSQL="INSERT INTO `maestros` (`id_usuario`, `nombre`, `apellido`, `matricula`, `id_grupo` ,`id_semestre`) VALUES ('"+id_alumno+"', '"+nombre+"', '"+apellido+"'"
                        + ",'"+matricula+"') ";
            Statement s = conexion.createStatement();
            s.executeUpdate(SSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertarServe(int id_alumno, String nombre, String apellido) throws Exception {
        try {
            Connection conexion = conexion();
            String SSQL="INSERT INTO `serve` (`id_usuario`, `nombre`, `apellido` ) VALUES ('"+id_alumno+"', '"+nombre+"', '"+apellido+"'"+ ") ";
            Statement s = conexion.createStatement();
            s.executeUpdate(SSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void insertarUsuario( String user, String passwd, int Type){
        try {
            Connection conexion = conexion();
            String SSQL="INSERT INTO `usuarios` (`id_usuario`, `usuario`, `contra`, `tipo_usuario`) VALUES (NULL, "
                    + "'"+user+"', '"+passwd+"', '"+Type+"') ";
            Statement s = conexion.createStatement();
            s.executeUpdate(SSQL);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public ArrayList retornodeUsuario(String usernew){
         ResultSet rs;
         ArrayList al = new ArrayList();
        try {
            Connection conexion = conexion();
            String SSQL="SELECT * FROM usuarios WHERE usuario='"+usernew+"'";
            Statement s = conexion.createStatement();
           rs = s.executeQuery(SSQL);
           while(rs.next()){
               al.add(rs.getInt(1));
           }
           return al;
        } catch (Exception e) {
        }
        return null;
    }
 public ArrayList retornodeAlumnoDocente(String usernew){
         ResultSet rs;
         ArrayList al = new ArrayList();
        try {
            Connection conexion = conexion();
            String SSQL="SELECT * FROM alumnos WHERE nombre='"+usernew+"'";
            Statement s = conexion.createStatement();
           rs = s.executeQuery(SSQL);
           while(rs.next()){
               al.add(rs.getInt(1));
           }
           return al;
        } catch (SQLException e) {
            System.err.println("Error sql "+ e);
        }
        return null;
    }
    public ArrayList retornodeAlumno(int id){
         ResultSet rs;
         ArrayList al = new ArrayList();
         
         try {
             Connection conexion = conexion();
             Statement s = conexion.createStatement();
              ResultSet rs1 = s.executeQuery("SELECT * FROM alumnos WHERE id_usuario = '"+id+"'");
            while(rs1.next()){
                al.add(rs1.getString(2));//nombre
                al.add(rs1.getString(3));//apellido
                al.add(rs1.getString(4));//matricula
                 al.add(rs1.getInt(5));//id_grupo
                al.add(rs1.getInt(6));//id_semestre
                al.add(rs1.getInt(7));//id_carrera
                al.add(rs1.getInt(8));//id_ciclo
                al.add(rs1.getInt(9));//id_turno
                return al;
            }
         } catch (Exception e) {
         }
        return null;
    }
     public ArrayList datosAlumno(int Dgrupo ,int Dsemestre, int Dcarrera ,int Dciclo ,int Dturno ){
         ResultSet rs;
         ArrayList al = new ArrayList();
         try {
             Connection conexion = conexion();
             Statement s = conexion.createStatement();
              ResultSet rs2 = s.executeQuery("SELECT * FROM `grupos`,`semestre`,"
                    + " `carrera`, `ciclo` , `turnos` WHERE id_grupo = '"+Dgrupo+"' AND id_carrera = '"+Dcarrera+"' "
                            + "AND id_semestre = '"+Dsemestre+"' AND id_ciclo = '"+Dciclo+"' AND id_turno = '"+Dturno+"'");
            while(rs2.next()){
                al.add(rs2.getString(2));//grupo
                 al.add(rs2.getString(6));//carrera
                 al.add(rs2.getString(4));//semestre
                al.add(rs2.getString(8));//ciclo
                 al.add(rs2.getString(12));//turno
                 return al;
            }
            
         } catch (Exception e) {
         }
        return null;
    }
     public ArrayList retornodeDocente(int id){
         ArrayList al = new ArrayList();
         int Dgrupo = 0;
         try {
              Connection conexion = conexion();
             Statement s = conexion.createStatement();
          ResultSet rs1 = s.executeQuery("SELECT * FROM maestros WHERE id_usuario = '"+id+"'");
            while(rs1.next()){
                al.add(rs1.getString(2));
                al.add(rs1.getString(3));
                al.add(rs1.getString(4));
                Dgrupo = rs1.getInt(5);
            }
            ResultSet rs2 = s.executeQuery("SELECT * FROM `grupos` WHERE id_grupo = '"+Dgrupo+"' ");
            while(rs2.next()){
                al.add(rs2.getString(2));
                
            }
            return al;
         } catch (Exception e) {
         }
         return null;
     }
     public ArrayList retornodeServe(int id){
         ArrayList al = new ArrayList();
         int Dgrupo = 0;
         try {
              Connection conexion = conexion();
             Statement s = conexion.createStatement();
           ResultSet rs1 = s.executeQuery("SELECT * FROM serve WHERE id_usuario = '"+id+"'");
            
            while(rs1.next()){
                al.add(rs1.getString(2));
                al.add(rs1.getString(3));
                
            }
         return al;
         } catch (Exception e) {
         }
         return null;
     }
          public ArrayList llenarAlumnosDocente(int id){
            ArrayList al = new ArrayList();
            int grupo = 0, semestre = 0;
            try {
            Connection conexion = conexion();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM maestros WHERE id_usuario= '"+id+"' ");
            while (rs.next()){
            grupo = rs.getInt(5);
            semestre = rs.getInt(6);
            }
                
            ResultSet rs2 = s.executeQuery("SELECT * FROM alumnos WHERE id_semestre= '"+grupo+"' AND id_grupo = '"+semestre+"'");
            while(rs2.next()) {
            al.add(rs2.getString(2));
            
            }
         return al;
         } catch (Exception e) {
         }
         return null;
     }
          public ArrayList llenarMaterias(int Dsemestre, int Dcarrera){
               ArrayList al = new ArrayList();
            
            try {
            Connection conexion = conexion();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("Select * FROM materias WHERE id_semestre = '"+Dsemestre+"'"
                    + " AND id_carrera = '"+Dcarrera+"'");
            while (rs.next()){
            al.add(rs.getString(2));
            }
         return al;
         } catch (Exception e) {
         }
         return null;
          }
          
          public void capturaCalificacion(int id, String materia, int valor){
              int id_materia = 0;
              try {
            Connection conexion = conexion();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("Select * FROM materias WHERE nombre = '"+materia+"'");
            while(rs.next()){
                id_materia = rs.getInt(1);
            }
            String SSQL="INSERT INTO `calificaciones` (`id_usuario`, `id_materia`, `valor`) VALUES ("
                    + "'"+id+"', '"+id_materia+"', '"+valor+"') ";
           
            s.executeUpdate(SSQL);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
              
          }
          public ArrayList calificacion(int id, String materia){
               ArrayList al = new ArrayList();
               int id_materia = 0;
          
               try {
            Connection conexion = conexion();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("Select * FROM materias WHERE nombre = '"+materia+"'");
            while(rs.next()){
                id_materia = rs.getInt(1);
            }
            ResultSet rs1 = s.executeQuery("Select * FROM calificaciones WHERE id_usuario = '"+id+"'"
                    + " AND id_materia = '"+id_materia+"'");
            while (rs1.next()){
            al.add(rs1.getString(3));
            }
         return al;
             } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
              return null;
          }
}
