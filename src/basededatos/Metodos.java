package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos {
    
    Mensaje objMen = new Mensaje();
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\SQlite\\BasesDeDatos\\LibreriaFinal.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            objMen.cambiarText(e.getMessage());
             objMen.setVisible(true);
        }
        return conn;
    }
    
    
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
    
    
  
     
    
    }
    
    

