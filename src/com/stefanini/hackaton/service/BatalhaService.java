package com.stefanini.hackaton.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.HeroiDTO;
import com.stefanini.hackaton.entities.Heroi;
import com.stefanini.hackaton.parsers.HeroiParserDTO;
import com.stefanini.hackaton.persistence.HeroiDAO;
import com.stefanini.hackaton.persistence.JogadorDAO;

public class BatalhaService {

	@Inject
	HeroiParserDTO heroiParser;

	@Inject
	HeroiDAO heroiDAO;

	@Inject
	JogadorDAO jogadorDAO;

	List<String> log = new ArrayList<>();

// Sorteio de heroi para o Single player
	public Heroi findById(Integer id) {
		return heroiDAO.findById(id);
	}

	public String batalhar(Integer id1, Integer id2) {

		HeroiDTO boot = new HeroiDTO();
		HeroiDTO player = new HeroiDTO();
		String vencedor = null;

		Random attAleatorio = new Random();
		if (id2 == 0)
			id2 = attAleatorio.nextInt(249);

		player = heroiParser.toDTO(heroiDAO.findById(id1));
		boot = heroiParser.toDTO(heroiDAO.findById(id2));

		int rodada = 0;
		log.add("Batalha entre " + player.getNome() + " e " + boot.getNome());
		while (player.getVida() > 1500000 || boot.getVida() > 1500000) {
			rodada++;
			log.add("============= " + "Rodada " + rodada + " =============");
			if (player.getAtaque() > boot.getAtaque() || player.getDefesa() > boot.getDefesa()) {
				player.setForca(attAleatorio.nextInt(150));
				player.setAtaque(attAleatorio.nextInt(150));

				boot.setVida(boot.getVida() - (player.combar() + 100000));
				boot.setVida((boot.getVida() - (player.atacar() + 50000)));

				log.add(player.getNome() + " deu um combo no " + boot.getNome());
			} else {
// Algoritmo que torna o heroi mais forte ou mais fraco
				boot.setAtaque(attAleatorio.nextInt(150));
				boot.setForca(attAleatorio.nextInt(150));

// Algoritmo que faz o ataque
				player.setVida(player.getVida() - boot.combar() + 150000);
				player.setVida((player.getVida() - (boot.atacar() + 150000)));

				log.add(boot.getNome() + " Golpeou " + player.getNome());

			}

//Algoritmo que faz o que tiver mais inteligencia ter vantagem
			if ((boot.getInteligencia() >= player.getInteligencia() || boot.getForca() >= player.getForca())
					|| player.getInteligencia() >= boot.getInteligencia() || player.getForca() <= boot.getForca()
					|| player.getDefesa() >= boot.getDefesa()) {

				log.add(boot.getNome() + "Aumentou INTELIGÊNCIA e FORCA");
				boot.setInteligencia(attAleatorio.nextInt(200));
				boot.setForca(attAleatorio.nextInt(200));

				log.add(player.getNome() + "Aumentou INTELIGÊNCIA e FORCA");
				player.setInteligencia(attAleatorio.nextInt(200));
				player.setForca(attAleatorio.nextInt(200));

				log.add(boot.getNome() + " apelou no combate  " + player.getNome());
				boot.setVida(boot.getVida() - (player.combar() + 150000));

				log.add(player.getNome() + " esquivou de " + boot.getNome() + " usando sua astúcia");
				player.setVida(player.getVida() - (boot.combar() + 150000));
				player.setVida(player.getVida() + 10000);

				if (player.getInteligencia() > boot.getInteligencia()) {
					boot.setVida(boot.getVida() - (player.combar() + 150000));
				}

			} else {
				player.setAtaque(attAleatorio.nextInt(200));
				boot.setAtaque(attAleatorio.nextInt(200));

				log.add(player.getNome() + " e " + boot.getNome()
						+ " up of the power");
				boot.setVida(boot.getVida() - (player.atacar() + 250000));
				player.setVida(player.getVida() - (boot.atacar() + 250000));
			}

			log.add(player.getNome() + " e " + boot.getNome()
					+ " PORRAAADAAAAAA ! ! !");
			player.setVida((player.getVida() - (boot.atacar() + 250000)));
			boot.setVida(boot.getVida() - (player.combar() + 250000));
			player.setVida(player.getVida() - (boot.combar() + 250000));

		}

		System.out.println("Fight entre " + player.getNome() + " e " + boot.getNome());

		if (player.getVida() == boot.getVida() || player.getAtaque() == boot.getAtaque()
				|| player.getInteligencia() == boot.getInteligencia() || player.getNome().equals(boot.getNome())) {
			return "Deu empate, briga de cumadi...";
		}

		if (player.getVida() > boot.getVida() || player.getAtaque() > boot.getAtaque()
				|| player.getInteligencia() > boot.getInteligencia()) {
			vencedor = player.getNome();
			return ("O Herói " + vencedor + " venceu !");
		}
		if (boot.getVida() > player.getVida() || boot.getAtaque() > player.getAtaque()
				|| boot.getInteligencia() > player.getInteligencia()) {
			vencedor = boot.getNome();
			return "O Herói " + vencedor + " venceu!";
		}

		return vencedor;

	}

	public List<String> getLog() {
		return log;
	}

}
