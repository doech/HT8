import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ale Sierra #24405
 * Clase para leer el contenido de un archivo de texto.
 */
public class LectorTxt {
    private String nombreA;
    private String contenidoA;

    /**
     * Constructor
     * @param nombreA Nombre del archivo .
     * @param contenidoA Contenido inicial.
     */
    public LectorTxt(String nombreA, String contenidoA) {
        this.nombreA = nombreA;
        this.contenidoA = contenidoA;
    }

    /**
     * Lee el contenido del archivo y lo almacena en la variable contenidoA.
     */
    public void leer() {
        contenidoA = ""; 
        try (BufferedReader br = new BufferedReader(new FileReader(nombreA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoA += linea + "\n";
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Obtiene el contenido leído del archivo.
     * 
     * @return El contenido del archivo como una cadena de texto.
     */
    public String getContenidoA() {
        return contenidoA;
    }
}