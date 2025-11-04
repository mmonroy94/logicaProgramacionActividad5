//  Clase que representa a la empresa de transporte
//  Contiene las listas de vehiculos y conductores y una pila de viajes

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EmpresaTransporte {
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private List<Conductor> conductores = new ArrayList<>();
    private Stack<Viaje> historialViajes = new Stack<>();

    // CRUD para gestión de vehículos y conductores
    // Crear elementos en las listas de vehículos y conductores
    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo registrado: " + vehiculo);
        }
    }

    public void registrarConductor(Conductor conductor) {
        if (conductor != null) {
            conductores.add(conductor);
            System.out.println("Conductor registrado: " + conductor);
        }
    }

    // Leer elementos en las listas de vehículos y conductores
    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados");
            return;
        }
        System.out.println("--- Lista de Vehículos 🚙 ---");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

    public void listarConductores() {
        if (conductores.isEmpty()) {
            System.out.println("No hay conductores registrados");
            return;
        }
        System.out.println("--- Lista de Conductores 👥 ---");
        for (Conductor conductor : conductores) {
            System.out.println(conductor);
        }
    }

    // Eliminar elementos en las listas de vehículos y conductores
    public boolean eliminarVehiculoPorPlaca(String placa) {
        boolean eliminado = false;
        for (int i = vehiculos.size() - 1; i >= 0; i--) {
            Vehiculo vehiculo = vehiculos.get(i);
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculos.remove(i);
                eliminado = true;
                System.out.println("Vehículo eliminado: " + vehiculo);
            }
        }
        if (!eliminado) {
            System.out.println("No se encontró un vehículo con placa: " + placa);
        }
        return eliminado;
    }

    public boolean eliminarConductorPorNombre(String nombre) {
        boolean eliminado = false;
        for (int i = conductores.size() - 1; i >= 0; i--) {
            Conductor conductor = conductores.get(i);
            if (conductor.getNombre().equalsIgnoreCase(nombre)) {
                conductores.remove(i);
                eliminado = true;
                System.out.println("Conductor eliminado: " + conductor);
            }
        }
        if (!eliminado) {
            System.out.println("No se encontró un conductor con nombre: " + nombre);
        }
        return eliminado;
    }

    // Métodos de la segunda parte
    // Búsquedas y filtrado de información más especifico.
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public Conductor buscarConductorPorNombre(String nombre) {
        for (Conductor conductor : conductores) {
            if (conductor.getNombre().equalsIgnoreCase(nombre)) {
                return conductor;
            }
        }
        return null;
    }

    public List<Vehiculo> listarVehiculosPorCapacidadMinima(int capacidadMinima) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getCapacidad() >= capacidadMinima) {
                resultado.add(vehiculo);
            }
        }
        return resultado;
    }

    public List<Vehiculo> listarVehiculosPorModelo(String modelo) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {                
            if (v.getModelo().equalsIgnoreCase(modelo)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public int totalVehiculos() {
        return vehiculos.size();
    }

    public double promedioCapacidad() {
        if (vehiculos.isEmpty()) return 0.0;
        int suma = 0;
        for (Vehiculo vehiculo : vehiculos) {
            suma += vehiculo.getCapacidad();
        }
        return (double) suma / vehiculos.size();
    }

// Viajes - pila
    // Método para regustrar un nuevo viaje en la pila
    public void registrarViaje(Viaje viaje) {
        if (viaje != null) {
            historialViajes.push(viaje);
            System.out.println("Viaje registrado: " + viaje);
        }
    }

    // Método para leer el último viaje ingresado en la pila
    public Viaje verUltimoViaje() {
        if (historialViajes.isEmpty()) {
            System.out.println("No hay viajes en el historial");
            return null;
        }
        Viaje viaje = historialViajes.peek();
        System.out.println("Último viaje: " + viaje);
        return viaje;
    }

    // Método para eliminar el último viaje ingresado en la pila
    public Viaje deshacerUltimoViaje() {
        if (historialViajes.isEmpty()) {
            System.out.println("No hay viajes para deshacer");
            return null;
        }
        Viaje viaje = historialViajes.pop();
        System.out.println("Viaje deshecho: " + viaje);
        return viaje;
    }

    // Método para mostrar todos  lso viajes ingresados en la pila
    public void mostrarHistorial() {
        if (historialViajes.isEmpty()) {
            System.out.println("No hay viajes en el historial");
            return;
        }
        System.out.println("--- Historial de Viajes (del más reciente al más antiguo) --");
        for (int i = historialViajes.size() - 1; i >= 0; i--) {
            System.out.println(historialViajes.get(i));
        }
    }
}
