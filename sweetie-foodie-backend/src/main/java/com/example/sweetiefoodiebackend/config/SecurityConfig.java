package com.example.sweetiefoodiebackend.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception{
        http.httpBasic(Customizer.withDefaults());
        http.cors(c ->{
            CorsConfigurationSource source=
                    new CorsConfigurationSource() {
                        @Override
                        public CorsConfiguration
                            getCorsConfiguration(HttpServletRequest request) {
                            CorsConfiguration config=new CorsConfiguration();
                            config.setAllowedMethods(List.of("*"));
                            config.setAllowedOrigins(List.of("http://localhost:3000"));
                            config.setAllowCredentials(true);
                            config.setAllowedHeaders(List.of("*"));
                            config.setExposedHeaders(List.of("Authorization"));
                            return config;
                        }

                    };
            c.configurationSource(source);
        });
        http.authorizeHttpRequests(c ->{
            c.anyRequest().permitAll();
        });
        http.csrf(c -> c.disable());
        return  http.build();
    }
}
