package com.johnny.teste.config;

import com.johnny.teste.entities.Order;
import com.johnny.teste.entities.User;
import com.johnny.teste.repositories.OrderRepository;
import com.johnny.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("João Vitor", "8892878", "joao@gmail.com", "1234");
        User user2 = new User("Malu", "8892878", "malu@gmail.com", "1234");

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), user1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), user2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), user1);

        user1.getOrders().addAll(Arrays.asList(o1, o3));
        user2.getOrders().add(o2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2,o3));

    }
}
