package com.stefanini.hackaton.service;

import java.util.Base64;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import com.stefanini.hackaton.dto.JogadorDTO;
import com.stefanini.hackaton.dto.LoginDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.HeroiParserDTO;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.parsers.LoginParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	private LoginParserDTO loginParser;

	@Inject
	private JogadorParserDTO jogadorParser;

	@Inject
	private HeroiParserDTO heroiParser;

	@Inject
	private JogadorDAO jogadorDAO;

	@Transactional
	public void save(LoginDTO dto) throws NegocioException {

		try {
			if (jogadorDAO.findByName(dto.getNickname()) != null) {
				throw new NegocioException("Esse nickname já foi escolhido, favor insira outro...");
			}
		} catch (NoResultException e) {
			jogadorDAO.insert(loginParser.toEntity(dto));
			throw new NegocioException("Cadastro realizado com sucesso! Faça seu login");
		}
	}

	public List<JogadorDTO> findAll() {
		JogadorDTO dto = new JogadorDTO();
		Heroi personagem = new Heroi();
		dto.setPersonagem(heroiParser.toDTO(personagem));

		return jogadorParser.toDTO(jogadorDAO.list());
	}

	public Jogador findById(Integer id) {
		return jogadorDAO.findById(id);
	}

	public JogadorDTO login(LoginDTO dto) throws NegocioException {
		Jogador jogador = new Jogador();

		String encodedString = Base64.getEncoder().encodeToString(dto.getSenha().getBytes());
		dto.setSenha(encodedString);
		try {
			if (jogadorDAO.findByNameSenha(dto.getNickname(), dto.getSenha()) != null)
				;
			jogador = jogadorDAO.findByNameSenha(dto.getNickname(), dto.getSenha());

			byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
			String decodedString = new String(decodedBytes);
			jogador.setSenha(decodedString);
			return jogadorParser.toDTO(jogador);
		} catch (NoResultException e) {
			throw new NegocioException("Ops! Seu nickname ou senha estão incorretos!");
		}

	}
}
