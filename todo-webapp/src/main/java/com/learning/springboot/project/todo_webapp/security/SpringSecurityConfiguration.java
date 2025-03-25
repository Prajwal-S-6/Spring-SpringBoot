package com.learning.springboot.project.todo_webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    // In memory(in real life we use DB or LDAP)

        @Bean
        public InMemoryUserDetailsManager createUserDetailsManager() {
            Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
            UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username("Prajwal").password("password").roles("USER", "ADMIN").build();
            return new InMemoryUserDetailsManager(userDetails);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
                    auth -> auth.anyRequest().hasRole("USER")
            );
            http.formLogin(Customizer.withDefaults());
            return http.build();
        }
}
