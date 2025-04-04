public class Pacientes{
    private String nombre;
    private String condicion;
    private String letra; 

    public Pacientes(String nombre, String condicion, String letra) {
        this.nombre = nombre;
        this.condicion = condicion;
        this.letra = letra;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCondicion() {
        return condicion;
    }
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
}
