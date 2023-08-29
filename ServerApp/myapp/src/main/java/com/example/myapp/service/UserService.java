package com.example.myapp.service;

import com.example.myapp.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User create(User user);

    Collection<User> list(int limit);

    User get(Long id);

    User update(User user);

    Boolean delete(Long id);

    List<User> returnUsers();

    List<User> returnUsersSorted();

    void delete();
}
