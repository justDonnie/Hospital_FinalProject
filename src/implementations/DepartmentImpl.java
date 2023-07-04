package implementations;

import db.DataBase;
import models.Department;
import models.Hospital;
import services.DepartmentService;
import services.GenericService;

import javax.swing.event.ListDataEvent;
import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DepartmentImpl implements DepartmentService,GenericService<Department> {
    private DataBase dataBase;

    public DepartmentImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DepartmentImpl() {
    }

    @Override
    public String add(Long id,Department department) {
        for (Hospital s: dataBase.getHospitals()) {
            if (s.getId().equals(id)){
                s.getDepartments().add(department);
                return "The department is successfully added!!! ";
            }
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        return list.get(0).getDepartments();
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital h: dataBase.getHospitals()) {
            h.getDepartments();
            for (Department d:h.getDepartments()) {
                if (d.getDepartmentName().equalsIgnoreCase(name)){
                    return d;
                }
            }
        }
        return null;
    }


    @Override
    public void removeById(Long id) {
        for (Hospital s: dataBase.getHospitals()) {
            for (int i = 0; i < s.getDepartments().size(); i++) {
                if (s.getDepartments().get(i).getId().equals(id)){
                    s.getDepartments().remove(s.getDepartments().get(i));
                    System.out.println("The department is successfully deleted!!!");
                }
            }

        }

    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital h: dataBase.getHospitals()) {
            for (Department d :h.getDepartments()) {
                if (d.getId().equals(id)){
                    d.setDepartmentName(department.getDepartmentName());
                    d.setDoctors(department.getDoctors());
                }
            }
        }
        return "Department is successfully updated!!!";
    }

}
