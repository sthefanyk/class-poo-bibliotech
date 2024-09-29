package com.github.sthefanyk.bibliotech.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class H2Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public void createTable() {
        try {
            Resource resource = resourceLoader.getResource("classpath:schema.sql");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            
            String sql = reader.lines().collect(Collectors.joining(" "));
            
            jdbcTemplate.execute(sql);
            
            System.out.println("Tabelas criadas com sucesso a partir do arquivo schema.sql!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
