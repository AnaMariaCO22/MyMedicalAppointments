package ui;

import model.Doctor;
import model.Patient;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final  String[ ] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septienbre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLoggued;
    public static Patient patientLogued;
    public static void showMenu(){
        System.out.println("Welcome to my appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");
            //Bloque para recibir datos de consola
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response=0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Paciente");
                    response = 0;
                    authUser(2);
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
                        System.out.println(i+"."+MONTHS[i]);
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

    private static void authUser(int userType){
        //userType 1: Doctor
        //userType 2: paciente
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Aleandro Martinez","alejandor@mail.com"));
        doctors.add(new Doctor("Karen Sosa","karen@mail.com"));
        doctors.add(new Doctor("Rocio Gomez","rocio@mail.com"));

        ArrayList<Patient> pacientes = new ArrayList<>();
        pacientes.add(new Patient("Ana Velasquez","ana@email.com"));
        pacientes.add(new Patient("Roberto Rodriguez","roberto@email.com"));
        pacientes.add(new Patient("Carlos Snachez","carlos@email.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc =new Scanner(System.in);
            String email = sc.nextLine();
            if (userType==1){
                for (Doctor d:doctors){
                    //Encontrar el correo electronico que haga match con el correo que escribí
                    if (d.getEmail().equals(email)){
                        emailCorrect=true;
                        //Obtener el usuario loggueado, para esto crea la variable static
                        doctorLoggued = d; //A el usuario static le pongo los datos de usuario encontrado
                        UIDoctorMenu.showDoctorMenu();
                    }

                }
            }
            if (userType==2) {
                for (Patient p : pacientes) {
                    //Encontrar el correo electronico que haga match con el correo que escribí
                    if (p.getEmail().equals(email)) ;
                    emailCorrect = true;
                    //Obtener el usuario loggueado, para esto crea la variable static
                    patientLogued = p; //A el usuario static le pongo los datos de usuario encontrado
                    //showDoctorMenu
                    UIPatientMenu.showPatientMenu();
                }
            }
        }while (!emailCorrect ); //si email es falso
    }

}
