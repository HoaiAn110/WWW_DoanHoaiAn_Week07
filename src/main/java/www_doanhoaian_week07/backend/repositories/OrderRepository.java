package www_doanhoaian_week07.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www_doanhoaian_week07.backend.models.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

      Optional<Order> getOrderNewest();

      List<Object[]> getTotalPriceOrderByDate(LocalDateTime fromDate,LocalDateTime toDate);

      List<Order> getOrderByDate(LocalDateTime fromDate,LocalDateTime toDate);
}
