package com.bilgeadam.film.yonetim.sistemi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bilgeadam.film.yonetim.sistemi.entity.Film;


@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		Film f = new Film(0, "Tarzan", LocalDate.of(2000, Month.APRIL, 30), BigDecimal.valueOf(123456.12),null);
//		Film f2 = Film.builder()
//				.ad("Hulk")
//				.vizyonTarihi(LocalDate.now())
//				.hasilat(BigDecimal.valueOf(345678.89))
//				.build();
	}

}
