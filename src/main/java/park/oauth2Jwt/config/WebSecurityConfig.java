package park.oauth2Jwt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF, 기본 HTTP 인증 설정 비활성화. security6 형식으로 작성.
        http.csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.disable());

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/api/signup")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/**")).authenticated()
                .anyRequest().permitAll());
        return http.build();
    }
}
