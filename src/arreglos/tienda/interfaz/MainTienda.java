package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

public class MainTienda {
    private static AppStore tienda = new AppStore();

    static void main(){
        int opcion;
        tienda.inicializarDatos();
        do {
            menu();
            opcion = Validacion.leerInt("Ingrese una opción", 1, 7);
            switch (opcion) {
                case 1:{
                    ingresarJuego();
                }break;

                case 2:{
                    imprimirJuegos();
                }break;

                case 3:{
                    buscarJuego();
                }break;

                case 4:{
                    comprar();
                }break;

                case 5:{
                    vender();
                }break;

                case 6:{
                    String masVendido = tienda.juegoMasVendido();
                    if(masVendido.isEmpty()){
                        System.out.println("No hay juegos registrados");
                    }else{
                        System.out.println("El juego más vendido es: " + masVendido);
                    }
                }break;

                case 7:{
                    System.out.println("Hasta pronto");
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
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        String categoria = Validacion.leerString("Ingrese la categoría, no puede ser nulo ni blanco");
        int tamanio = Validacion.leerIntPositivo("Ingrese el tamanio");
        double precio = Validacion.leerDoublePositivo("Ingrese el precio");
        int licenciasDisponibles = Validacion.leerIntNoNegativo("Ingrese el stock inicial");
        if(tienda.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            System.out.println("Juego ingresado con éxito");
        }else{
            System.out.println("No fue posible ingresar el juego: la tienda está llena");
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

    public static void buscarJuego(){
        String nombre = Validacion.leerString("Ingrese el nombre del juego que desea buscar");
        Juego juego = tienda.buscarJuego(nombre);
        if(juego == null){
            System.out.println("No se encontró el juego " + nombre);
        }else{
            System.out.println(juego);
        }
    }

    public static void comprar(){
        String nombre = Validacion.leerString("Ingrese el nombre del juego al que desea agregar licencias");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad de licencias que desea comprar");
        if(tienda.comprar(nombre,cantidad)){
            System.out.println("Compra registrada. Stock actualizado para " + nombre);
        }else{
            System.out.println("No se pudo comprar: no se encontró el juego " + nombre);
        }
    }

    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        int cantidad = Validacion.leerIntPositivo("Ingrese la cantidad");
        double totalVenta = tienda.vender(nombre,cantidad);
        if(totalVenta == 0){
            System.out.println("No fue posible realizar la venta: revise que el juego exista y tenga stock suficiente");
        }else{
            System.out.println("Venta realizada: " + cantidad + " licencias de " + nombre);
            System.out.println("Total a pagar = " + totalVenta);
        }
    }

}
