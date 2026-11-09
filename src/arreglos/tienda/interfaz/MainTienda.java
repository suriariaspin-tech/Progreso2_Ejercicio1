package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main(){
        int opcion;
        tienda.inicializarDatos();
        do {
            menu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:{
                    ingresarJuego();
                }break;

                case 2:{
                    imprimirJuegos();
                }break;

                case 3:{

                }break;

                case 4:{

                }break;

                case 5:{

                }break;

                case 6:{

                }break;

                case 7:{

                }break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 7);
    }

    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        System.out.print("Ingrese el nombre: ");
        String nombre = leerNombre();
        System.out.print("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if(tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null, "Juego ingresado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "No fue posible ingresar el juego");
        }
    }

    public static void imprimirJuegos(){
        Juego juego[] = tienda.getJuegos();
        for(Juego j : juego){
            if(j != null){
                System.out.println(j);
            }else{
                System.out.println("No hay más juegos a mostrar");
                return;
            }
        }
    }

    public void vender(){

    }

    public static String leerNombre(){
        String nombre;
        do{
            System.out.print("Ingrese el nombre (no puede estar vacío ni ser nulo): ");
            nombre = sc.nextLine();
        }while(nombre == null || nombre.trim().isEmpty());
        return nombre;
    }
}
