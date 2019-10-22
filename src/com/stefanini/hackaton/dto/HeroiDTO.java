package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class HeroiDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ataque;
	private Integer defesa;
	private Integer id;
	private Integer inteligencia;
	private String nome;
	private Integer poder;
	private Integer velocidade;
	private Integer forca;
	private Integer vida;

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPoder() {
		return poder;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	// métodos de ataque
	public Integer atacar() {
		Integer ataque;
		ataque = this.inteligencia + this.ataque + this.defesa;
		if (ataque == 0)
			ataque = 45;
		return ataque;
	}

	public Integer combar() {
		Integer hits;
		hits = this.forca + this.defesa + this.poder + this.inteligencia + this.ataque;
		if (hits == 0)
			hits = 150;
		return hits;
	}

}
