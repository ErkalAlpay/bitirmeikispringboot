package com.bitirmeprojesi.eticaret.service;

import com.bitirmeprojesi.eticaret.entity.Role;
import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.exception.model.AccountBlockedException;
import com.bitirmeprojesi.eticaret.exception.model.DefaultException;
import com.bitirmeprojesi.eticaret.exception.model.UnverifiedEmailException;
import com.bitirmeprojesi.eticaret.exception.model.UsernameOrPasswordWrongException;
import com.bitirmeprojesi.eticaret.repository.RoleRepository;
import com.bitirmeprojesi.eticaret.repository.UserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService  implements UserDetailsService{

    @Autowired
    private UserRepsitory userRepsitory;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepsitory.findByUsername(username);
        if (user == null) {
            throw  new UsernameOrPasswordWrongException();
        }
        if (user.getEmail_status() == false) {
            throw new UnverifiedEmailException();
        }
        if (user.getAccount_block() == true) {
            throw new AccountBlockedException();
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role =  roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        return userRepsitory.save(user);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username,String roleName){
        User user = userRepsitory.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepsitory.save(user);
    }

    public User getUser(String username){
        return userRepsitory.findByUsername(username);
    }

    public List<User> getUsers(){
        return userRepsitory.findAll();
    }


    public void updateUserEmailStatus(String username, Boolean emailStatus ) {
        User user = userRepsitory.findByUsername(username);
        if (user == null) {
            throw new DefaultException("Hatalı kullanıcı adı!");
        }
        user.setEmail_status(emailStatus);
        userRepsitory.save(user);
    }
}
