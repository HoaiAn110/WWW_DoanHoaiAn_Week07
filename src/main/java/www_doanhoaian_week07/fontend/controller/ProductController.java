package www_doanhoaian_week07.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Change @RestController to @Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www_doanhoaian_week07.backend.Services.ProducServices;
import www_doanhoaian_week07.backend.Services.ProductImageServices;
import www_doanhoaian_week07.backend.Services.ProductPriceServices;
import www_doanhoaian_week07.backend.enums.ProductStatus;
import www_doanhoaian_week07.backend.models.Product;
import www_doanhoaian_week07.backend.models.ProductImage;
import www_doanhoaian_week07.backend.models.ProductPrice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    @Autowired
    private ProducServices producServices;

    @Autowired
    private ProductImageServices productImageServices;

    @Autowired
    private ProductPriceServices productPriceServices;

    @GetMapping("/product_list")
    public String showListProduct(Model model){
        List<Product> activeProducts = producServices.findAllProduct().stream()
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
//      List<ProductImage> productImage = product.getProductImageList();
//        productImageServices.saveProductImg((ProductImage) productImage);
//
//        ProductPrice productPrice = (ProductPrice) product.getProductPrices();
//        productPriceServices.saveProductPrice(productPrice);

        product.setStatus(ProductStatus.valueOf(status));
        producServices.saveProduct(product);
        return "redirect:/product_list";
    }

    @PostMapping("/delete_product")
    private String deleteProduct(@RequestParam long id){
        Optional<Product> optionalProduct = producServices.findByID(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setStatus(ProductStatus.IN_ACTIVE);
            producServices.saveProduct(product);
        }

        return "redirect:/product_list";
    }



}
