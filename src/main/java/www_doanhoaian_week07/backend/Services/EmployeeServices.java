package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.Employee;
import www_doanhoaian_week07.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> findAll(){
        return  employeeRepository.findAll();
    }


    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }


    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }



}
