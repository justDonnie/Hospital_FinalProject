package implementations;

import db.DataBase;
import models.Department;
import models.Doctor;
import models.Hospital;
import services.DoctorService;
import services.GenericService;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.print.Doc;
import java.util.List;

public class DoctorImpl implements DoctorService, GenericService<Doctor> {
    private DataBase dataBase;

    public DoctorImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DoctorImpl() {
    }

    @Override
    public String add(Long id, Doctor doctor) {
        for (Hospital s : dataBase.getHospitals()) {
            if (s.getId().equals(id)) {
                s.getDoctors().add(doctor);
                return "The doctor is successfully added!!!";
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {

        for (Hospital s : dataBase.getHospitals()) {
            for (Department d : s.getDepartments()) {
                if (departmentId.equals(d.getId())) {

                    for (Long id : doctorsId) {
                        d.getDoctors().add(findDoctorById(id));
                    }
                    d.setDoctors(d.getDoctors());
                }
            }
        }
        return "Doctor is successfully assigned!";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital s : dataBase.getHospitals()) {
            s.getDoctors();
            for (Doctor d : s.getDoctors()) {
                if (d.getId().equals(id)) {
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        return list.get(0).getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {

        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            h.getDoctors().removeIf(doctor -> doctor.getId().equals(id));
            System.out.println("Doctor is successfully deleted!!!");
        }

    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital s : dataBase.getHospitals()) {
            for (Doctor d : s.getDoctors()) {
                if (d.getId().equals(id)) {
                    d.setFirstName(doctor.getFirstName());
                    d.setLastName(doctor.getLastName());
                    d.setGender(doctor.getGender());
                    d.setExperienceYear(doctor.getExperienceYear());
                }
            }
        }
        return "Doctor is successfully updated !!!";
    }
}
