//package ru.beeline.demo;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import ru.beeline.demo.entity.User;
//import ru.beeline.demo.entity.Product;
//import ru.beeline.demo.repository.ProductRepository;
//import ru.beeline.demo.repository.UserRepository;
//
//import java.util.LinkedList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringStartApplicationTests {
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Test
//	public void contextLoads() {
//	}
//
//	private ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
//
//	@Test
//	public void databaseTest() throws JsonProcessingException {
//		Product product = new Product();
//		product.setName("Milk");
//		product.setPrice(520);
//		User user = new User();
//		user.setName("myCart");
//		product.setUser(user);
//		List<Product> products = new LinkedList<>();
//		products.add(product);
//		user.setProducts(products);
//		productRepository.save(user);
//		userRepository.save(product);
//
//		List<User> result = productRepository.findAll();
//		System.out.println(writer.writeValueAsString(result));
//	}
//
//}
