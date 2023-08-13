package com.bilgeadam.film.yonetim.sistemi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bilgeadam.film.yonetim.sistemi.entity.Film;
@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
	Optional<Film> findFilmByAd(String ad);
}
