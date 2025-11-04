// Clase que representa a un conductor
// Definimos el la clase de manera publica para que otros archivos puedan acceder a ella
public class Conductor {
    // Definimos los atributos de este "molde" que nos permitirá crear objetos de tipo Conductor. En este caso cada conductor debe tener asociado un nombre y un número de licencia
    private String nombre;
    private Integer licencia;

    public Conductor(String nombre, Integer licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    // Métodos get y set que me permitirán leer y modificar los atributos de un conductor
    public String getNombre() { return nombre; }
    public Integer getLicencia() { return licencia; }

    public void setLicencia(Integer licencia) { this.licencia = licencia; }

    @Override
    public String toString() {
        return "Conductor{Nombre conductor='" + nombre + "', No. licencia='" + licencia + "'}";
    }
}
