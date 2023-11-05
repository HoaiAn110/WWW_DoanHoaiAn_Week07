package www_doanhoaian_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www_doanhoaian_week07.backend.ids.OrderDetailID;
import www_doanhoaian_week07.backend.models.Order;
import www_doanhoaian_week07.backend.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {
}
