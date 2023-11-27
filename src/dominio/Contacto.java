package dominio;

import java.io.Serializable;

public class Contacto implements Serializable{
    
    /**
     *Nombre del contacto
     */
    private String nombre;
    /**
     *numero del contacto
     */
    private int numero;


    
    /**
     * Se crean los atributos que se usan de parametros en el constructor
     * @param nombre
     * @param numero
     */
    public Contacto(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * Parametro para el metodo set de la 
     * @param nombre
     */
    public void  setNombre(String nombre){
        this.nombre = nombre;
    }

   /**
    * Es el metodo get para obtener el valor del atributo 
     * @return
     */
     public String getNombre() {
        return nombre;
    }

    /**
     * Parametro para darle valor al atributo numero
     * @param numero
     */
    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Metodo get para obtener el valor que obtuvimos en el s
     * @return
     */
    public int getNumero(){
        return numero;
    }

   public String toString(){
    return "nombre del contacto: "+nombre+"\t numero del contacto: "+numero;
   }
   /**
     * Metodo toString
     * @override
     */

   public boolean equals (Object o){
    Contacto c = (Contacto)o;
    return nombre.equals(c.nombre);
}

    /**
     * Crear un cconstructor con un parametro
     * @param nombre
     */
    public Contacto(String nombre){
        this.nombre  = nombre;
    }
}
