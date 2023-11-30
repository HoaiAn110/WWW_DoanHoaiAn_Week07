package www_doanhoaian_week07.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import www_doanhoaian_week07.backend.models.OrderDetail;
import www_doanhoaian_week07.backend.pks.OrderDetailPK;

import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

    Optional<Double> getTotalPriceOfOrder(long id);
}
