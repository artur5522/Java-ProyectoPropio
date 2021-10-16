/*EN ESTA CLASE SE CREAN ALUMNOS, QUE TENDRAN:
-INFORMACION NECESARIA PARA LA INSCRIPCION DE UN ALUMNO EN UN ESTABLECIMIENTO
-DIFEERENTES CATEDRAS (CON SUS RESPECTIVAS NOTAS)
-FAMILIARES, CON SUS RESPECTIVOS DATOS (SE INCLUYE 1 FAMILIAR DE EMERGENCIA OBLIGATORIO)    
 */
package proyecto_escuela;

import java.util.*;

/**
 *
 * @author ARTURO RODRIGUEZ
 */
public class Alumno {
    
    private String NombreCompleto;
    private long legajo;
    private long dni;
    private String sexo;
    private String domicilio;
    private String turno;
    private int añoLectivo;
    private int amonestciones=0;
    private int año_nacimiento;
    private final ArrayList<Familiares> familia = new ArrayList<> ();   
    private final ArrayList<CatedraInscripta> catedras = new ArrayList<> ();

    public Alumno(String NombreCompleto, long legajo, long dni, String domicilio, String sexo, String turno,int año_nacimiento, int añoLectivo) {
        this.NombreCompleto = NombreCompleto;
        this.legajo = legajo;
        this.dni = dni;
        this.sexo = sexo;
        this.turno = turno;     
        this.año_nacimiento = año_nacimiento;
        this.añoLectivo = añoLectivo;
        this.domicilio= domicilio;
    }
    
    public long getDni() {
        return dni;
    }
    public String getDomicilio() {
        return domicilio;
    }

    public String getSexo() {
        return sexo;
    }
    
    public int getAñoLectivo() {
        return añoLectivo;
    }

    public String getTurno() {
        return turno;
    }

    public void getAmonestciones() {
        System.out.print("Amonestaciones a la fecha: " + this.amonestciones+"\n");      
    }
    
    public int muestraElNumeroDeAmonestaionces(){
        return amonestciones;
    }

    public int getAño_nacimiento() {
        return año_nacimiento;
    }

    public ArrayList<Familiares> getFamilia() {
        return familia;
    }
    
    public ArrayList<CatedraInscripta> getCatedras() {
        return catedras;
    }


    public String getNombreCompleto() {
        return NombreCompleto;
    }


    public long getLegajo() {
        return legajo;
    }

    public void añadeFamiliares (Familiares fam){        
       familia.add(fam);        
    }    
    
    public void añadeCatedras (CatedraInscripta cat){        
       catedras.add(cat);
    }
    
    public void agregaAmonestaciones(){
        this.amonestciones++;
    }
    
    public void quitaAmonestaciones(){
        this.amonestciones--;
    }
   
    
}
