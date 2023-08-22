package com.bilgeadam.film.yonetim.sistemi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.film.yonetim.sistemi.entity.Film;
import com.bilgeadam.film.yonetim.sistemi.service.FilmService;

@RestController
@RequestMapping(path="api/v1/film")
@CrossOrigin(origins = "http://127.0.0.1:5500") // CORS hatasını gidermek için
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public List<Film> getFilmler() {
		return filmService.filmListesi();
	}
	
	@GetMapping//(path="{id}")
	@RequestMapping("{id}")
	public Film getFilm(@PathVariable("id") Integer id) {
		return filmService.idIleGetir(id).get();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity yeniFilmEkle(@RequestBody Film film) { // body içinde gelen veri JSON formatında olacak, Spring fw JSON dan Film nesnesine çevirecek
		
		try {
			filmService.yeniFilmKaydet(film);
		} catch (IllegalStateException e) {
			return new ResponseEntity<Film>(film, HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<Film>(film, HttpStatus.CREATED);
	}
	
	
	@PutMapping(path="{id}")
	public void filmGuncelle(@PathVariable("id") Integer id, @RequestBody final Film film) {
		filmService.filmGuncelle(id, film);
	}
	
	@DeleteMapping(path="{id}")
	public void filmSil(@PathVariable("id") Integer id) {
		filmService.sil(id);
	}
//	@PutMapping(path="{id}")
//	public void filmGuncelle(@PathVariable("id") Integer id,
//			@RequestParam(required=false) String ad,
//			@RequestParam(required=false) LocalDate vizyonTarihi,
//			@RequestParam(required=false) BigDecimal hasilat
//			) {
//		filmService.filmGuncelle(id, ad, vizyonTarihi, hasilat);
//	}
	
	
	

}
