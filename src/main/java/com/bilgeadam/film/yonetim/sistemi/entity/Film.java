package com.bilgeadam.film.yonetim.sistemi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// lombok
@Data // getter setter yazmaktan kurtarır
@AllArgsConstructor
@NoArgsConstructor
@Builder // nesnesini kolay oluşturmak için
@Entity
@ToString
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	@NotNull
	private String ad;
	private LocalDate vizyonTarihi;
	@Min(10000)
	private BigDecimal hasilat;
	
	@ManyToOne
	private Yonetmen yonetmen;

	public Film(Integer id,@NotEmpty @NotNull String ad, LocalDate vizyonTarihi, @Min(10000) BigDecimal hasilat) {
		this.id = id;
		this.ad = ad;
		this.vizyonTarihi = vizyonTarihi;
		this.hasilat = hasilat;
	}
}
