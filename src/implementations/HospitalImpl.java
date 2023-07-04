package implementations;

import db.DataBase;
import models.Hospital;
import models.Patient;
import services.GenericService;
import services.HospitalService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalImpl implements HospitalService{
    private DataBase dataBase;

    public HospitalImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public HospitalImpl() {
    }

    @Override
    public String addHospital(Hospital hospital) {
        dataBase.getHospitals().add(hospital);
        return "Hospital is successfully saved! ";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).forEach(System.out::println);
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        for (Hospital s: dataBase.getHospitals()) {
            System.out.println(s);
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        for (Hospital s:list) {
            return s.getPatients();
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        dataBase.getHospitals().removeIf(hospital -> hospital.getId().equals(id));
        return "Hospital is successfully deleted!!!";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
     //   List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getAddress().equals(address)).toList();
        Map<String,Hospital>hospitalMap = new HashMap<>();
        for (Map.Entry<String , Hospital>hospitalEntry:hospitalMap.entrySet()) {
            if (hospitalEntry.getValue().equals(address)){

            }
        }
        return null;

    }
}
