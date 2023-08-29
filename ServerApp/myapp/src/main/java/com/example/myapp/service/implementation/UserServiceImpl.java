package com.example.myapp.service.implementation;

import com.example.myapp.enumeration.Role;
import com.example.myapp.model.User;
import com.example.myapp.repo.UserRepo;
import com.example.myapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user); //save in database
    }

    @Override
    public Collection<User> list(int limit) {
        log.info("Prikupljamo sve korisnike");
        return userRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User get(Long id) {
        log.info("Dobavljamo korisnika po id: {}", id);
        return userRepo.findById(id).get();
    }

    @Override
    public User update(User user) {
        log.info("Updating korisnika: {}", user.getUsername());
        return userRepo.save(user); //save in database , on zna i moze da prepozna ako postoji id da je postojeci korisnik
        //ako ne postoji napravice novi, u suprotnom samo updatuje podatke
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Brisanje korisnika po id: {}", id);
        userRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public List<User> returnUsers() {
        return userRepo.findAllNonAdmin(Role.ADMIN);
    }

    @Override
    public List<User> returnUsersSorted() {
        return userRepo.findAllNonAdmin(Role.ADMIN);
    }

    @Override
    public void delete() {
        userRepo.deleteAll();
    }

    private String setUserImageURL() { //provjeri putanju
        String[] imageNames = {"user1.png,user2.png,user3.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/image/" + imageNames[new Random().nextInt(3)]).toUriString();
    }
}
