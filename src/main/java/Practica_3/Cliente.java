package Practica_3;

public class Cliente {
    private int numero;
    private int edad;
    private String nombre;
    private int puntos;    

    public Cliente(int numero, int edad, String nombre, int puntos) {
        this.numero = numero;
        this.edad = edad;
        this.nombre = nombre;
        this.puntos = puntos;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    
    
    
    
}
