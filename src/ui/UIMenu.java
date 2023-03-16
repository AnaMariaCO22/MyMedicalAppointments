package ui;

import java.util.Scanner;

public class UIMenu {

    public static String[ ] months = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septienbre","Octubre","Noviembre","Diciembre"};
    public static void showMenu(){
        System.out.println("Welcome to my appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("model.Doctor");
                    break;
                case 2:
                    response = 0;
                    showPatientMenu();
                    break;
                case 0:
                    System.out.println("Gracias por tu visita");
                    break;
                default:
                    System.out.println("Selecciona una respuesta correcta");
            }
        }while (response != 0);
    }

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("   ");
            System.out.println("Paciente");
            System.out.println("1. Agendar una cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Agendar una cita");
                    for (int i = 0; i <3; i++) {
                        System.out.println(i+"."+months[i]);
                    }
                    break;
                case 2:
                    System.out.println("Mis citas");
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Selecciona una respuesta correcta");
                    break;
            }
        }while (response !=0);
    }

}
