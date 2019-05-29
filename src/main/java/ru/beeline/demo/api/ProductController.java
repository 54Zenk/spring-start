package ru.beeline.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.beeline.demo.entity.Orderz;
import ru.beeline.demo.entity.Product;
import ru.beeline.demo.entity.User;
import ru.beeline.demo.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getProduct")
    public Product getProductById(@RequestParam Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product, @RequestParam Long id) {
        productService.update(product, id);
    }
}
