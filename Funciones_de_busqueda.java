
package proyecto_escuela;

import java.util.ArrayList;
import static proyecto_escuela.Proyecto_escuela_main.alumnado;

/**
 *
 * @author ARTURO RODRIGUEZ
 */
public class Funciones_de_busqueda {

    public static void mostrarAlumnado(ArrayList<Alumno> list, String usuario) {
        if (Validaciones.validaCartillaDeAlumnosVacia(alumnado)) {
            System.out.println("Para hacer uso de cualquier opcion de busqueda,"
                    + " se debe ingresar un alumno primero.\n");
            if (usuario.equals("D")) {
                FuncionesDirector.usuarioDirector();
            } else {
                Proyecto_escuela_main.bienvenida();
            }
        } else {
            System.out.println("--------------------------------------------------------");
            System.out.println("Se muestra informacion del alumnado: \n");

            for (Alumno a : list) {
                System.out.println("Nombre completo: " + a.getNombreCompleto());
                System.out.println("DNI: " + a.getDni());
                System.out.println("Año nacimiento: " + a.getAño_nacimiento());
                System.out.println("Domicilio: " + a.getDomicilio());
                System.out.println("Sexo: " + a.getSexo());
                System.out.println("Turno: " + a.getTurno());
                System.out.println("Año lectivo donde se encuentra actualmente: " + a.getAñoLectivo());
                System.out.println("Amonestaciones a la fecha: " + a.muestraElNumeroDeAmonestaionces());

                System.out.println("---------------Familiares del alumno:----------------");
                for (int i = 0; i < a.getFamilia().size(); i++) {
                    System.out.println("Nombre: " + a.getFamilia().get(i).getNombre());
                    System.out.println("Parentezco: " + a.getFamilia().get(i).getParentezco());
                    System.out.println("Es familiar de emergencia? : " + a.getFamilia().get(i).determinaSiEsFamiliarEmergencia());
                    if (a.getFamilia().get(i).determinaSiEsFamiliarEmergencia().equalsIgnoreCase("Si")) {
                        System.out.println("Telefono: " + a.getFamilia().get(i).getFamiliar().getTelefono());
                        System.out.println("Domicilio: " + a.getFamilia().get(i).getFamiliar().getDomicilio());
                    }
                    System.out.println("-----     ------     -----     -------     ------");
                }

                System.out.println("---------------Catedras y Notas:----------------------");
                for (CatedraInscripta c : a.getCatedras()) {
                    System.out.println("Nombre: " + c.getNombre_catedra() + "\nNotas:");
                    System.out.printf("%s ", c.getNotas());
                    System.out.println("\nEl promedio de notas de la catedra " + c.getNombre_catedra() + " es: " + c.calculaPromedioCatedra(c.getNotas()));
                    System.out.println("-----     ------     -----     -------     ------");
                }
                System.out.println("--------------------------------------------------------");
            }
            if (usuario.equals("D")) {
                System.out.println("\n");
                FuncionesDirector.usuarioDirector();
            } else {
                System.out.println("\n");
                Proyecto_escuela_main.usuarioAuxiliar();
            }
        }
    }

    public static void mostrarAlumno(ArrayList<Alumno> list, long legajo, String usuario) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Se muestra informacion: \n");
        for (Alumno a : list) {
            if (a.getLegajo() == legajo) {
                System.out.println("Nombre completo: " + a.getNombreCompleto());
                System.out.println("DNI: " + a.getDni());
                System.out.println("Año nacimiento: " + a.getAño_nacimiento());
                System.out.println("Domicilio: " + a.getDomicilio());
                System.out.println("Sexo: " + a.getSexo());
                System.out.println("Turno: " + a.getTurno());
                System.out.println("Año lectivo donde se encuentra actualmente: " + a.getAñoLectivo());
                System.out.println("Amonestaciones a la fecha: " + a.muestraElNumeroDeAmonestaionces());

                System.out.println("---------------Familiares del alumno:----------------");
                for (Familiares f : a.getFamilia()) {
                    System.out.println("Nombre: " + f.getNombre());
                    System.out.println("Parentezco: " + f.getParentezco());
                    String familiar_emergencia = f.determinaSiEsFamiliarEmergencia();
                    System.out.println("Es familiar de emergencia? : " + familiar_emergencia);
                    if (f.determinaSiEsFamiliarEmergencia().equalsIgnoreCase("Si")) {
                        System.out.println("Telefono: " + f.getFamiliar().getTelefono());
                        System.out.println("Domicilio: " + f.getFamiliar().getDomicilio());
                    }
                    System.out.println("-----     ------     -----     -------     ------");
                }

                System.out.println("---------------Catedras y Notas:----------------------");
                for (CatedraInscripta c : a.getCatedras()) {
                    System.out.println("Nombre: " + c.getNombre_catedra() + "\nNotas");
                    System.out.printf("%s ", c.getNotas());
                    System.out.println("\nEl promedio de notas de la catedra " + c.getNombre_catedra() + " es: " + c.calculaPromedioCatedra(c.getNotas()));
                    System.out.println("-----     ------     -----     -------     ------");
                }
                System.out.println("--------------------------------------------------------");
            }
        }
        if (usuario.equals("D")) {
            FuncionesDirector.usuarioDirector();
        } else {
            Proyecto_escuela_main.usuarioAuxiliar();
        }
    }
}
