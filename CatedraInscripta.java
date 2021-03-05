package proyecto_escuela;
import java.util.*;

/**
 *
 * @author artur
 */
public class CatedraInscripta {

    private String nombre_catedra ;  
    private ArrayList<Double> notas = new ArrayList <>();

    public String getNombre_catedra() {
        return nombre_catedra;
    }

    public void setNombre_atedra(String nombre_catedra) {
        this.nombre_catedra = nombre_catedra;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(Double n) {
       this.notas.add(n);
    }
    
    public double calculaPromedioCatedra(ArrayList<Double> notas){
        double sumatoria=0;        
        for (Double nota : notas) {
            sumatoria+= nota;            
        }        
        double promedio= sumatoria/(notas.size());
        return promedio;
    }

   
}
