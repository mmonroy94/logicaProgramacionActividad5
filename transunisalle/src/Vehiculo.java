// Clase que representa a un vehículo

public class Vehiculo {
    // Definimos los atributos de este "molde" que nos permitirá crear objetos de tipo Vehiculo. En este caso cada conductor debe tener asociado una placa, un modelo y una capacidad máxima de pasajeros
    private String placa;
    private String modelo;
    private int capacidad;

    public Vehiculo(String placa, String modelo, int capacidad) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    // Métodos get y set que me permitirán leer y modificar los atributos de un vehículo
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getCapacidad() { return capacidad; }

    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    @Override
    public String toString() {
        return "Vehiculo{Placa='" + placa + "', Modelo='" + modelo + "', Capacidad=" + capacidad + "}";
    }
}
