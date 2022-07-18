package com.bitirmeprojesi.eticaret;

import com.bitirmeprojesi.eticaret.entity.Role;
import com.bitirmeprojesi.eticaret.entity.User;
import com.bitirmeprojesi.eticaret.model.request.CategoryRequest;
import com.bitirmeprojesi.eticaret.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class EticaretApplication {

	public static void main(String[] args) {
		SpringApplication.run(EticaretApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	//@Bean
	//CommandLineRunner run(UserService userService){
	//	return args -> {
	//		userService.saveRole(new Role(null,"ROLE_USER"));
	//		userService.saveRole(new Role(null,"ROLE_ADMIN"));
	//
	//		userService.saveUser(new User("*****","*****@gmail.com","***","***","***","***",true));
	//		userService.saveUser(new User("*****","*****@gmail.com","***","***","***","***"));
	//		userService.saveUser(new User("*****","******@gmail.com","***","***","***","***"));
	//
	//		userService.addRoleToUser("****","ROLE_ADMIN");
	//
	//
	//	};
	//
	//}

}
