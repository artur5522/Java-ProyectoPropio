/*
 * EN ESTE PROYECTO SE INTENTA SIMULAR, POR CONSOLA DE IDE "NETBEENS", UN PROGRAMA DE UNA ESCUELA.
    PROVEYENDO DE DISTINTAS FUNCIONALIDADES TANTO SI SE ES AUXILIAR, COMO SI SE ES EL DIRECTOR
AUXILIARES:
    -USUARIO: auxuliar10  a/
    -CONTRASEÑA: 2255
DIRECTOR:
    -USUARIO: director01   d/
    -CONTRASEÑA: 8877
 */
package proyecto_escuela;

import java.util.*;

/**
 * @author ARTURO FERNANDO RODRIGUEZ
 */
public class Proyecto_escuela_main {

    protected static final ArrayList<Alumno> alumnado = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Buenos dias. Programa iniciando..\n");
        bienvenida();
    }

    public static void bienvenida() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Menú Principal--------------");
        System.out.println("Quiere entrar como un usuario? Pulse 'S'."
                + "\nQuiere apagar el programa pulse 'A'");
        
        String deciscion = new Scanner(System.in).nextLine();
        if (deciscion.equalsIgnoreCase("S")) {
            System.out.println("Introduzca usuario:");
            String usuario = new Scanner(System.in).nextLine();
            System.out.println("\n");
            System.out.println("Introduzca contraseña:");
            String contraseña = new Scanner(System.in).nextLine();
            System.out.println("\n");
            if (usuario.equalsIgnoreCase("a") && contraseña.equals("2255")) {
                usuarioAuxiliar();
            } else if (usuario.equalsIgnoreCase("d") && contraseña.equals("8877")) {
                FuncionesDirector.usuarioDirector();
            } else {
                System.out.println("Uusuario o contraseña incorrectos. Intente nuevamente.");
                bienvenida();
            }
        } else if (deciscion.equalsIgnoreCase("A")) {
            apagar();
        } else {
            System.out.println("Comando no reconocido. Intente nuevamente");
            bienvenida();
        }
    }

    public static void apagar() {
        System.out.println("Apagando programa..");
        System.out.println("Que tenga un buen dia.");
    }

    public static void usuarioAuxiliar() {
        //Scanner sc = new Scanner(System.in);
        System.out.println("%%%%%   Menú Auxiliar   %%%%%");
        System.out.println("Desea consultar algun legajo en especial, o todo el alumnado?"
                + "\nPrecione '1' para ver un alumno en particular,"
                + "'2' para ver la cuadrilla integra de todo el alumnado del establecimiento o '3' para salir al menu principal");
        String opcion = new Scanner(System.in).nextLine();
        if (opcion.equals("1")) {
            muestraLegajo("A");
        } else if (opcion.equals("2")) {
            Funciones_de_busqueda.mostrarAlumnado(alumnado, "A");
        } else if (opcion.equals("3")) {
            bienvenida();
        } else {
            System.out.println("Comnado invalido. Intente nuevamente");
            usuarioAuxiliar();
        }
    }

    public static void muestraLegajo(String usario) {
        if (Validaciones.validaCartillaDeAlumnosVacia(alumnado)) {
            System.out.println("Para hacer uso de cualquier opcion de busqueda, se debe ingresar un alumno primero.\n");
            if (usario.equals("D")) {
                FuncionesDirector.usuarioDirector();
            } else {
                bienvenida();
            }
        } else {
            //Scanner sc = new Scanner(System.in);
            System.out.println("Indique el legajo del alumno que quiere consultar: ");
            long legajo = 0;
            while (true) {
                try {
                    legajo = new Scanner(System.in).nextLong();
                    for (Alumno a1 : alumnado) {
                        if (legajo == a1.getLegajo()) {
                            Funciones_de_busqueda.mostrarAlumno(alumnado, legajo, usario);
                        } else {
                            System.out.println("Error. Legajo inexistente. Intente nuevamente.");
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error. Ingrese un numero valido");
                    new Scanner(System.in).next();
                }
            }
        }
    }

}
