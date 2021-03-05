/*
 * ARCHIVO DONDE SE ENCUENTRAN TODAS LAS VALIDACIONES NECESARIAS PARA REALIZAR LAS
ENTRADAS DE DATOS POR PARTE DEL DIRECTOR.
 */
package proyecto_escuela;

import java.util.*;

/**
 *
 * @author User
 */
public class Validaciones {

    public static String validaNombre(String nombre) {
        Scanner sc = new Scanner(System.in);
        String primer_nombre = "";
        String segundo_nombre = "";
        String primer_apellido = "";
        String segundo_apellido = "";
        String nombre_completo = "";
        System.out.println("Introduzca el primer nombre del " + nombre + ": ");
        //valido que primer nombre y primer apellido no esten vacios
        while (true) {
            primer_nombre = sc.nextLine();
            if (primer_nombre.length() != 0) {
                break;
            } else {
                System.out.println("El nombre del " + nombre + " no puede estar vacio. Coloquelo nuevamente");
            }
        }

        System.out.println("Introduzca el segundo nombre del " + nombre + ". Si no lo tiene, simplemente precione 'Enter' ");
        segundo_nombre = sc.nextLine();
        System.out.println("Introduzca el primer apellido del " + nombre + ": ");
        while (true) {
            primer_apellido = sc.nextLine();
            if (primer_apellido.length() != 0) {
                break;
            } else {
                System.out.println("El apellido del " + nombre + " no puede estar vacio. Coloquelo nuevamente");
            }
        }
        System.out.println("Introduzca el segundo apellido del " + nombre + ". Si no lo tiene, simplemente precione 'Enter' ");
        segundo_apellido = sc.nextLine();
        nombre_completo = primer_nombre + " " + segundo_nombre + " " + primer_apellido + " " + segundo_apellido + " ";
        return nombre_completo.toUpperCase();
    }

