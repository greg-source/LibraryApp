package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.UserRepository;
import com.library.LibraryApp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
