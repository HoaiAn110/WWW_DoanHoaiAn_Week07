package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.Product;
import www_doanhoaian_week07.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> findByID(long id){
        return productRepository.findById(id);
    }


    public void  saveProduct(Product product){
        productRepository.save(product);
    }

public  void deleteProduct(Product product){
        productRepository.delete(product);
}

}