    public static long validaDni() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI del alumno: ");
        long dni = 0;
        //valido que se ingrese un numero, y que ese numero sea de 8 caracteres
        while (true) {
            try {
                dni = sc.nextLong();
                String documento = String.valueOf(dni);
                if (documento.length() != 8) {
                    System.out.println("El DNI del alumno no puede tener menos de 8 caracteres. Intente nuevamente");
                } else {
                    return dni;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }

    }

    public static int validaAñoNacimiento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el año de nacimiento del alumno: ");
        int año = 0;
        Date fecha_actual = new Date();
        //valido que el año sea un numero, que tenga 4 caracteres, y que no sea mayor al año actual
        while (true) {
            try {
                año = sc.nextInt();
                String documento = String.valueOf(año);
                if (documento.length() != 4 || año > (fecha_actual.getYear() + 1900)) {
                    System.out.println("El año no puede tener menos de 4 caracteres, ni ser mayor al año actual. Intente nuevamente");
                } else {
                    return año;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }

    }

    public static String validaDomicilio(String departamentos[], String individuo) {
        Scanner sc = new Scanner(System.in);
        String depa = "";
        String calle = "";
        int numercion = 0;
        String domicilio_completo = "";

        boolean bandera = false;
        System.out.println("Introduzca el departamento donde vive actualmente el " + individuo + ": ");
        //valido que el departamento sea uno de los posibles existentes
        while (!bandera) {
            depa = sc.nextLine();
            for (String d : departamentos) {
                if (d.equalsIgnoreCase(depa)) {
                    bandera = true;
                    break;
                }
            }
          
            if (!bandera) {
                System.out.println("El departamento no coincide con los departamentos posibles. Coloquelo nuevamente");
                System.out.println("Recuerde que los departamentos posibles son los siguientes:");
                System.out.println("|-----------------------|");
                for (String depas : departamentos) {
                    System.out.print("{" + depas + "}");
                }
                System.out.println("|-----------------------|");
            }
        }
        System.out.println("Introduzca la calle del domicilio:");
        while (true) {
            calle = sc.nextLine();
            if (calle.length() != 0) {
                break;
            } else {
                System.out.println("El nombre de la calle no puede estar vacio. Coloquelo nuevamente");
            }
        }
        System.out.println("Introduzca la numeracion de la calle " + calle);
        while (true) {
            try {
                numercion = sc.nextInt();
                String documento = String.valueOf(numercion);
                if (documento.length() > 4) {
                    System.out.println("La numeracion no puede tener mas de 4 digitos. Intente nuevamente");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }

        domicilio_completo = "Departamento: " + depa + " Calle: " + calle + "Numeracion: " + String.valueOf(numercion);
        return domicilio_completo;
    }

    public static int validaAñoLctivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el año lectivo del alumno: ");
        int año = 0;
        while (true) {
            try {
                año = sc.nextInt();
                if (año < 1 || año > 5) {
                    System.out.println("Los ciclos lectivos existentes en esta institucion van de 1er a 5to año. Intente nuevamente");
                } else {
                    return año;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }
    }

    public static String validaSexo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese sexo del alumno. Pulse 'M' para masculino, 'F' para femenino y 'I' para otra identidad de genero percibida");
        String genero = sc.nextLine();

        if (genero.equalsIgnoreCase("m") || genero.equalsIgnoreCase("i") || genero.equalsIgnoreCase("f")) {
            return genero.toUpperCase();
        } else {
            System.out.println("Cacaracter no reconocido. Intente nuevamente.");
            return validaSexo();
        }
    }

    public static String validaTurno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese turno al que asiste el alumno. Pulse 'M' para mañana o 'T' para tarde");
        String turno = sc.nextLine();

        if (turno.equalsIgnoreCase("t") || turno.equalsIgnoreCase("m")) {
            return turno.toUpperCase();
        } else {
            System.out.println("Cacaracter no reconocido. Intente nuevamente.");
            return validaTurno();
        }
    }

    public static String validaParentezcoFamiliares(String parentezco[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el parentezco del familiar del alumno");
        String pariente = sc.nextLine();
        //valido que el parentezco sea uno de los posibles. Similar a la validacion de departamentos
        for (String p : parentezco) {
            if (pariente.equalsIgnoreCase(p)) {
                return pariente;
            }
        }
        System.out.println("Pariente no reconocido. Recuerde que los parientes posible son los siguientes:");
        System.out.println("|-----------------------|");
        for (String parentezco1 : parentezco) {
            System.out.print("{" + parentezco1 + "}");
        }
        System.out.println("|-----------------------|");
        return validaParentezcoFamiliares(parentezco);
    }

    public static long validaTelefonoFamiliarEmergencia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el telefono del familiar de emergencia.");
        long telefono;
        while (true) {
            try {
                telefono = sc.nextLong();
                return telefono;
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }
    }

    public static double validaNota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la nota del alumno: ");
        double nota = 0;
        while (true) {
            try {
                nota = sc.nextDouble();
                if (nota < 1 || nota > 10) {
                    System.out.println("La nota no puede ser menor a 1 ni mayor a 10. Intente nuevamente");
                    return validaNota();
                } else {
                    return nota;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Ingrese un numero valido");
                sc.next();
            }
        }

    }

    public static String validaAsignacionDeCatedra(String[] catedras, Alumno alumno) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre de la catedra: ");
        String cate = sc.nextLine();
        for (CatedraInscripta al : alumno.getCatedras()) {
            //valido que si la catedra ya se ingresó , no se vuelva a ingresar
            if (cate.equalsIgnoreCase(al.getNombre_catedra())) {
                System.out.println("Error. Catedra Ya asignada a este alumno. Intente nuevamente");
                return validaAsignacionDeCatedra(catedras, alumno);
            }
        }
        for (int i = 0; i < catedras.length; i++) {
            if (cate.equalsIgnoreCase(catedras[i])) {
                return cate;
            }
        }
        //valido que la catedra sea una de las posibles. similar a domicilio y catedra
        System.out.println("Catedra no reconocida. Recuerde que las catedras posibles son los siguientes: ");
        System.out.println("|-----------------------|");
        for (String catedras1 : catedras) {
            System.out.print("{" + catedras1 + "}");
        }
        System.out.println("|-----------------------|");
        return validaAsignacionDeCatedra(catedras, alumno);
    }

    public static long validaLegajoAlumno(ArrayList<Alumno> alumnado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el legajo del alumno:");
        long legajo = 0;
        boolean bandera = true;
        //si no se ha agregado ningun alumno valido que simplemente sea un numero de 7 caracteres
        if (alumnado.isEmpty()) {
            while (bandera) {
                try {
                    legajo = sc.nextLong();
                    String legajo2 = String.valueOf(legajo);
                    if (legajo2.length() == 7) {
                        bandera = false;
                    } else {
                        System.out.println("El legajo debe tener 7 caracteres. Intente nuevamente");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un numero de legajo valido valido por favor.");
                    sc.next();
                }
            }
            //si ya hay otro alumno, verifico que el legajo no se haya creado antes
        } else {
            while (bandera) {
                try {
                    legajo = sc.nextLong();
                    String legajo2 = String.valueOf(legajo);
                    if (legajo2.length() == 7) {
                        for (Alumno a1 : alumnado) {
                            if (legajo == a1.getLegajo()) {
                                System.out.println("Error. Legajo ya creado. Intente nuevamente.");
                            } else {
                                bandera = false;
                            }
                        }
                    } else {
                        System.out.println("El legajo debe tener 7 caracteres. Intente nuevamente");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un numero de legajo valido valido por favor.");
                    sc.next();
                }
            }
        }
        return legajo;
    }

    public static boolean validaCartillaDeAlumnosVacia(ArrayList<Alumno> alumnado) {
        boolean bandera = true;
        //verifico si mi lista está vacia. necesario para algunas funcionalidades
        if (alumnado.isEmpty()) {
            return bandera;
        } else {
            bandera = false;
            return bandera;
        }
    }

}
