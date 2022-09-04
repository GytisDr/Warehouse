package lt.warehousemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	//Disable CSRF
    	http.csrf().disable();
    	
    	http.authorizeRequests().antMatchers("/suppliers/**","/products/**")
    	.access("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll(); 
    	
    	
    	return http.build();
    }
}
