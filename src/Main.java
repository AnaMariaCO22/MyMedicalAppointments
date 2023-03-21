import model.*;

import java.util.Date;

import static ui.UIMenu.showMenu;

public class Main {
    public static void main(String[] args) {
        showMenu();
        /*
        model.Doctor myDoctor = new model.Doctor();
        myDoctor.showName();
        myDoctor.showId();

        model.Doctor.id++;

        model.Doctor myDoctorAna = new model.Doctor();
        myDoctor.showId();
        System.out.println(model.Doctor.id);

        //showMenu();
        Doctor myDoctor = new Doctor("Ana Maria", "Cardiologa");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "11am");


        Patient paciente = new Patient("Alejandra", "ana@gmail");
        System.out.println(paciente);

        System.out.println(myDoctor);

        User user = new Patient("Ana Maria", "anamaria.com");
        user.showDataUser();

        User user1 = new User("ana", "ana@maria.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital cruz verde");
                System.out.println("Departamente: geriatría");

            }
        };
        user1.showDataUser();

        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };
        ISchedulable sch = new AppointmentDoctor();
        /*
           System.out.println(myDoctor.getAA());
        for (model.Doctor.AvailableAppointment aa: myDoctor.getAA()){
            System.out.println(aa.getDate() + " "+aa.getTime());
        }
        model.Patient paciente2 = new model.Patient("Ana Maria", "maria@gmail");
        System.out.println(paciente.getName());
        System.out.println(paciente2.getName());
        paciente2=paciente;

        System.out.println(paciente);
        System.out.println(paciente2);
        paciente2.setName("Manuel");
        System.out.println(paciente.getName());
        System.out.println(paciente2.getName());
        /*
        model.Patient paciente = new model.Patient("Ana Maria","ana@gmaail.com");
        paciente.setWeight(54.6);
        System.out.println(paciente.getWeight());

        paciente.setPhoneNumber("46547809");
        System.out.println(paciente.getPhoneNumber());
 */

    }

}