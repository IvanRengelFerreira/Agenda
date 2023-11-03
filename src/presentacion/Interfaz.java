package presentacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthLookAndFeel;

import dominio.Contacto;
import dominio.Libreta;


public class Interfaz {

private Libreta libreta = new Libreta("Mi libreta");
private Scanner sc = new Scanner(System.in);

    public void anadirContactos(){
        System.out.print("Introduzca el nombre del contacto: ");
        String nombre = sc.nextLine();
        sc.nextLine(); 
        System.out.print("Introduzca el numero del contacto: ");
        int numero = sc.nextInt();
        sc.nextLine(); 
        Contacto c = new Contacto(nombre, numero);
        libreta.add(c);
    }


    public void borrar(){
        System.out.println("Intoduce el nombre del contacto que quieras borrar");
        String nombre =sc.nextLine();
        libreta.borrar(new Contacto(nombre));
    }


    public boolean procesarPeticion(String peticion){
      
        String[] p = peticion.trim().split("\\s+");
    
        // Comprobar si al menos se ingresó un comando.
        if (p.length > 0) {
            if (p[0].equalsIgnoreCase("addContacto")) {
                anadirContactos();
            } else if (p[0].equalsIgnoreCase("list")) {
               mostrarContactos();
            } else if (p[0].equalsIgnoreCase("help")) {
                System.out.println("Introduzca una de las siguientes peticiones: \n Anadir contactos = addContacto \n Mostrar contactos = list \n Borrar contactos = borrar ");
            }else if (p[0].equalsIgnoreCase("borrar")){
                borrar();
            } else if (p[0].equalsIgnoreCase("exit")) {
                grabar();
                return false;
            } else {
                System.out.println("Peticion erronea");
                
            }
        } else {
            System.out.println("Peticion erronea");
           
        }
        // Mostrar ayuda si hubo un error en la petición.
        System.out.println("Introduzca 'help' para obtener una lista de comandos validos.");
        return true;
    }
    
    public Interfaz(){
        File f=new File("libreta.txt");
        try {
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(f));
            libreta=(Libreta)obj.readObject();
            obj.close();
        } catch (Exception e) {
            libreta = new Libreta("Mi libreta");
        }
    }


    public void grabar(){
        File f = new File("libreta.txt");
        try{
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(f));
            obj.writeObject(libreta);
            obj.close();
        
        }catch (Exception e){
            System.out.println("Error al grabar");
        }

    }

    public String leerPeticion() {
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }
   
    public void mostrarContactos(){
        libreta.mostrarContactos();
    }

    public void actualizarContacto(){
        borrar();
        System.out.println("Introduce el nombre del contacto: ");
        
    }

}

    
 

 


