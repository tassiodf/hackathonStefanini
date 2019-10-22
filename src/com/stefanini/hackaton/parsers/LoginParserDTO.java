package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.LoginDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.entities.Jogador;

public class LoginParserDTO extends AbstractParser<LoginDTO, Jogador> {

	@Override
	public LoginDTO toDTO(Jogador entity) {
		LoginDTO dto = new LoginDTO();
		dto.setNickname(entity.getNickname());
		dto.setSenha(entity.getSenha());
		return dto;
	}

	@Override
	public Jogador toEntity(LoginDTO dto) {
		Jogador entity = new Jogador();
		Heroi personagem = new Heroi();
		personagem.setAtaque(dto.getPersonagem().getAtaque());
		personagem.setDefesa(dto.getPersonagem().getDefesa());
		personagem.setForca(dto.getPersonagem().getForca());
		personagem.setId(dto.getPersonagem().getId());
		personagem.setInteligencia(dto.getPersonagem().getInteligencia());
		personagem.setNome(dto.getPersonagem().getNome());
		personagem.setPoder(dto.getPersonagem().getPoder());
		personagem.setVelocidade(dto.getPersonagem().getVelocidade());
		personagem.setVida(dto.getPersonagem().getVida());

		entity.setNickname(dto.getNickname());
		entity.setSenha(dto.getSenha());
		entity.setPersonagem(personagem);
		return entity;
	}

}
