package dominio;
import java.util.*;
import java.io.Serializable;



public class Libreta implements Serializable {
    
    private String nombre;
    private ArrayList<Contactos> contactos;

    public Libreta(String nombre){
        this.nombre = nombre;
        contactos = new ArrayList<Contactos>();
    }

    public Libreta add(Contactos contacto){
        contactos.add(contacto);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Contactos getContactos( int i){
        return contactos.get(i);
    }

}
