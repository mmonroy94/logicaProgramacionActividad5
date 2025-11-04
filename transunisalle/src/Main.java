import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresa = new EmpresaTransporte();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // Bucle que permite al usuario interactuar con el sistema hasta que el usuario indique que quiere salir
        while (!salir) {
            // Imprimer las opciones del menú
            mostrarMenu();
            int opcion = leerEntero(sc, "Elige una opción: ");
            // Acorde a la opción elegida se ejecuta el método correspondiente
            switch (opcion) {
                case 1 -> registrarVehiculo(sc, empresa);
                case 2 -> registrarConductor(sc, empresa);
                case 3 -> {
                    empresa.listarVehiculos();
                    empresa.listarConductores();
                }
                case 4 -> {
                    System.out.print("Escribe placa a eliminar: ");
                    String placa = sc.nextLine();
                    empresa.eliminarVehiculoPorPlaca(placa);
                }
                case 5 -> {
                    System.out.print("Escribe nombre del conductor a eliminar: ");
                    String nombre = sc.nextLine();
                    empresa.eliminarConductorPorNombre(nombre);
                }
                case 6 -> {
                    System.out.print("Escribe la placa que quieres buscar: ");
                    String placa = sc.nextLine();
                    Vehiculo v = empresa.buscarVehiculoPorPlaca(placa);
                    System.out.println(v == null ? "No existe un vehiculo registrado con la placa indicada." : v.toString());
                }
                case 7 -> {
                    System.out.print("Escribe el nombre del conductor a buscar: ");
                    String nombre = sc.nextLine();
                    Conductor c = empresa.buscarConductorPorNombre(nombre);
                    System.out.println(c == null ? "No existe un conductor registrado con ese nombre" : c.toString());
                }
                case 8 -> {
                    int cap = leerEntero(sc, "Escribe la capacidad mínima: ");
                    List<Vehiculo> lista = empresa.listarVehiculosPorCapacidadMinima(cap);
                    if (lista.isEmpty())
                        System.out.println("Sin resultados.");
                    else
                        lista.forEach(System.out::println);
                }
                case 9 -> {
                    System.out.print("Escribe el modelo de vehículo que quieres buscar: ");
                    String modelo = sc.nextLine();
                    List<Vehiculo> lista = empresa.listarVehiculosPorModelo(modelo);
                    if (lista.isEmpty())
                        System.out.println("Sin resultados.");
                    else
                        lista.forEach(System.out::println);
                }
                case 10 -> {
                    System.out.println("Total de vehículos: " + empresa.totalVehiculos());
                    System.out.println("Promedio de capacidad: " + empresa.promedioCapacidad());
                }
                case 11 -> registrarViaje(sc, empresa);
                case 12 -> empresa.verUltimoViaje();
                case 13 -> empresa.deshacerUltimoViaje();
                case 14 -> empresa.mostrarHistorial();
                case 0 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        }
        System.out.println("Finalizado");
    }

    private static void mostrarMenu() {
        System.out.println("--- TransUnisalle 🚍 ---");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Registrar conductor");
        System.out.println("3. Listar vehículos y conductores");
        System.out.println("4. Eliminar vehículo por placa");
        System.out.println("5. Eliminar conductor por nombre");
        System.out.println("6. Buscar vehículo por placa");
        System.out.println("7. Buscar conductor por nombre");
        System.out.println("8. Listar vehículos por capacidad mínima");
        System.out.println("9. Listar vehículos por modelo");
        System.out.println("10. Total de vehículos y promedio de capacidad");
        System.out.println("11. Registrar nuevo viaje");
        System.out.println("12. Ver último viaje");
        System.out.println("13. Deshacer último viaje");
        System.out.println("14. Mostrar historial de viajes");
        System.out.println("0. Salir");
        System.out.println("---");
    }

    // Métodos que permiten validar la entrada de enteros y doubles. En caso de error vuelve a pedir la entrada
    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int x = Integer.parseInt(sc.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    private static double leerDouble(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double x = Double.parseDouble(sc.nextLine());
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    // Recolecta la información necesaria para registrar un vehículo
    private static void registrarVehiculo(Scanner sc, EmpresaTransporte empresa) {
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        int capacidad = leerEntero(sc, "Capacidad: ");
        Vehiculo v = new Vehiculo(placa, modelo, capacidad);
        empresa.registrarVehiculo(v);
    }

    // Recolecta la información necesaria para registrar un conductor
    private static void registrarConductor(Scanner sc, EmpresaTransporte empresa) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        Integer licencia = null;
        while (licencia == null) {
            System.out.print("Número de licencia: ");
            String linea = sc.nextLine();
            try {
                licencia = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Escribe solo números.");
            }
        }
        Conductor c = new Conductor(nombre, licencia);
        empresa.registrarConductor(c);
    }

    // Recolecta la información necesaria para registrar un viaje, se encarga de convertir los km a double y registrar la información en la pila
    private static void registrarViaje(Scanner sc, EmpresaTransporte empresa) {
        System.out.print("Destino: ");
        String destino = sc.nextLine();
        System.out.print("Conductor (nombre): ");
        String conductor = sc.nextLine();
        System.out.print("Vehículo (placa): ");
        String vehiculo = sc.nextLine();
        double kms = leerDouble(sc, "Kilómetros: ");
        Viaje v = new Viaje(destino, conductor, vehiculo, kms);
        empresa.registrarViaje(v);
    }
}
