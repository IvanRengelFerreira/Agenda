package dominio;
import java.util.*;
import java.io.Serializable;


public class Libreta implements Serializable {
    
    private String nombre;
    private ArrayList<Contacto> contactos;

    public Libreta(String nombre){
        this.nombre = nombre;
        contactos = new ArrayList<Contacto>();
    }

    public Libreta add(Contacto c){
        contactos.add(c);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Contacto getContactos( int i){
        return contactos.get(i);
    }

    public Libreta borrar(Contacto c){
        contactos.remove(c);
        return this;
    }

    public void mostrarContactos() {
        for(Contacto c : contactos){
            System.out.println(c);
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; 
    }

    /**
     * @param nombreViejo
     * @param contactoActualizado
     */
    public void actualizarContacto(String nombreViejo, Contacto contactoActualizado) {
        Contacto contactoAActualizar = buscarContacto(nombreViejo);
        if (contactoAActualizar != null) {
            contactos.remove(contactoAActualizar); 
            contactos.add(contactoActualizado); 
        }
    }

}
