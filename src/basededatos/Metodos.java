package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author apinodominguez
 */
public class Metodos {
    
    Mensaje objMen = new Mensaje();
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/apinodominguez/Descargas/SQLiteStudio/BasesDeDatos/Libreria.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
             objMen.setVisible(true);
        }
        return conn;
    }
    
    /**
     *
     * @param titulo
     * @param sql
     */
    public void cuenta(String titulo, String sql){
               int cuenta= 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,titulo);
            //
            ResultSet rs  = pstmt.executeQuery();
            
           cuenta = rs.getInt(1);
            System.out.println("Se han modificado " + cuenta + "lineas");
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
             objMen.setVisible(true);
        }
    }
   
    /**
     *
     * @param titulo
     * @param sql
     */
    public void cuenta(int titulo, String sql){
               int cuenta= 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,titulo);
            //
            ResultSet rs  = pstmt.executeQuery();
            
           cuenta = rs.getInt(1);
            System.out.println("Se han modificado " + cuenta + "lineas");
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
             objMen.setVisible(true);
        }
    }
    
    /**
     *
     * @param name
     * @param sql
     */
    public void ConsultaSimple(String name, String sql) {
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            objMen.setVisible(true);
            objMen.cambiarText("La consulta se realizo correctamente");
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
             objMen.setVisible(true);
        }
    }
    
    /**
     *
     * @param isbn
     * @param sql
     */
    public void ConsultaSimple(int isbn, String sql) {
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.executeUpdate();
            objMen.setVisible(true);
            objMen.cambiarText("La consulta se realizo correctamente");
        } catch (SQLException e) {
           objMen.cambiarText(e.getMessage());
            objMen.setVisible(true);
        }
    }
    
    /**
     *
     * @param name
     * @param id
     * @param sql
     */
    public void ConsultaCompleja(String name, int id, String sql) {
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            objMen.setVisible(true);
            objMen.cambiarText("La consulta se realizo correctamente");
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
            objMen.setVisible(true);
        }
    }
    
    /**
     *
     * @param name
     * @param tit
     * @param sql
     */
    public void ConsultaCompleja(String name, String tit, String sql) {
        
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, tit);
            pstmt.executeUpdate();
            objMen.setVisible(true);
            objMen.cambiarText("La consulta se realizo correctamente");
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
            objMen.setVisible(true);
        }
    }
    
    /**
     *
     * @param autor
     * @param sql
     * @return
     */
    public int seleccionWhere(String autor, String sql){
               int id = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,autor);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
               id = (rs.getInt("ID"));
                                  
            }
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
        }
        return  id;
    }
    
//    public Object[] seleccionarFilas(int isbn){
//        String sql = "SELECT isbn, titulo, nombre FROM libros INNER JOIN autor ON autor.id = libros.idautor WHERE isbn = (?)";
//        Object[] row = {0, "",""};
//        
//        try (Connection conn = this.connect();
//             PreparedStatement pstmt  = conn.prepareStatement(sql)){
//            
//            // set the value
//            pstmt.setInt(1,isbn);
//            //
//            ResultSet rs  = pstmt.executeQuery();
//            
//            // loop through the result set
//            while (rs.next()) {
//               row = {rs.getInt("isbn"); rs.getString("titulo"); rs.getString("nombre")}
//                                  
//            }
//        } catch (SQLException e) {
//            objMen.cambiarText(e.getMessage());
//        }
//        return  row;
//        
//        
    } 
    
  
     
    
    
    
    

