package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.UserRepository;
import com.library.LibraryApp.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void findAll() {
        List<User> userList = new ArrayList();

        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();
        User userTwo = User.builder().userId(2l).firstName("John2").lastName("Will").status("offline").build();
        User userThree = User.builder().userId(3l).firstName("John3").lastName("Will").status("offline").build();

        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> resultList = userService.findAll();

        assertEquals(3, resultList.size());

    }

    @Test
    void findById() {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        Mockito.doReturn(userOne).when(userRepository).findByUserId(1l);

        User resultUserOne = userService.findById(1l);

        assertEquals(resultUserOne, userOne);

    }

    @Test
    void insert() {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        userService.insert(userOne);

        Mockito.verify(userRepository, Mockito.times(1)).save(userOne);
    }

    @Test
    void deleteById() {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();
        userRepository.save(userOne);
        userService.deleteById(1l);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1l);

    }

    @Test
    void update() {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        userService.insert(userOne);

        Mockito.verify(userRepository, Mockito.times(1)).save(userOne);
    }
}