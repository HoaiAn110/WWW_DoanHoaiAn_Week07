package www_doanhoaian_week07.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Change @RestController to @Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www_doanhoaian_week07.backend.Services.ProductServices;
import www_doanhoaian_week07.backend.Services.ProductImageServices;
import www_doanhoaian_week07.backend.Services.ProductPriceServices;
import www_doanhoaian_week07.backend.enums.ProductStatus;
import www_doanhoaian_week07.backend.models.Product;
import www_doanhoaian_week07.backend.models.ProductImage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @Autowired
    private ProductImageServices productImageServices;

    @Autowired
    private ProductPriceServices productPriceServices;

    @GetMapping("/product_list")
    public String showListProduct(Model model){
        List<Product> activeProducts = productServices.findAllProduct().stream()
                .filter(product -> product.getStatus() == ProductStatus.ACTIVE)
                .collect(Collectors.toList());

        model.addAttribute("product", activeProducts);
        return "admin/product/list";
    }

    @GetMapping("/add_product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "admin/product/add";
    }

    @PostMapping("/add_product")
    private String showSaveProduct(@ModelAttribute Product product, @RequestParam String status){
        List<ProductImage> productImageList = product.getProductImageList();

        // Iterate through the list and save each ProductImage
        for (ProductImage productImage : productImageList) {
            productImageServices.saveProductImg(productImage);
        }

        product.setStatus(ProductStatus.valueOf(status));
        productServices.saveProduct(product);  // Assuming productService is correct.

        return "redirect:/product_list";
    }



    @PostMapping("/delete_product")
    private String deleteProduct(@RequestParam long id){
        Optional<Product> optionalProduct = productServices.findByID(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setStatus(ProductStatus.IN_ACTIVE);
            productServices.saveProduct(product);
        }

        return "redirect:/product_list";
    }





}
