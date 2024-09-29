package com.github.sthefanyk.bibliotech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.sthefanyk.bibliotech.database.H2Database;

@SpringBootApplication
public class BibliotechApplication implements CommandLineRunner {
	
	@Autowired
	private H2Database h2Database;

	public static void main(String[] args) {
		SpringApplication.run(BibliotechApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        h2Database.createTable();
    }
}
