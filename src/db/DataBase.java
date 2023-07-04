package db;

import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Hospital>hospitals = new ArrayList<>();

    public DataBase(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public DataBase() {
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }


}

