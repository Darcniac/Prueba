package ejercicio_2_entrenamiento_vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author josel
 */
public class Ejercicio_2_entrenamiento_Vehiculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Formatear la fecha como una cadena
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Vehiculo v = null;
        Vehiculo v2 = null;

        System.out.println("Forzamos error con más de 3 colores");
        try {
            v = new Vehiculo("435435", Colores.AMARILLO, Colores.AZUL, Colores.BLANCO, Colores.VERDE);

            System.out.println(v.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("Forzamos el error de no tener colores");

        try {
            v = new Vehiculo("435435");

            System.out.println(v.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("");
        System.out.println("creamos el objeto vehiculo bien");
        try {
            v = new Vehiculo("435435", Colores.AMARILLO, Colores.AZUL, Colores.BLANCO);

            System.out.println(v.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Creamos vehiculo 2");
        try {
            v2 = new Vehiculo("pollas", Colores.AMARILLO, Colores.AZUL);

            System.out.println(v2.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Añadimos un nuevo color verde al vehiculo 2");

        v2.addColor(Colores.VERDE);
        // Agregar un nuevo color
        System.out.println(v2.toString()); // Imprimirá los colores actualizados después de agregar el nuevo color

        System.out.println("");

        System.out.println("Quitamos el color verde ");
        v2.quitarColor(Colores.VERDE);
        System.out.println(v2.toString());

        System.out.println("Comprobamos si un coche tiene un color");
        System.out.println("Contiene el color rojo?");
        System.out.println(v2.contieneColor(Colores.ROJO));
        System.out.println("Contiene el color azul?");
        System.out.println(v2.contieneColor(Colores.AZUL));

        System.out.println("Ahora vamos a utilizar el coche 4 veces y lo mostramos");

        v2.utilizar();
        v2.utilizar();
        v2.utilizar();
        v2.utilizar();
        System.out.println(v2.toString());

        System.out.println("");
        System.out.println("Ahora vamos a ver cuando fue el último uso");
        System.out.println(v2.ultimoUso().format(formato));

        System.out.println("");
        System.out.println("veces utilizado antes de  hoy");
        System.out.println(v2.vecesUtitlizadoAntesDe(LocalDate.now()));
        

        
        
        
        
        
        
    }// fin main

}
