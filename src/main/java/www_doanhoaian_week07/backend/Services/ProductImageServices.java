package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.ProductImage;
import www_doanhoaian_week07.backend.repositories.ProductImageRepository;

import java.util.List;

@Service
public class ProductImageServices {
    @Autowired
    private ProductImageRepository productImageRepository;


    public List<ProductImage> findAll(){
        return  productImageRepository.findAll();
    }


    public void saveProductImg(ProductImage productImage){
        productImageRepository.save(productImage);
    }
}
