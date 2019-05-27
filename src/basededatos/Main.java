package basededatos;

/**
 *
 * @author apinodominguez
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
 
        Conexion.connect();
        Interfaz objI = new Interfaz();
        objI.setVisible(true);
        objI.selectAll();
        
    }
    
}
