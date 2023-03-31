package br.com.attornatus.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.attornatus.services.impl.DbServiceImpl;



@Configuration
public class Config {

	@Autowired
	private DbServiceImpl dbServiceImpl;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbServiceImpl.instantiateTestDatabase();
		return true;
	}
	

}
