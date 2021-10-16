/* SE CREA UN FAMILIAR CON LA CARACTERISTICA QUE ES DE EMERGENCIA
SE PIDEN DATOS EXTRAS AL FAMILIAR 
 */
package proyecto_escuela;
/**
 *
 * @author ARTURO RODRIGUEZ
 */
public class FamiliarEmergencia {
    
    private String domicilio;
    private long telefono;    

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public long getTelefono() {
        return telefono;
    }
}
