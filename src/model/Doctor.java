package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    public Doctor(String name, String email){
        super(name,email);
        this.speciality=speciality;

    }
    //Atributo

    private String speciality;
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public ArrayList<AvailableAppointment> getaA() {
        return aA;
    }

    public void setaA(ArrayList<AvailableAppointment> aA) {
        this.aA = aA;
    }


    //comportamientos

    public void showName(){

       System.out.println(super.getName());
    }
    public void showId(){
        System.out.println("ID model.Doctor es: "+super.getId());
    }

    ArrayList<AvailableAppointment> aA =new ArrayList<>();
   public void addAvailableAppointment(Date date, String time){
           aA.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList<AvailableAppointment> getAA(){
       return aA;
    }

    @Override
    public String toString() {
        return super.toString()+ "Specietity: "+speciality+". Available: "+aA.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital Cruz roja");
        System.out.println("Departamento: Cancerología");
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

        @Override
        public String toString() {
            return "Available Appontments Date: "+date+". Time: "+time;
        }
    }
}
