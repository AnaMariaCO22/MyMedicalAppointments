import java.util.Scanner;

public class Doctor {
    static int id;//Autoincrement
    String name;
    String speciality;

   Doctor(){

       System.out.println("Construyendo el objeto Doctor");

   }
   Doctor(String name,String specieciality){
        this.name=name;
        this.speciality=specieciality;
       System.out.println("El nombre de doctor asignado es:");
       id++;

   }
    //comportamientos

    public void showName(){

       System.out.println(name);
    }
    public void showId(){
        System.out.println("ID Doctor es: "+id);
    }


}
