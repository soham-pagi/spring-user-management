package net.javaguides.springboot_restful_webservices.service;

import net.javaguides.springboot_restful_webservices.dto.UserDto;
import net.javaguides.springboot_restful_webservices.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);
}
