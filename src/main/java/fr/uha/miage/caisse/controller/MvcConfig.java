package fr.uha.miage.caisse.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/caisse").setViewName("caisse");
        registry.addViewController("/").setViewName("caisse");
        registry.addViewController("/employe").setViewName("employe");
        registry.addViewController("/client").setViewName("client");
        registry.addViewController("/fichepd").setViewName("fichepd");
        registry.addViewController("/newcat").setViewName("newcat");
        registry.addViewController("/login").setViewName("login");
    }

}
