package com.crm.Tiefling.service;

import com.crm.Tiefling.entity.Authority;
import com.crm.Tiefling.entity.User;
import com.crm.Tiefling.exceptions.UserExistsException;
import com.crm.Tiefling.repository.AuthorityRepository;
import com.crm.Tiefling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserSevice implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = loadOptionalUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()));

    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        try {
            return userMap.get(id);
        } catch (Exception e) {
            return userRepository.getReferenceById(id);
        }
    }

    public void saveAuthority(Authority authority){authorityRepository.save(authority);}

    private Optional<User> loadOptionalUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Authority getAuthorityByName(String name) {
        return authorityRepository.loadAuthorityByName(name);
    }

    public List<Authority> getAllAuthorities() {
        return authorityRepository.findAll();
    }

    private Collection<? extends GrantedAuthority> mapToGrantedAuthorities(Collection<Authority> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

    public void saveUser(User user) throws UserExistsException {
        if (userRepository.loadUserByUsername(user.getUsername()) == null){
//            user.setRole_id(roleRepository.getReferenceById(2L));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMap.put(user.getId(), user);
            userRepository.save(user);
        }else {
            throw new UserExistsException("User exist. Try to change your login");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
