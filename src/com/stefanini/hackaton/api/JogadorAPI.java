package com.stefanini.hackaton.api;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.LoginDTO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.BatalhaService;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Consumes(MediaType.APPLICATION_JSON)

public class JogadorAPI {

	private Map<String, List<String>> resultado = new HashMap<>();

	@Inject
	private JogadorService jogadorService;

	@Inject
	private BatalhaService batalhaService;

	@POST
	public Response save(LoginDTO dto) throws NegocioException {
		if (dto.getSenha().length() < 6 || dto.getSenha().length() > 8) {
			throw new NegocioException("A senha deve ter entre 6 e 8 caracteres");
		} else {
			// Base64
			String encodedString = Base64.getEncoder().encodeToString(dto.getSenha().getBytes());
			dto.setSenha(encodedString);
			jogadorService.save(dto);
			dto.setNickname(dto.getNickname());
			return Response.ok(dto).build();
		}
	}

	@GET
	public Response findAll() {
		return Response.ok(jogadorService.findAll()).build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) throws NegocioException {

		return Response.ok(jogadorService.findById(id)).build();

	}

	@POST
	@Path("/autenticar")
	public Response login(LoginDTO dto) throws NegocioException {
		return Response.ok(jogadorService.login(dto)).build();
	}

	@POST
	@Path("/batalhar/{player1}/{player2}")
	public Response batalha(@PathParam("player1") Integer player1, @PathParam("player2") Integer player2) {
		String result;

		result = batalhaService.batalhar(player1, player2);
		resultado.put(result, batalhaService.getLog());

		return Response.ok(resultado).build();
	}

}
