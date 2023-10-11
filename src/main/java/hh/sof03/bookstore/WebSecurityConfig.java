package hh.sof03.bookstore;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	@Autowired
    private UserDetailsService userDetailsService;	
	
	 @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	      http
	      .authorizeHttpRequests( authorize -> authorize
	        	.requestMatchers(antMatcher("/css/**")).permitAll()
	        	.requestMatchers(toH2Console()).permitAll()
	        	.anyRequest().authenticated()
	      )
	      .csrf(csrf -> csrf
	              .ignoringRequestMatchers(toH2Console())
	         )
	         .headers(headers -> headers
	             .frameOptions(frameoptions -> frameoptions
	                      .disable())
	         )
	      .formLogin(form -> form.loginPage("/login")
	          .defaultSuccessUrl("/booklist", true)
	          .permitAll()
	      )
	      .logout(logout -> logout
	          .permitAll()
	      );
	      return http.build();
	    }

	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }

	}
