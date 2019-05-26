package basededatos;

public class Main {

    public static void main(String[] args) {
 
        Conexion.connect();
        Interfaz objI = new Interfaz();
        objI.setVisible(true);
        objI.selectAll();
        
    }
    
}
