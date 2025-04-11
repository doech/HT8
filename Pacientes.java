/**
 * Ale Sierra #24405
 * Clase que representa a un paciente con nombre, condición y prioridad.
 */
public class Pacientes implements Comparable<Pacientes> {
    private String nombre;
    private String condicion;
    private String letra; 

    /**
     * Constructor 
     * @param nombre Nombre del paciente.
     * @param condicion Condición médica del paciente.
     * @param letra Letra de prioridad del paciente.
     */
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

    /**
     * Compara dos pacientes según su letra de prioridad.
     * 
     * @param otro El otro paciente a comparar.
     * @return Un valor negativo, cero o positivo según el orden de prioridad.
     */
    @Override
    public int compareTo(Pacientes otro) {
        return this.letra.compareTo(otro.letra);
    }

    @Override
    public String toString() {
        return nombre + " - " + condicion + " - Prioridad: " + letra;
    }
}