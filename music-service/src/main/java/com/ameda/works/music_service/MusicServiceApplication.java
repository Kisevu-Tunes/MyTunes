package com.ameda.works.music_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ameda.works.*","org.springdoc"})
public class MusicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicServiceApplication.class, args);
	}

}
