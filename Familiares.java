/*SE CREAN FAMILIARES QUE SE CORRESPONDERAN CON UN ALUMNO EN PARTICULAR.
 TIENEN CARACTERISTICAS, Y PUEDE SER EL LLAMADO'FAMILIAR DE EMERGENCIA'
 */
package proyecto_escuela;

/**
 *
 * @author ARTURO RODRIGUEZ
 */
public class Familiares {
    
    private final String nombre;
    private final String parentezco;
    private FamiliarEmergencia familiar;

    public Familiares(String nombre, String parentezco) {
        this.nombre = nombre;
        this.parentezco = parentezco;
    }

    public String getNombre() {
        return nombre;
    }

    public String getParentezco() {
        return parentezco;
    }

    public FamiliarEmergencia getFamiliar() {
        return familiar;
    }
    public void setFamiliarEmergencia(FamiliarEmergencia f) {
        this.familiar = f;
    }
    
    public String determinaSiEsFamiliarEmergencia(){
        if (this.familiar.getDomicilio().isEmpty()) return "No";
        else return "Si";
        
    }
    
}
