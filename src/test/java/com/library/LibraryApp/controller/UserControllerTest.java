package com.library.LibraryApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryApp.entity.User;
import com.library.LibraryApp.entity.User;
import com.library.LibraryApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        List<User> userList = new ArrayList();

        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();
        User userTwo = User.builder().userId(2l).firstName("John2").lastName("Will").status("offline").build();
        User userThree = User.builder().userId(3l).firstName("John3").lastName("Will").status("offline").build();

        userList.add(userOne);
        userList.add(userTwo);
        userList.add(userThree);

        Mockito.when(userService.findAll()).thenReturn(userList);

        String expectedValue = objectMapper.writeValueAsString(userList);

        String givenValue = mockMvc.perform(get("/users")).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void findAllById() throws Exception {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        Mockito.doReturn(userOne).when(userService).findById(1l);

        String expectedValue = objectMapper.writeValueAsString(userOne);

        String givenValue = mockMvc.perform(get(String.format("/users/%d", userOne.getUserId()))).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void insert() throws Exception {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        String content = objectMapper.writeValueAsString(userOne);

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(userService, Mockito.times(1)).insert(userOne);
    }

    @Test
    void delete() throws Exception {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1"));

        Mockito.verify(userService, Mockito.times(1)).deleteById(userOne.getUserId());
    }

    @Test
    void update() throws Exception {
        User userOne = User.builder().userId(1l).firstName("John").lastName("Will").status("offline").build();

        String content = objectMapper.writeValueAsString(userOne);

        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(userService, Mockito.times(1)).insert(userOne);
    }
}