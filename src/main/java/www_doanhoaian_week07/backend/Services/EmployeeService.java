package www_doanhoaian_week07.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.enums.EmployeeStatus;
import www_doanhoaian_week07.backend.models.Employee;
import www_doanhoaian_week07.backend.repositories.EmployeeRepository;
import www_doanhoaian_week07.backend.utils.PageRender;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Page<Employee> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    public Page<Employee> findPaginated(Pageable pageable,Optional<String> keyword) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Employee> employees;
        if(keyword.isPresent()){
            employees = employeeRepository.findByKeyword(keyword.get());
        }else {
            employees = employeeRepository.findEmployees();
        }
        PageRender<Employee> employeePageRender = new PageRender<>();
        List<Employee> list = employeePageRender.getPageOfModel(employees.size(),startItem,pageSize,employees);
        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), employees.size());
    }
    public void deleteEmployee(long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            Employee employee = optional.get();
            employee.setId(id);
            employee.setStatus(EmployeeStatus.TERMINATED);
            employeeRepository.save(employee);
        }
    }
}
