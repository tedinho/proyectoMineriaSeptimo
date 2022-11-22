package com.uisrael.mineria.mineriadatos.controller;

import java.util.List;
import java.util.Map;

import com.uisrael.mineria.mineriadatos.dto.FiltroDto;
import com.uisrael.mineria.mineriadatos.dto.RespuestaDto;
import com.uisrael.mineria.mineriadatos.response.HttpResponse;
import com.uisrael.mineria.mineriadatos.service.OrdenTrabajoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping(path = "/orden-trabajo")
@CrossOrigin(origins = "*")
public class OrdenTrabajoController {

	@Autowired
	private OrdenTrabajoService ordenTrabajoService;

	public static final String NO_ENCONTRADO = "No existen registros";

	public static final String NO_SUBIO = "El archivo no se cargo de manera correcta";

	@PostMapping(path = "/primero", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> primero(@RequestBody FiltroDto filtro) {
		HttpResponse response = new HttpResponse();
		String code = String.valueOf(HttpStatus.NOT_FOUND.value());
		String status = HttpStatus.NOT_FOUND.name();
		String message = NO_ENCONTRADO;
		List<RespuestaDto> lista = ordenTrabajoService.primero(filtro);
		if (lista != null && !lista.isEmpty()) {
			code = String.valueOf(HttpStatus.OK.value());
			message = "";
			status = HttpStatus.OK.name();
			return response.sendResponse(code, status, message, lista);
		}
		return response.sendResponse(code, status, message, lista);
	}

	@PostMapping(path = "/segundo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> segundo(@RequestBody FiltroDto filtro) {
		HttpResponse response = new HttpResponse();
		String code = String.valueOf(HttpStatus.NOT_FOUND.value());
		String status = HttpStatus.NOT_FOUND.name();
		String message = NO_ENCONTRADO;
		List<RespuestaDto> lista = ordenTrabajoService.segundo(filtro);
		if (lista != null && !lista.isEmpty()) {
			code = String.valueOf(HttpStatus.OK.value());
			message = "";
			status = HttpStatus.OK.name();
			return response.sendResponse(code, status, message, lista);
		}
		return response.sendResponse(code, status, message, lista);
	}

	@PostMapping(path = "/tercero", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> tercero(@RequestBody FiltroDto filtro) {
		HttpResponse response = new HttpResponse();
		String code = String.valueOf(HttpStatus.NOT_FOUND.value());
		String status = HttpStatus.NOT_FOUND.name();
		String message = NO_ENCONTRADO;
		List<RespuestaDto> lista = ordenTrabajoService.tercero(filtro);
		if (lista != null && !lista.isEmpty()) {
			code = String.valueOf(HttpStatus.OK.value());
			message = "";
			status = HttpStatus.OK.name();
			return response.sendResponse(code, status, message, lista);
		}
		return response.sendResponse(code, status, message, lista);
	}

	@PostMapping(path = "/cuarto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> cuarto(@RequestBody FiltroDto filtro) {
		HttpResponse response = new HttpResponse();
		String code = String.valueOf(HttpStatus.NOT_FOUND.value());
		String status = HttpStatus.NOT_FOUND.name();
		String message = NO_ENCONTRADO;
		List<RespuestaDto> lista = ordenTrabajoService.cuarto(filtro);
		if (lista != null && !lista.isEmpty()) {
			code = String.valueOf(HttpStatus.OK.value());
			message = "";
			status = HttpStatus.OK.name();
			return response.sendResponse(code, status, message, lista);
		}
		return response.sendResponse(code, status, message, lista);
	}

}
