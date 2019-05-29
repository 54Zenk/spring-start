package ru.beeline.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.beeline.demo.entity.Orderz;
import ru.beeline.demo.entity.Product;
import ru.beeline.demo.repository.OrderRepository;
import ru.beeline.demo.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class ProductService {
    private static java.util.logging.Logger LOGGER = Logger.getLogger(UserService.class.getName());


    @Autowired
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public Product save(Product product){
        LOGGER.info("Create a product");
        return productRepository.save(product);
    }


    public List<Product> getAllProducts(){
        LOGGER.info("Getting all Products");
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        try {
            LOGGER.info("Getting product ok");
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }


    public void addProductToOrder(Product product, Orderz orders) {
        product.getOrders().add(orders);
        orders.setProduct(product);
        productRepository.save(product);
        orderRepository.save(orders);
    }


    public void deleteProduct(Long id){
        Product product = getProduct(id);
        productRepository.delete(product);
    }

    public Product update(Product product, long id){
        Product u2 = getProduct(id);
        u2.setId(id);
        u2.setName(product.getName());
        u2.setOrders(product.getOrders());
        u2.setPrice(product.getPrice());
        u2.setInstock(product.getInstock());
        productRepository.delete(product);
        return productRepository.save(u2);
    }
}
