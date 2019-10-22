package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.HeroiDTO;
import com.stefanini.hackaton.dto.JogadorDTO;
import com.stefanini.hackaton.entities.Jogador;

public class JogadorParserDTO extends AbstractParser<JogadorDTO, Jogador> {

	@Override
	public JogadorDTO toDTO(Jogador entity) {
		JogadorDTO jogadorDTO = new JogadorDTO();
		HeroiDTO heroiDTO = new HeroiDTO();

		heroiDTO.setAtaque(entity.getPersonagem().getAtaque());
		heroiDTO.setDefesa(entity.getPersonagem().getDefesa());
		heroiDTO.setForca(entity.getPersonagem().getForca());
		heroiDTO.setId(entity.getPersonagem().getId());
		heroiDTO.setInteligencia(entity.getPersonagem().getInteligencia());
		heroiDTO.setNome(entity.getPersonagem().getNome());
		heroiDTO.setPoder(entity.getPersonagem().getPoder());
		heroiDTO.setVelocidade(entity.getPersonagem().getVelocidade());
		heroiDTO.setVida(entity.getPersonagem().getVida());

		jogadorDTO.setId(entity.getId());
		jogadorDTO.setNickname(entity.getNickname());
		jogadorDTO.setPersonagem(heroiDTO);

		return jogadorDTO;
	}

	@Override
	public Jogador toEntity(JogadorDTO dto) {
		Jogador entity = new Jogador();
		entity.setId(dto.getId());
		entity.setNickname(dto.getNickname());

		return entity;
	}

}
