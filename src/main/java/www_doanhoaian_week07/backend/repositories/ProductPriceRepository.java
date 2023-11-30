package www_doanhoaian_week07.backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www_doanhoaian_week07.backend.models.ProductPrice;
import www_doanhoaian_week07.backend.pks.ProductPricePK;

import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {

   double getNearestPriceByProduct(long id);

   List<Object[]> getPriceFollowTime(long id);
}
