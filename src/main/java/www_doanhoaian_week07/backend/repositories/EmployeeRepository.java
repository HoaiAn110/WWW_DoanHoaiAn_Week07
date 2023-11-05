package www_doanhoaian_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www_doanhoaian_week07.backend.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
