package www_doanhoaian_week07.backend.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.repositories.ProductImageRepository;

@Service
@RequiredArgsConstructor
public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public String getPathOfProduct(long id){
        return productImageRepository.getImageByProduct(id);
    }
}
