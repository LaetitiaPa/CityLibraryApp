package com.ocr.citylibraryapi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableEncryptableProperties
@SpringBootApplication
public class CitylibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitylibraryApiApplication.class, args); }

}
