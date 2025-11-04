// Clase que representa a un conductor
// Para registrar viajes en una pila

public class Viaje {
    private String destino;
    private String conductor;
    private String vehiculo;
    private double kilometros;

    public Viaje(String destino, String conductor, String vehiculo, double kilometros) {
        this.destino = destino;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.kilometros = kilometros;
    }

    // Métodos get y set que me permitirán leer los atributos que conforman los detalles de un viaje
    public String getDestino() { return destino; }
    public String getConductor() { return conductor; }
    public String getVehiculo() { return vehiculo; }
    public double getKilometros() { return kilometros; }

    @Override
    public String toString() {
        return "Viaje{destino='" + destino + "', conductor='" + conductor + "', vehiculo='" + vehiculo +
               "', kilometros=" + kilometros + "}";
    }
}
