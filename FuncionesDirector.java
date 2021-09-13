package proyecto_escuela;

import java.util.InputMismatchException;
import java.util.Scanner;


public class FuncionesDirector {

    protected static String departamentos[] = {"Capital", "Las Heras", "Guaymallen", "Maipu", "Lavalle", "Godoy Cruz", "San Martin"};
    protected static String catedras[] = {"Matematica", "Lengua", "Matematica Financiera", "Teatro", "Programacion", "Derecho"};
    protected static String parentezcos[] = {"Padre", "Madre", "Hermano", "Primo", "Tio", "Abuelo", "Vecino"};

    public static void menuOpcionesDirector() {
        System.out.println("%%%%%   Menú Director   %%%%%");
        System.out.println("Elija una de las siguientes opciones:");
        System.out.println("1-Consultar legajo de alumno en particular");
        System.out.println("2-Consultar cuadrilla integra de todo el alumnado del establecimiento");
        System.out.println("3-Agregar alumnos");
        System.out.println("4-Poner/Quitar amonestaciones a un alumno en particular");
        System.out.println("5-Salir al menu principal");
    }

    public static void usuarioDirector() {
        menuOpcionesDirector();
        String opcion = new Scanner(System.in).nextLine();

        if (opcion.equals("1")) {
            Proyecto_escuela_main.muestraLegajo("D");
        } else if (opcion.equals("2")) {
            Funciones_de_busqueda.mostrarAlumnado(Proyecto_escuela_main.alumnado, "D");
        } else if (opcion.equals("3")) {
            añadeAlumnosAlegajo();
        } else if (opcion.equals("4")) {
            amonestaciones();
        } else if (opcion.equals("5")) {
            Proyecto_escuela_main.bienvenida();
        } else {
            System.out.println("Comando no reconocido. Intente nuevamente");
            usuarioDirector();
        }
    }

    public static Alumno creaAlumnos() {
        String nombre_alumno = Validaciones.validaNombre("Alumno");
        long legajo = Validaciones.validaLegajoAlumno(Proyecto_escuela_main.alumnado);
        long dni = Validaciones.validaDni();
        String domicilio = Validaciones.validaDomicilio(departamentos, "Alumno");
        String sexo = Validaciones.validaSexo();
        int año_nacimiento = Validaciones.validaAñoNacimiento();
        String turno = Validaciones.validaTurno();
        int año_lectivo = Validaciones.validaAñoLctivo();

        Alumno a1 = new Alumno(nombre_alumno, legajo, dni, domicilio, sexo, turno, año_nacimiento, año_lectivo);

        System.out.println("Se ha creado un alumno nuevo.");
        creaFamiliares(a1);
        inscribeAlumnosAcatedras(a1);

        return a1;
    }

    public static void creaFamiliares(Alumno a1) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor ingrese el/los familiares del alumno, e indique cual es el familiar de emergencia.");
        System.out.println("Se puede agregar hasta 4 familiares por alumno y al menos 1 de emergencia");
        int cantidad_familiares = 0;
        int familiar_emergencia = 0;

