package www_doanhoaian_week07.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import www_doanhoaian_week07.backend.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findEmployees();

    String findNameEmployee(long id);

    @Query("select e from  Employee e where e.fullName like %:keyword% or e.email like %:keyword%")
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}
