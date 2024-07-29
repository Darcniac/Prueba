/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2_entrenamiento_vehiculo;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author josel
 */
public class Vehiculo {

    // ATRIBUTOS
    private String matricula;
    private Set<Colores> setColores;
    private List<LocalDate> listaFechas = new ArrayList<>();
    private int contador;

    // constantes
    private final int MAX_COLORES = 3;
    private final int MIN_COLORES = 1;
    


    // CONSTRUCTOR
    // Con los puntos suspensivos (Colores... ) estamos usando Varargs para que se puedan meter uno o muchos colores
    public Vehiculo(String matricula, Colores... colores) throws IllegalArgumentException {  // Aquí estamos pidiendo como parámetro un tipo Enum "Colores" no un tipo Set<Colores>
        if (colores.length < MIN_COLORES || colores.length > MAX_COLORES) {
            System.out.println("error! has introducido menos de 1 color o más de 3");
        }
        this.matricula = matricula;
        this.setColores = new HashSet<>(); // Instanciamos nuestro Set y decimos que es un HasSet
        for (Colores c : colores) {      // hacemos un bucle foreach para ir añadiendo todos los colores que se han metido como parámetro ya que no sabemos la cantidad
            this.setColores.add(c);        
        }
        
    }
// método añadir color
    public boolean addColor(Colores nuevoColor) throws IllegalArgumentException{
        
        boolean resultado;
        if (this.setColores.size()>=MAX_COLORES || this.setColores.contains(nuevoColor)) { // Si el tamaño del Set ya es de 3 o ya está ese color, no dejamos que se añadan más
            resultado= false;
            throw new IllegalArgumentException("error!!! ya hay 3 colores");       
        }
        this.setColores.add(nuevoColor);
        resultado = true;
       return resultado;
    }
    
// método quitar color
    public boolean quitarColor(Colores colorAborrar) throws IllegalArgumentException{
        
        boolean resultado = false;
        if (this.setColores.size()<= MIN_COLORES) {
            throw new IllegalArgumentException("error! ssolo queda un color y no puedes dejar el objeto sin ningún color");
        } else if (this.setColores.contains(colorAborrar)) {
            this.setColores.remove(colorAborrar);
            resultado = true;
        }

       return resultado;
    }
 
// método contiene color
    public boolean contieneColor(Colores color) throws IllegalArgumentException{
        boolean resultado;
        if (this.setColores.contains(color)) {
            resultado = true;
        }else{
            resultado = false;
        }

       return resultado;
    }
    
// método utilizar
    public int utilizar() {
        LocalDate fechaActual =  LocalDate.now();
        listaFechas.add(fechaActual);
        contador++;
        return contador;
    }

 // método vecesUtilizado
    public int vecesUtilizado(){ // esto lo podemos ahcer de varias formas con un contador, devolviendo el número de fechas dentro de la lista o llamando al método que ya devuelve el contador
       // return contador; 
       
     // return listaFechas.size();
     
     //  int resultado = this.utilizar();
       
        return contador;
    }
    
    // metodo vecesUtitlizadoAntesDe
    public int vecesUtitlizadoAntesDe(LocalDate fecha){
        int c = 0;
            for (LocalDate fechas : listaFechas) {
                if (fechas.isBefore(fecha)) {
                    c++;
                }
        }
        
        return c;
    }
    
    // metodo ultimoUso
    public LocalDate ultimoUso(){
            LocalDate resultado;
            
        if (listaFechas.isEmpty()) {
            resultado = null;
        }
        resultado = listaFechas.get(listaFechas.size()-1);
        return resultado;
    }
    
    
    
    
    
    
    
    // MÉTODO TOsTRING
    @Override
    public String toString(){
        return String.format("Matricula: %s\n Colores: %s\n Usos: %d\n fecha de usos: %s", this.matricula, this.setColores.toString(), this.vecesUtilizado(), this.listaFechas);
    }
    

}// fin clase vehiculo

