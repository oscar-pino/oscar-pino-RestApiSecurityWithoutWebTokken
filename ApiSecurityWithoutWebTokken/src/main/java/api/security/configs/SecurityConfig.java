package api.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import api.security.services.UserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(http -> {
					
					http.requestMatchers(HttpMethod.GET, "/public").permitAll();
					
					http.requestMatchers(HttpMethod.GET, "/user").hasRole("USER");
					http.requestMatchers(HttpMethod.POST, "/api/nationalities/create").hasRole("ADMIN");
					http.requestMatchers(HttpMethod.POST, "/api/nationalities/delete").hasRole("ADMIN");
					http.requestMatchers(HttpMethod.GET, "/api/nationalities/readAll").hasAnyRole("USER");			
		
					// http.anyRequest().denyAll();
					http.anyRequest().authenticated();
				}).
				httpBasic(Customizer.withDefaults()).build();
	}

	/*
	@Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("oscar")
                .password("1234")
                .roles("ADMIN")
                .build();
        
        UserDetails user2 = User.withUsername("juan")
                .password("1234")
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(user1, user2);
    } */

	@Bean
	AuthenticationProvider authenticationProvider(UserDetailsServiceImp userDetailsServiceImp) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService((UserDetailsService) userDetailsServiceImp);
		return provider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
