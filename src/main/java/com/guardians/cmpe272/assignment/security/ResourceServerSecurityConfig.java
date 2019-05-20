package com.guardians.cmpe272.assignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class ResourceServerSecurityConfig extends ResourceServerConfigurerAdapter {
   //@Value("http://walk/api")
   //private String resourceId;
   
   @Autowired
   private Environment env;

   @Override
   public void configure(HttpSecurity http) throws Exception {
       http.cors().and().authorizeRequests()
           // .mvcMatchers("/api/public").permitAll()
           // .antMatchers("/api/private-scoped").access("#oauth2.hasScope('read:messages')")
           .mvcMatchers("/api/**").authenticated()
           .mvcMatchers("/bookorder/**").authenticated()
           .anyRequest().permitAll();
   }

   @Override
   public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
       resources.resourceId(env.getProperty("security.oauth2.resource.id"));
   }
}
