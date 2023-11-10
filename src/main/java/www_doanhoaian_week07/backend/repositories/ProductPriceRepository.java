package www_doanhoaian_week07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import www_doanhoaian_week07.backend.ids.ProductPriceID;
import www_doanhoaian_week07.backend.models.Product;
import www_doanhoaian_week07.backend.models.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPriceID> {
}
