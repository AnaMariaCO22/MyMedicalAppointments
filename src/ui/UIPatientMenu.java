package ui;

import model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("welcome: "+UIMenu.patientLogued.getName());
            System.out.println("1.Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response= Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAppontmentManu();
                    break;
                case 2:
                    UIMenu.showMenu();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response!=0);
    }
    private static void showAppontmentManu(){
        int response = 0;
        do {
            System.out.println("::Book an appintment");
            System.out.println("::Select date: ");
            //Primer dato, numeración de la lista de fecha,
            //Indice de la fecha seleccionada
            //doctores
            //1.- doctor1
                // - 1 fecha1
                // - 2 fecha2
            //2.- doctor2
            //3.- doctor3

            Map<Integer,Map<Integer, Doctor>> doctor = new TreeMap<>();
            int k=0;
            for (int i = 0; i < UIDoctorMenu.doctorseAvailablesAppoinments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment>availableAppointments
                        = UIDoctorMenu.doctorseAvailablesAppoinments.get(i).getAA();
                        //Estamos haciendo el array de la clase anidada y temenos que acceder desde la clase exterior porque es static
                //se recorre el doctor que tiene listas disponibles y cuando encuentre uno le pide las fechas disponibles y se asignana en el objeto colección
                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k+"."+availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j),UIDoctorMenu.doctorseAvailablesAppoinments.get(i));
                            //.put es el método para insertar en un Map
                    doctor.put(Integer.valueOf(k),doctorAppointment);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected= Integer.valueOf(sc.nextLine());
            //cuando tenga la fecha saber que doctor mostrarle
            Map<Integer, Doctor> doctorAvailableSelected = doctor.get(responseDateSelected);
            Integer indexDate=0;
            Doctor doctorSelected = new Doctor("","");
            for (Map.Entry<Integer,Doctor> doc:doctorAvailableSelected.entrySet()) {
                indexDate=doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName()+
                    ". Date: "+ doctorSelected.getAA().get(indexDate).getTime() +
                    ". Time: "+ doctorSelected.getAA().get(indexDate).getTime());
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response=Integer.valueOf(sc.nextLine());
            //Sale del ciclo
            if (response==1){
                UIMenu.patientLogued.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAA().get(indexDate).getDate(null),
                        doctorSelected.getAA().get(indexDate).getTime());
                showPatientMenu();

            }
        }while (response!=0);
    }

    private static void showPatientMyAppointments(){
        int response= o;
        do {
            if (UIMenu.patientLogued.getAppointmentDoctors().size()==0){
                System.out.println("Dont have appointments");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogued.getAppointmentDoctors().size(); i++) {
                int j=i+1;
                System.out.println(j+". "+
                        "Date: "+UIMenu.patientLogued.getAppointmentDoctors().get(i).getDate()+
                        "Time: "+ UIMenu.patientLogued.getAppointmentDoctors().get(i).getTime()
                        +"\n Doctor: "+ UIMenu.patientLogued.getAppointmentDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. Return");
        }while (response!=0);
    }
}
