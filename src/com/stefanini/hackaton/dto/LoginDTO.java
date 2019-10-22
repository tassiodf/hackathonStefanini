package com.stefanini.hackaton.dto;

public class LoginDTO {

	private Integer id;
	private String nickname;
	private String senha;
	private HeroiDTO personagem;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public HeroiDTO getPersonagem() {
		return personagem;
	}
	public void setPersonagem(HeroiDTO personagem) {
		this.personagem = personagem;
	}
	
	
}
