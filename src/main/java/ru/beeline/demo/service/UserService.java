package ru.beeline.demo.service;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.beeline.demo.entity.Orderz;
import ru.beeline.demo.entity.User;
import ru.beeline.demo.repository.OrderRepository;
import ru.beeline.demo.repository.UserRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {

    private static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public User getUser(Long id){
        try {
            LOGGER.info("Getting user ok");
            return userRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    public void addOrderToUser(User user, Orderz orders) {
        user.getOrders().add(orders);
        orders.setUser(user);
        userRepository.save(user);
        orderRepository.save(orders);
    }

    public List<User> getAllUsers(){
        LOGGER.info("Getting all Users");
        return userRepository.findAll();
    }

    public User save(User user){
        LOGGER.info("Create user");
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = getUser(id);
        userRepository.delete(user);
    }

    public User update(User user, long id){
        User u2 = getUser(id);
        u2.setId(id);
        u2.setName(user.getName());
        u2.setOrders(user.getOrders());
        u2.setPassword(user.getPassword());
        userRepository.delete(user);
        return userRepository.save(u2);
    }

}
