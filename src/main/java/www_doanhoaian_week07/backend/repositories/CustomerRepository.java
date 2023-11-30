package www_doanhoaian_week07.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import www_doanhoaian_week07.backend.models.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.name like %:keyword% or c.phone like %:keyword%")
    List<Customer> findByKeyword(@Param("keyword") String keyword);


    String findNameCustomer(long id);
}
