package net.javaguides.springboot_restful_webservices.service;

import net.javaguides.springboot_restful_webservices.entity.User;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
}
