package com.bilgeadam.film.yonetim.sistemi.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Yonetmen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ad;
	private String soyad;
	//private Yonetmen yonetmen;
	@OneToMany(mappedBy="yonetmen")
	private List<Film> filmleri;
}
