import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Doctor {
    static int id;//Autoincrement
    private String name;
    private String speciality;


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

    ArrayList<AvailableAppointment> aA =new ArrayList<>();
   public void addAvailableAppointment(Date date, String time){
           aA.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment> getAA(){
       return aA;
    }
    public static class AvailableAppointment{
       private int id;
       private Date date;
       private String time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public AvailableAppointment(Date date, String time){
           this.date=date;
           this.time=time;
       }
    }
}
