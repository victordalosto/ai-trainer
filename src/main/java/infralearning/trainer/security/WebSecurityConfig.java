package infralearning.trainer.security;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.authorizeHttpRequests((req) ->
                 req.requestMatchers("/", "/css/*", "/js/*").permitAll()
                    .anyRequest().authenticated()
             ).formLogin(withDefaults());
         return http.build();
    }

}
