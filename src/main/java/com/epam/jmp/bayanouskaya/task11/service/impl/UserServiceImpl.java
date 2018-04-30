package com.epam.jmp.bayanouskaya.task11.service.impl;

import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.repository.api.UserRepository;
import com.epam.jmp.bayanouskaya.task11.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.read(id);
    }

    @Override
    public void save(User user) {
        if (null == user.getId()) {
            userRepository.create(user);
        } else {
            userRepository.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
