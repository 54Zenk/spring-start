package ru.beeline.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.beeline.demo.entity.Orderz;
import ru.beeline.demo.entity.Product;
import ru.beeline.demo.repository.OrderRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderService{
    private static java.util.logging.Logger LOGGER = Logger.getLogger(UserService.class.getName());


    @Autowired
    private OrderRepository orderRepository;


    public Orderz getOrder(Long id){
        try {
            LOGGER.info("Getting order ok");
            return orderRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }



    public List<Orderz> getAllOrders(){
        LOGGER.info("Getting all Orders");
        return orderRepository.findAll();
    }

    public Orderz save(Orderz orderz){
        if (orderz.getAmount() > orderz.getProduct().getInstock())
        {
            try {int k = 1/0;} catch (Exception e) {
                LOGGER.info("Not enough items in stock");
                throw new NEIException("Not Enough items in stock");
            }
            return null;
        }
            else
        {
            orderz.getProduct().buy(orderz.getAmount());
            LOGGER.info("Order successfully created");
            return orderRepository.save(orderz);
        }

    }


    public class NEIException extends RuntimeException {

        public NEIException(){
            super();
        }

        public NEIException(String message){
            super(message);
        }
    }
}