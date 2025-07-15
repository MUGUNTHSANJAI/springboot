package com.example.Springbootfirstproject.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
//        Disabled Form In the Shown In the Web Browser after doing it a popUP is shown
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->{
//                    auth.requestMatchers(HttpMethod.POST,"/student").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.PUT,"/student").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.DELETE,"/student").hasRole("ADMIN");
//                    auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
                    auth.anyRequest().authenticated();})
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
    @Bean
//   InMemoryUserDetailsManager userDetails()
    UserDetailsService userDetails()
    {
        UserDetails admin= User.builder().
                        username("admin").
                        password(passwordEncoder().encode("admin")).
                        roles("ADMIN").
                        build();
        UserDetails Sharan=User.builder()
                .username("Sharan")
                .password(passwordEncoder().encode("Sharan-06"))
                .roles("USER")
                .build();
         return new InMemoryUserDetailsManager(admin,Sharan);
    }



}
