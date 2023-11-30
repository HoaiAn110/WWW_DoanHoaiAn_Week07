package www_doanhoaian_week07.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import www_doanhoaian_week07.backend.models.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {

    String getImageByProduct(long id);
}
