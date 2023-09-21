package com.backend.clinicaodontologica.security.config;

import com.backend.clinicaodontologica.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UsuarioService usuarioService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfiguration(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/turnos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/pacientes/**", "/odontologos/**").hasRole("ADMIN")
                //todas las demas requieren autenticacion
                .anyRequest()
                .authenticated()
                .and()
                //tipo de autenticacion a usar
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //configura el servicio que carga los datos del usuario durante la autenticacion
        auth.userDetailsService(usuarioService);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        //crea y configura el proveedor de autenticacion con el encoder para almacenar y verificar de forma segura las contraseñas
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }


}