        while (cantidad_familiares < 4) {
            String nombre = Validaciones.validaNombre("Familiar");
            String parentezco = Validaciones.validaParentezcoFamiliares(parentezcos);
            Familiares familia = new Familiares(nombre, parentezco);
            if (familiar_emergencia == 0) {
                System.out.println("Es familiar de emergencia? pulse 'S' para si o 'N' para no");
                String decision = sc.nextLine();
                if (decision.equalsIgnoreCase("s")) {
                    FamiliarEmergencia fam_emer = new FamiliarEmergencia();
                    String domicilio = Validaciones.validaDomicilio(departamentos, "Familiar");
                    long telefono = Validaciones.validaTelefonoFamiliarEmergencia();

                    fam_emer.setDomicilio(domicilio);
                    fam_emer.setTelefono(telefono);
                    familia.setFamiliarEmergencia(fam_emer);

                    System.out.println("Gracias. Continuemos.");
                    familiar_emergencia = 1;
                }
            }
            if (familiar_emergencia == 0) {
                System.out.println("Todavia no brinda ningun familiar de emergencia. Continuemos con otro familiar");
            } else {
                System.out.println("Quiere agregar otro familiar? Pulse 'S' para si o 'N' para no");
                String continuar = sc.nextLine();
                if (continuar.equalsIgnoreCase("n")) {
                    System.out.println("Hemos terminado de brindar informacion. \n");
                    cantidad_familiares++;
                    a1.añadeFamiliares(familia);
                    break;
                } else {
                    System.out.println("Continuemos con el siguiente familiar..");
                }
            }
            cantidad_familiares++;
            a1.añadeFamiliares(familia);
        }
    }

    public static void inscribeAlumnosAcatedras(Alumno a1) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Se debe inscribir al alumno " + a1.getNombreCompleto().toUpperCase() + " hasta como maximo 3 catedras. \n");

        while (true) {
            int cantidad_catedras = 0;
            System.out.println("Catedra n°" + (cantidad_catedras + 1));
            String catedra = Validaciones.validaAsignacionDeCatedra(catedras, a1);
            CatedraInscripta catedra1 = new CatedraInscripta();
            catedra1.setNombre_atedra(catedra);

            int cantidad_notas = 0;
            System.out.println("Se debe introducir 3 notas de la catedra " + catedra);
            while (cantidad_notas < 3) {
                System.out.println("Nota n°" + (cantidad_notas + 1));
                double nota = Validaciones.validaNota();
                catedra1.setNotas(nota);
                cantidad_notas++;
            }
            a1.añadeCatedras(catedra1);
            cantidad_catedras++;
            if (cantidad_catedras == 3) {
                break;
            }
            System.out.println("Quiere agregar otra catedra al alumno " + a1.getNombreCompleto().toUpperCase() + " ?"
                    + "\n coloque S para 'Salir'");
            String continuar = sc.nextLine();
            if (continuar.equalsIgnoreCase("S")) {
                System.out.println("Hemos terminado de brindar informacion. \n");
                break;
            } else {
                System.out.println("Continuemos con la siguiente catedra...");
            }
        }

    }

    public static void añadeAlumnosAlegajo() {
        Scanner sc = new Scanner(System.in);
        Alumno alumno1 = creaAlumnos();
        Proyecto_escuela_main.alumnado.add(alumno1);
        System.out.println("Quiere agregar mas alumnos? Pulse 'S' para salir al menu de opciones de usario");
        String continuar = sc.next();
        if (continuar.equalsIgnoreCase("S")) {
            System.out.println("Alumnos creados satisfactoriamente. \n");
            usuarioDirector();
        } else {
            System.out.println("Continuemos con el siguiente alumno a inscribir.");
            añadeAlumnosAlegajo();
        }
    }

    public static void amonestaciones() {
        if (Validaciones.validaCartillaDeAlumnosVacia(Proyecto_escuela_main.alumnado)) {
            System.out.println("Para hacer uso de esta opcion, se debe ingresar un alumno primero.\n");
            usuarioDirector();
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu amonestaciones:\n");
            System.out.println("Quiere continuar o volver al menu 'Director'?"
                    + " Pulse 's' para cotinuar en el menu amonestaciones");
            String decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("s")) {
                usuarioDirector();
            } else {
                System.out.println("Indique el legajo del alumno: ");
                long legajo = 0;
                boolean bandera = true;
                while (bandera) {
                    try {
                        legajo = sc.nextLong();
                        for (Alumno a1 : Proyecto_escuela_main.alumnado) {
                            if (legajo == a1.getLegajo()) {
                                a1.getAmonestciones();
                                if (a1.muestraElNumeroDeAmonestaionces() == 0) {
                                    System.out.println("Quiere agregar una amonestacion al alumno " + a1.getNombreCompleto() + "?\nPulse 'S' para SI");
                                    String decision3 = new Scanner(System.in).nextLine();
                                    if (decision3.equalsIgnoreCase("s")) {
                                        System.out.println("Se ha agregado una amonestacion al alumno " + a1.getNombreCompleto());
                                        a1.agregaAmonestaciones();
                                        bandera = false;
                                    } else {
                                        System.out.println("Comando no reconocido. Ingrese nuevamente un legajo de alumno.");
                                    }
                                } else {
                                    System.out.println("Quiere agregar o quitar una amonestacion al alumno " + a1.getNombreCompleto() + "?\nPulse 'A' para agregar o 'Q' para quitar");
                                    String decision2 = new Scanner(System.in).nextLine();
                                    if (decision2.equalsIgnoreCase("a")) {
                                        System.out.println("Se ha agregado una amonestacion al alumno " + a1.getNombreCompleto());
                                        a1.agregaAmonestaciones();
                                        bandera = false;
                                    } else if (decision2.equalsIgnoreCase("q")) {
                                        System.out.println("Se ha eliminado una amonestacion al alumno " + a1.getNombreCompleto());
                                        a1.quitaAmonestaciones();
                                        bandera = false;
                                    } else {
                                        System.out.println("Comando no reconocido. Ingrese nuevamente un legajo de alumno.");
                                    }
                                }
                            } else {
                                System.out.println("Error. Legajo inexistente. Intente nuevamente.");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error. Ingrese un numero valido");
                        sc.next();
                    }
                }
                usuarioDirector();
            }
        }
    }
}
