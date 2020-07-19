package io.gitlab.leneuma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("").password(encoder().encode("")).roles("")
                .and()
                .withUser("").password(encoder().encode("")).roles("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .exceptionHandling()

                // Status 401 senden, wenn der Request nicht authentifiziert ist
                .authenticationEntryPoint((r, response, e) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))

                .and()

                // alle statischen Frontend-Resourcen ohne Authentifizierung freigeben
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/favicon.ico", "/static/**")
                .permitAll()

                // alle anderen Requests auf /api müssen authentifiziert sein
                .antMatchers("/api/**").authenticated()

                .and()

                // Route "/login" aktivieren
                .formLogin().loginPage("/auth/login")

                // Status 200 senden, wenn der Login erfolgreich war
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                })

                // Status 401 senden, wenn der Authentifizierung fehlgeschlagen ist
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())

                .and()

                // Route "/logout" aktivieren
                .logout()

                // Status 200 senden, wenn der Logout erfolgreich war
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                });
    }

}

