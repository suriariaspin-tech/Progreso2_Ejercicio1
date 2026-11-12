package arreglos.tienda.interfaz;

import java.util.Scanner;

public class Validacion {
    private static final Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String nombre;
        do{
            System.out.print(mensaje + " : ");
            nombre = sc.nextLine();
        }while(nombre == null || nombre.trim().isEmpty());
        return nombre;
    }

    public static int leerInt(String mensaje, int minimo, int maximo){
        while(true){
            System.out.print(mensaje + " : ");
            int valor = Integer.parseInt(sc.nextLine().trim());
            if(valor >= minimo && valor <= maximo){
                return valor;
            }
            System.out.println("Ingrese un n{umero entero entre " + minimo + " y " + maximo + ".");
        }
    }

    public static int leerIntPositivo(String mensaje){
        return leerInt(mensaje, 1, Integer.MAX_VALUE);
    }

    public static int leerIntNoNegativo(String mensaje){
        return leerInt(mensaje, 0, Integer.MAX_VALUE);
    }

    public static double leerDouble(String mensaje){
        while(true){
            System.out.print(mensaje + " : ");
            double valor = Double.parseDouble(sc.nextLine().trim());
            if(Double.isFinite(valor)){
                return valor;
            }
            System.out.println("Ingrese un número decimal finito.");
        }
    }

    public static double leerDoublePositivo(String mensaje){
        while(true){
            double valor = leerDouble(mensaje);
            if(valor > 0){
                return valor;
            }
            System.out.println("Ingrese un número decimal mayor que cero.");
        }
    }
}
