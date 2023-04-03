package com.crm.Tiefling.conf.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
@EnableWebSecurity
@Slf4j
public class SecurityConfig{
//    @Autowired
//    UserSevice userSevice;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                            try {
                                requests
                                        .requestMatchers("/", "/home").permitAll()
//                                        .requestMatchers("/initial_filling", "/get_roles", "/create_admin").permitAll()
                                        .requestMatchers("/admin/**", "/add/**").hasAuthority("admin")
                                        .requestMatchers("/user/**").hasAnyAuthority("user", "manager", "admin")
                                        .anyRequest().authenticated()
                                        .and().httpBasic()
                                        .and()
                                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                                        .and()
                                        .headers().frameOptions().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
//                        .and().formLogin()
//                        .defaultSuccessUrl("http://localhost:8189")
                )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("http://localhost:8189")
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return userSevice.loadUserByUsername(username);
//            }
//        };
//    }
}
