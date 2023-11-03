package aplicacion;

import presentacion.Interfaz;

public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String peticion;
        interfaz.procesarPeticion("help");
        do {
            peticion=interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));
    }
}
