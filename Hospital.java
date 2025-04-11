import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ale Sierra #24405
 * Clase principal que simula un sistema de gestión de pacientes en un hospital.
 * Permite agregar pacientes, atenderlos según su prioridad y ver la lista de pacientes.
 */
public class Hospital {

    /**
     * Carga los pacientes desde un archivo de texto.
     * 
     * @return Una lista de pacientes en el archivo para asegurarse que los esté leyendo
     */
    public ArrayList<Pacientes> cargarPacientesDesdeArchivo() {
        String nombreArchivo = "pacientes.txt"; 
        
        LectorTxt lector = new LectorTxt(nombreArchivo, "");
        lector.leer();

        String contenido = lector.getContenidoA();
        System.out.println("Contenido del archivo:\n" + contenido);
        String[] lineasArray = contenido.split("\n");

        ArrayList<Pacientes> listaPacientes = new ArrayList<>();

        for (String linea : lineasArray) {
            String[] partes = linea.split(",");
            if (partes.length == 3) { 
                String nombre = partes[0].trim();
                String condicion = partes[1].trim();
                String letra = partes[2].trim();

                Pacientes paciente = new Pacientes(nombre, condicion, letra);
                listaPacientes.add(paciente); 
            }
        }

        return listaPacientes;
    }

    /**
     * Método principal que ejecuta el sistema de gestión de pacientes.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        System.out.println("\nCENTRO MEDICO: EMERGENCIAS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de cola (heap/jcf): ");
        String tipoCola = scanner.nextLine();
        Factory<Pacientes> factory = new Factory<>();
        PriorityQ<Pacientes> cola = factory.getPriorityQueue(tipoCola);
            if (cola == null) {
                System.out.println("No válido");
                return;
            }
        ArrayList<Pacientes> pacientesDesdeArchivo = hospital.cargarPacientesDesdeArchivo();
        for (Pacientes paciente : pacientesDesdeArchivo) {
            cola.add(paciente);
        }

        while (true) {
            System.out.println("\nElija opción: ");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Ver siguiente paciente");
            System.out.println("4. Ver lista de pacientes en orden de prioridad");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la condición: ");
                    String condicion = scanner.nextLine();
                    System.out.println("Ingrese la letra de prioridad: ");
                    String letra = scanner.nextLine();

                    Pacientes nuevoPaciente = new Pacientes(nombre, condicion, letra);
                    cola.add(nuevoPaciente); 
                    System.out.println("Paciente agregado");
                    break;

                case 2:
                    Pacientes atendido = cola.remove(); 
                    if (atendido != null) {
                        System.out.println("Paciente atendido: " + atendido.getNombre() + " - " + atendido.getCondicion());
                    } else {
                        System.out.println("No hay pacientes en la cola.");
                    }
                    break;

                case 3:
                    Pacientes siguiente = cola.peek(); 
                    if (siguiente != null) {
                        System.out.println("Siguiente paciente: " + siguiente.getNombre() + " - " + siguiente.getCondicion());
                    } else {
                        System.out.println("No hay pacientes en la cola.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de pacientes en orden de prioridad:");
                    PriorityQ<Pacientes> colaTemporal = factory.getPriorityQueue(tipoCola);
                    while (!cola.isEmpty()) {
                        Pacientes paciente = cola.remove();
                        System.out.println(paciente.getNombre() + " - " + paciente.getCondicion() + " - Prioridad: " + paciente.getLetra());
                        colaTemporal.add(paciente); 
                    }
                
                    while (!colaTemporal.isEmpty()) {
                        cola.add(colaTemporal.remove());
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
