package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.ProductPrice;
import www_doanhoaian_week07.backend.repositories.ProductPriceRepository;

@Service
public class ProductPriceServices {
    @Autowired
    private ProductPriceRepository productPriceRepository;

    public void saveProductPrice(ProductPrice productPrice){
        productPriceRepository.save(productPrice);
    }
}
