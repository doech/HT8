import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorTxt {
    private String nombreA;
    private String contenidoA;

    public LectorTxt(String nombreA, String contenidoA) {
        this.nombreA = nombreA;
        this.contenidoA = contenidoA;
    }

    public void leer() {
        contenidoA= "";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoA += linea + "\n";
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public String getContenidoA() {
        return contenidoA;
    }
}