package com.bilgeadam.film.yonetim.sistemi.configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bilgeadam.film.yonetim.sistemi.entity.Film;
import com.bilgeadam.film.yonetim.sistemi.entity.Yonetmen;
import com.bilgeadam.film.yonetim.sistemi.repository.FilmRepository;
import com.bilgeadam.film.yonetim.sistemi.repository.YonetmenRepository;


@Configuration
public class FilmConfiguration {
	
		@Bean
		CommandLineRunner runner(FilmRepository filmRepository, YonetmenRepository yonetmenRepository) { // depency injection
			return args ->{
				
				Yonetmen yonetmen = Yonetmen.builder()
						.ad("Timur")
						.soyad("Tan")
						.build();
				
				yonetmenRepository.save(yonetmen);
				
				List<Film> ogrenciler = List.of(
						new Film(1, "Tarzan",LocalDate.of(2000, Month.FEBRUARY, 12), BigDecimal.valueOf(123456.45), yonetmen),
						new Film(2, "Hulk",LocalDate.of(2000, Month.FEBRUARY, 12), BigDecimal.valueOf(987456.32), yonetmen),
						new Film(3, "Superman",LocalDate.of(2000, Month.FEBRUARY, 12), BigDecimal.valueOf(654789.98),yonetmen)
						);
				
				filmRepository.saveAll(ogrenciler);
			};
		}


}
