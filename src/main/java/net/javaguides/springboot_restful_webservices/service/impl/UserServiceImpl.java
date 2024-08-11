package net.javaguides.springboot_restful_webservices.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot_restful_webservices.dto.UserDto;
import net.javaguides.springboot_restful_webservices.entity.User;
import net.javaguides.springboot_restful_webservices.mapper.UserMapper;
import net.javaguides.springboot_restful_webservices.repository.UserRepository;
import net.javaguides.springboot_restful_webservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return modelMapper.map(optionalUser.get(), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        return  modelMapper.map(userRepository.save(existingUser), UserDto.class);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
