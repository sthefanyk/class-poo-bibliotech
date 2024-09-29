package com.github.sthefanyk.bibliotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.sthefanyk.bibliotech.controllers.BookController;

@SpringBootApplication
public class BibliotechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotechApplication.class, args);

		BookController bookController = AppInitializer.initialize();
	}

}
