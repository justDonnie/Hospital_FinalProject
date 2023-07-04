package implementations;

import db.DataBase;
import models.Hospital;
import models.Patient;
import services.GenericService;
import services.PatientService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PatientImpl implements PatientService, GenericService<Patient> {
    private DataBase dataBase;

    public PatientImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public PatientImpl() {
    }

    @Override
    public String add(Long id,Patient patient) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        list.get(0).getPatients().add(patient);
        return "Patient is successfully saved !!!";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        list.get(0).getPatients().addAll(patients);
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital z: dataBase.getHospitals()) {
            z.getPatients();
            for (Patient s:z.getPatients()) {
                if (s.getId().equals(id)){
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {

        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {

        return null;
    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public String updateById(Long id, Patient patient) {

        return null;
    }

}
