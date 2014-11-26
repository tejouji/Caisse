package fr.uha.miage.caisse.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import fr.uha.miage.caisse.model.Employe;
import fr.uha.miage.caisse.repository.EmployeRepository;

@EnableWebSecurity
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest()
				.authenticated();
		http.csrf().disable();
		http.formLogin().loginPage("/login").usernameParameter("login")
				.passwordParameter("pwd").permitAll().and().logout()
				.logoutUrl("/bye").logoutSuccessUrl("/").permitAll();

	}

	@Configuration
	protected static class AuthenticationConfiguration extends
			GlobalAuthenticationConfigurerAdapter {
		@Autowired
		EmployeRepository employeRepository;

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {

			employeRepository.save(new Employe("Benkhabcheche", "tedj",
					"02/04/1989", "Homme", "077777", "b.tedj@gmail.com",
					"mulhouse", "test",null));
			employeRepository.save(new Employe("BenAttouche", "Mohamed",
					"12/03/1989", "Homme", "05555", "b.med@gmail.com",
					"mulhouse", "test",null));

			ArrayList<Employe> listE = (ArrayList<Employe>) employeRepository
					.findAll();

			for (Employe employe : listE) {
				auth.inMemoryAuthentication().withUser(employe.getPre_emp())
						.password(employe.getMp_emp()).roles("ADMIN");
				

			}

			System.out.println("oui");
		}
		  
	
	}
	
	
}
