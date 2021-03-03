package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
//		ApplicationContext springContainer = 
				SpringApplication.run(ProductsApplication.class, args);
		
//		ProductConsoleUI ui = new ProductConsoleUI(); // DO NOT DO THIS, don't create your own instances. use the ones created by spring
		
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
	}

}
