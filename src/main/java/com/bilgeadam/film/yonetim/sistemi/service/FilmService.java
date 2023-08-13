package com.bilgeadam.film.yonetim.sistemi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilgeadam.film.yonetim.sistemi.entity.Film;
import com.bilgeadam.film.yonetim.sistemi.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository filmRepository; 
	
	public List<Film> filmListesi(){
		return filmRepository.findAll();
	}

	public Optional<Film> idIleGetir(Integer id) {
		
		Optional<Film> filmById = filmRepository.findById(id);
		
		if(filmById.isEmpty()) {
			throw new IllegalStateException("verilen id ile bir film bulunamadı");
		}
		
		return filmById ;
	}

	public void yeniFilmKaydet(Film film) {
		
		Optional<Film> filmByAd =  filmRepository.findFilmByAd(film.getAd());
		
		if(filmByAd.isPresent()) {
			throw new IllegalStateException("daha önce kaydedilmiş film adı");
		}
		
		filmRepository.save(film);	
	}

	public void filmGuncelle(Integer id, String ad,LocalDate vizyonTarihi, BigDecimal hasilat) {
		
		Film film = filmRepository.findById(id).orElseThrow(()-> new IllegalStateException("verilen id ile bir film bulunamadı"));
		
		if(ad != null && ad.length() > 0) {
			film.setAd(ad);
		}
		
		if(vizyonTarihi != null) {
			film.setVizyonTarihi(vizyonTarihi);
		}
		
		if(hasilat != null) {
			film.setHasilat(hasilat);
		}
		
		filmRepository.save(film); // save metodu burada update işlemi gerçekleşir
		
	}

	public void filmGuncelle(Integer id, Film film) {
		
		Film varolanFilm = filmRepository.findById(id).orElseThrow(()-> new IllegalStateException("verilen id ile bir film bulunamadı"));
		
		//varolanFilm.setAd(film.getAd());
		
		varolanFilm = Film.builder()
				.id(id)
				.ad(film.getAd())
				.vizyonTarihi(film.getVizyonTarihi())
				.hasilat(film.getHasilat())
				.build();
		
		filmRepository.save(varolanFilm);
		
	}

	public void sil(Integer id) {
		Film varolanFilm = filmRepository.findById(id).orElseThrow(()-> new IllegalStateException("verilen id ile bir film bulunamadı"));
		
		filmRepository.delete(varolanFilm);
		
	}
}
