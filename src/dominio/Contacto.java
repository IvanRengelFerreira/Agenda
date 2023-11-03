package dominio;

public class Contacto {
    
    private String nombre;
    private int numero;
    
    public Contacto(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }

    public void  setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }
    
   public String toString(){
    return "nombre del contacto: "+nombre+"\t numero del contacto: "+numero;
   }

   public boolean equals (Object o){
    Contacto c = (Contacto)o;
    return nombre.equals(c.nombre);
}

    public Contacto(String nombre){
        this.nombre  = nombre;
    }
}
