package com.example.myapp.converter;

import com.example.myapp.dtos.UserDto;
import com.example.myapp.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserConverter {
    public List<UserDto> convertList(List<User> users) {
        List<UserDto> list = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = convert(user);
            list.add(userDto);
        }
        return list;
    }
    private UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setLastname(user.getLastName());
        userDto.setFirstname(user.getFirstname());
        userDto.setEmail(user.getEmail());
        userDto.setDateOfBirth(user.getDate());
        userDto.setImageUrl(user.getImageUrl());
        userDto.setGender(user.getGender());
        userDto.setId(user.getUserId());
        return userDto;
    }

}
