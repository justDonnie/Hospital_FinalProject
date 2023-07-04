import db.DataBase;
import enums.Gender;
import implementations.DepartmentImpl;
import implementations.DoctorImpl;
import implementations.HospitalImpl;
import implementations.PatientImpl;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Hospital>hospitals = new ArrayList<>();
        DataBase dataBase = new DataBase(hospitals);
        HospitalImpl hospitalImpl = new HospitalImpl(dataBase);
        DepartmentImpl departmentImpl = new DepartmentImpl(dataBase);
        DoctorImpl doctorImpl = new DoctorImpl(dataBase);
        PatientImpl patientImpl = new PatientImpl(dataBase);

        List<Patient>patientList = new ArrayList<>(
                List.of(new Patient(50505L,"Mike","Anders",35,Gender.MALE),
                        new Patient(50505L," ","Anders",35,Gender.MALE),
                        new Patient(50505L,"Mike","Anders",35,Gender.MALE),
                        new Patient(50505L,"Mike","Anders",35,Gender.MALE),
                        new Patient(50505L,"Mike","Anders",35,Gender.MALE)

        ));

        int a = 0;
        while (a < 22) {
            try {
                int b = new Scanner(System.in).nextInt();
                switch (b){
                    case 1 -> {
                        System.out.print("Assign the hospital ID: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.print("Input the hospital name: ");
                        String hospName = new Scanner(System.in).nextLine();
                        System.out.print("Input the hospitals address: ");
                        String hospAddress = new Scanner(System.in).nextLine();
                        System.out.println(hospitalImpl.addHospital(new Hospital(hospID, hospName, hospAddress)));
                    }
                    case 2 ->{
                        System.out.print("Input the hospitals ID to find: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println(hospitalImpl.findHospitalById(hospID));
                    }
                    case 3 -> System.out.println(hospitalImpl.getAllHospital());
                    case 4 ->{
                        System.out.print("Input the hospitals ID to add the patients! : ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.print("Assign the ID to patient: ");
                        Long patID = new Scanner(System.in).nextLong();
                        System.out.print("Input first name of patient: ");
                        String firstName = new Scanner(System.in).nextLine();
                        System.out.print("Input second name of patient: ");
                        String lastName = new Scanner(System.in).nextLine();
                        System.out.print("Input age of patient: ");
                        int age = new Scanner(System.in).nextInt();
                        System.out.print("Input gender of patient: ");
                        String gender = new Scanner(System.in).nextLine();
                        System.out.println(patientImpl.add(hospID,new Patient(patID,firstName,lastName,age, Gender.valueOf(gender))));
                    }
                    case 5 ->{
                        System.out.print("Input the hospitals ID to get list of all patients: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println(hospitalImpl.getAllPatientFromHospital(hospID));
                    }
                    case 6 ->{
                        System.out.print("Input the hospitals ID to delete: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println(hospitalImpl.deleteHospitalById(hospID));
                    }
                    case 7 -> {
                        System.out.print("Input the hospitals address to get the hospital: ");
                        String hospAddress = new Scanner(System.in).nextLine();
                        System.out.println(hospitalImpl.getAllHospitalByAddress(hospAddress));
                    }
                    case 8 ->{
                        System.out.println();

                    }
                    case 9 -> {
                        System.out.print("Input the hospitals ID to add the department! : ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println("Assign the ID to department: ");
                        Long depID = new Scanner(System.in).nextLong();
                        System.out.print("Enter the designation of department!: ");
                        String depName = new Scanner(System.in).nextLine();
                        System.out.print(departmentImpl.add(hospID,new Department(depID,depName)));
                    }
                    case 10 -> {
                        System.out.print("Input the hospitals ID to get all list of departments!: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println(departmentImpl.getAllDepartmentByHospital(hospID));
                    }
                    case 11 -> {
                        System.out.print("Input the departments name to get the info: ");
                        String depName = new Scanner(System.in).nextLine();
                        System.out.println(departmentImpl.findDepartmentByName(depName));
                    }
                    case 12->{
                        System.out.print("Input the departments ID to delete the department!: ");
                        Long depID = new Scanner(System.in).nextLong();
                        departmentImpl.removeById(depID);
                    }
                    case 13 ->{
                        System.out.print("Input the departments ID to update: ");
                        Long oldDepID = new Scanner(System.in).nextLong();
                        System.out.print("Assign new ID to department: ");
                        Long depID = new Scanner(System.in).nextLong();
                        System.out.print("Input the new designation of department!: ");
                        String depName = new Scanner(System.in).nextLine();
                        System.out.println(departmentImpl.updateById(oldDepID,new Department(depID,depName)));
                    }
                    case 14 ->{
                        System.out.print(" Input the hospitals ID to add the doctor!: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.print("Assign the ID to doctor: ");
                        Long docID = new Scanner(System.in).nextLong();
                        System.out.print("Input the first name of doctor!: ");
                        String firstName = new Scanner(System.in).nextLine();
                        System.out.print("Input the last name of doctor!");
                        String lastName = new Scanner(System.in).nextLine();
                        System.out.print("Input the gender of doctor!: ");
                        String gender = new Scanner(System.in).nextLine();
                        System.out.print("Enter the experience year of doctor!: ");
                        int expYear = new Scanner(System.in).nextInt();
                        System.out.println(doctorImpl.add(hospID,new Doctor(docID,firstName,lastName,Gender.valueOf(gender),expYear)));
                    }
                    case 15 ->{
                        System.out.print("Input the departments ID to assign the doctor to department! :");
                        Long depID = new Scanner(System.in).nextLong();
                        System.out.println(doctorImpl.assignDoctorToDepartment(depID,new ArrayList<>(
                        )));
                    }
                    case 16 ->{
                        System.out.print("Input the doctors ID to find the doctor and get info!: ");
                        Long docID = new Scanner(System.in).nextLong();
                        System.out.println(doctorImpl.findDoctorById(docID));
                    }
                    case 17 ->{
                        System.out.print("Input the hospitals ID to get all list of the doctors: ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.println(doctorImpl.getAllDoctorsByHospitalId(hospID));
                    }
                    case 18 ->{


                    }
                    case 19 ->{
                        System.out.print("Input the doctors ID to delete the doctor!: ");
                        Long docID  = new Scanner(System.in).nextLong();
                        doctorImpl.removeById(docID);
                    }
                    case 20 ->{
                        System.out.print("Input the doctors ID to update the doctor!: ");
                        Long docID = new Scanner(System.in).nextLong();
                        System.out.print("Assign the new ID to doctor!: ");
                        Long docNewID = new Scanner(System.in).nextLong();
                        System.out.print("Input the new first name of doctor: ");
                        String firstName = new Scanner(System.in).nextLine();
                        System.out.print("Input the new last name of doctor: ");
                        String lastName = new Scanner(System.in).nextLine();
                        System.out.print("Input the gender of doctor: ");
                        String gender = new Scanner(System.in).nextLine();
                        System.out.print("Input the experience year of doctor: ");
                        int expYear = new Scanner(System.in).nextInt();
                        System.out.println(doctorImpl.updateById(docID,new Doctor(docNewID,firstName,lastName,Gender.valueOf(gender),expYear)));
                    }
                    case 21 -> {
                        System.out.print("Input the hospitals ID to add the patients! : ");
                        Long hospID = new Scanner(System.in).nextLong();
                        System.out.print("Assign the ID to patient: ");
                        Long patID = new Scanner(System.in).nextLong();
                        System.out.print("Input first name of patient: ");
                        String firstName = new Scanner(System.in).nextLine();
                        System.out.print("Input second name of patient: ");
                        String lastName = new Scanner(System.in).nextLine();
                        System.out.print("Input age of patient: ");
                        int age = new Scanner(System.in).nextInt();
                        System.out.print("Input gender of patient: ");
                        String gender = new Scanner(System.in).nextLine();
                        System.out.println(patientImpl.addPatientsToHospital(hospID,new ArrayList<>(
                                List.of(new Patient(patID,firstName,lastName,age,Gender.valueOf(gender)))
                        )));
                    }
                    case 22 ->{
                        
                    }

















                }

















            } catch (InputMismatchException e) {
                System.err.println("Input correct commands !!!");
            }


        }
    }
}