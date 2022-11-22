/*
 * OrdenTrabajoService.java
 * Copyright (c) Saviasoft. Todos los derechos reservados.
 * 
 * 23/agosto/2022
 */
package com.uisrael.mineria.mineriadatos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.uisrael.mineria.mineriadatos.dto.FiltroDto;
import com.uisrael.mineria.mineriadatos.dto.RespuestaDto;
import com.uisrael.mineria.mineriadatos.modelo.OrdenTrabajo;
import com.uisrael.mineria.mineriadatos.repository.OrdenTrabajoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdenTrabajoService extends GenericService<OrdenTrabajo, Long> {

	@Autowired
	OrdenTrabajoRepository ordenTrabajoRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public JpaRepository<OrdenTrabajo, Long> getRepository() {
		return ordenTrabajoRepository;
	}

	@SuppressWarnings("unchecked")
	public List<RespuestaDto> primero(FiltroDto filtro) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(ot.id), cli.nombre, cli.correo FROM [gestion_muestras].[dbo].[orden_trabajo] ot ");
		sql.append("INNER JOIN gestion_muestras.dbo.cliente cli on(cli.id=ot.id_cliente) ");
		sql.append("WHERE ot.fecha_ingreso BETWEEN :fechaInicial and :fechaFin ");
		sql.append("GROUP BY cli.nombre, cli.correo; ");
		List<RespuestaDto> lista = new ArrayList<>();
		Query q = entityManager.createNativeQuery(sql.toString());
		q.setParameter("fechaInicial", filtro.getFechaInicio());
		q.setParameter("fechaFin", filtro.getFechaFin());
		List<Object[]> listaTmp = q.getResultList();
		for (Object[] fila : listaTmp) {
			RespuestaDto dto = new RespuestaDto();
			dto.setContador(fila[0] == null ? 0 : (Integer) fila[0]);
			dto.setNombre(fila[1] == null ? "" : (String) fila[1]);
			if (fila.length > 2) {
				dto.setAux(fila[2] == null ? "" : (String) fila[2]);
			}
			lista.add(dto);
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<RespuestaDto> segundo(FiltroDto filtro) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(mue.id), tm.nombre FROM [gestion_muestras].[dbo].muestra mue ");
		sql.append("INNER JOIN gestion_muestras.dbo.tipo_muestra tm on(tm.id=mue.id_tipo_muestra) ");
		sql.append("INNER JOIN gestion_muestras.dbo.muestra_orden_trabajo mot on(mue.id = mot.id_muestra) ");
		sql.append("INNER JOIN gestion_muestras.dbo.orden_trabajo ot on(mot.id_orden_trabajo = ot.id) ");
		sql.append("WHERE ot.fecha_ingreso BETWEEN :fechaInicial and :fechaFin ");
		sql.append("GROUP BY tm.nombre; ");
		List<RespuestaDto> lista = new ArrayList<>();
		Query q = entityManager.createNativeQuery(sql.toString());
		q.setParameter("fechaInicial", filtro.getFechaInicio());
		q.setParameter("fechaFin", filtro.getFechaFin());
		List<Object[]> listaTmp = q.getResultList();
		for (Object[] fila : listaTmp) {
			RespuestaDto dto = new RespuestaDto();
			dto.setContador(fila[0] == null ? 0 : (Integer) fila[0]);
			dto.setNombre(fila[1] == null ? "" : (String) fila[1]);
			if (fila.length > 2) {
				dto.setAux(fila[2] == null ? "" : (String) fila[2]);
			}
			lista.add(dto);
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<RespuestaDto> tercero(FiltroDto filtro) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(ot.id), ta.cargo, ta.area FROM [gestion_muestras].[dbo].[orden_trabajo] ot ");
		sql.append("INNER JOIN gestion_muestras.dbo.tecnico_area ta on(ta.id=ot.id_tecnico_responsable) ");
		sql.append("WHERE ot.fecha_ingreso BETWEEN :fechaInicial and :fechaFin ");
		sql.append("GROUP BY ta.cargo, ta.area;");
		List<RespuestaDto> lista = new ArrayList<>();
		Query q = entityManager.createNativeQuery(sql.toString());
		q.setParameter("fechaInicial", filtro.getFechaInicio());
		q.setParameter("fechaFin", filtro.getFechaFin());
		List<Object[]> listaTmp = q.getResultList();
		for (Object[] fila : listaTmp) {
			RespuestaDto dto = new RespuestaDto();
			dto.setContador(fila[0] == null ? 0 : (Integer) fila[0]);
			dto.setNombre(fila[1] == null ? "" : (String) fila[1]);
			if (fila.length > 2) {
				dto.setAux(fila[2] == null ? "" : (String) fila[2]);
			}
			lista.add(dto);
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<RespuestaDto> cuarto(FiltroDto filtro) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT COUNT(ot.id), ser.nombre, ser.ensayos FROM [gestion_muestras].[dbo].[muestra_orden_trabajo] mot ");
		sql.append("INNER JOIN gestion_muestras.dbo.servicio ser on(ser.id=mot.id_servicio) ");
		sql.append("INNER JOIN gestion_muestras.dbo.orden_trabajo ot on(ot.id=mot.id_orden_trabajo) ");
		sql.append("WHERE ot.fecha_ingreso BETWEEN :fechaInicial and :fechaFin ");
		sql.append("GROUP BY ser.nombre, ser.ensayos; ");
		List<RespuestaDto> lista = new ArrayList<>();
		Query q = entityManager.createNativeQuery(sql.toString());
		q.setParameter("fechaInicial", filtro.getFechaInicio());
		q.setParameter("fechaFin", filtro.getFechaFin());
		List<Object[]> listaTmp = q.getResultList();
		for (Object[] fila : listaTmp) {
			RespuestaDto dto = new RespuestaDto();
			dto.setContador(fila[0] == null ? 0 : (Integer) fila[0]);
			dto.setNombre(fila[1] == null ? "" : (String) fila[1]);
			if (fila.length > 2) {
				dto.setAux(fila[2] == null ? "" : (String) fila[2]);
			}
			lista.add(dto);
		}
		return lista;
	}

}
