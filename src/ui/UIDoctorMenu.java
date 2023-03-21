package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorseAvailablesAppoinments = new ArrayList<>();
    //Un arrayList con los doctores que tienen citas disponibles
    public static void showDoctorMenu(){
        //Simulamos que el doctor ya está loggueado por lo que le damos las siguientes opciones
        int response =0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+UIMenu.doctorLoggued.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled Appointment");
            System.out.println("0. Loggout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsManu();
                    break;
                case 2:

                    break;
                case 0:
                    UIMenu.showMenu();
                    //Retorna al menú principal para que se loggue nuevamente
                    break;
            }
        }while (response !=0);
        //Do while es muy usado para menús
    }

    private static void showAddAvailableAppointmentsManu(){
        int response = 0;
        do {
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a month");
            for (int i = 0; i < 3; i++) {
                //Imprimir meses
                int j = i+1; //Se usa para ponerlo como numeral del mes, como sabemos un array inicia en 0
                System.out.println(j+"."+UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response>0 && response<4){
                //1,2 y 3
                int monthSelected=response;
                //Confirmar e mes seleccionado
                System.out.println(monthSelected+"."+UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Inserte la fecha disponible:   [dd/mm/yyyy]");
                String date= sc.nextLine();

                System.out.println("Your date is: "+date+"\n1.Correct \n2. Change Date");
                int resopnseDate = Integer.valueOf(sc.nextLine());
                if(resopnseDate==2) continue;
                int responseTime = 0;
                String time="";
                do {
                    System.out.println("Insert the time available for date: "+date+"[16:00]");
                    time=sc.nextLine();
                    System.out.println("Your time is: "+time+"\n1.Correct \n2. Change time");
                    responseTime=Integer.valueOf(sc.nextLine());
                }while (responseTime==2);
                //No se pone el continue porque volveria al do del inicio por eso este do-while esta puesto para operar con este tipo concreto de cosas
              UIMenu.doctorLoggued.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointment(UIMenu.doctorLoggued);

            } else if (response==0) {
                showDoctorMenu();


            }

        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointment (Doctor doctor){
        if (doctor.getAA().size()>0 && !doctorseAvailablesAppoinments.contains(doctor)){
        doctorseAvailablesAppoinments.add(doctor);
        }
    }
}
