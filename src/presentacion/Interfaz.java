package presentacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dominio.*;


public class Interfaz {

private Libreta libreta = new Libreta("Mi libreta");
private Scanner sc = new Scanner(System.in);

    public void anadirContactos(){
        System.out.print("Introduzca el nombre del contacto");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el numero del contacto");
        int numero = sc.nextInt();
        Contacto c = new Contacto(nombre, numero);
        libreta.add(c);

    }

    public void borrar(String nombre){
        libreta.borrar(new Contacto(nombre));
    }


    public boolean procesarPeticion(String peticion){
        String [] p=peticion.split("");
        if (p.length ==1){
            if (p[0].equals("addContacto")){
                anadirContactos();
            }else if(p[0].equals("list")){
                System.out.println(libreta);
            }else if(p[0].equals("help")){
                System.out.println("Introduzca una de las siguientes peticiones: /n Añadir contactos= addContacto /n Mostrar contactos= list /n Borrar: borrar ");
            }else if(p[0].equals("exit")){
                grabar();
                return false;
            }else
                System.out.println("Peticion erronea");
                procesarPeticion("help");
            
        }else
            System.out.println("Peticion erronea");
                procesarPeticion("help");  
        
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
   

}

    
 

 


