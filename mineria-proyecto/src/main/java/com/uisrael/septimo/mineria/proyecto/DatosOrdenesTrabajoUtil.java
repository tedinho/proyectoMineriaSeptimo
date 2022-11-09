package com.uisrael.septimo.mineria.proyecto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DatosOrdenesTrabajoUtil {

	public static void crearInserts() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		int idOrden = 1;
		int idMuestra = 1;
		int idDetalle = 1;

		List<String> scriptsOrdenes = new ArrayList<String>();
		List<String> scriptsMuestras = new ArrayList<String>();
		List<String> scriptsDetalles = new ArrayList<String>();

		for (int index = 0; index < 100; index++) {
			int cantidad = (int) (Math.random() * 5) + 1;
			LocalDate fecha = obtenerFechaRandon();
			String fechaIngreso = formatter.format(fecha);
			String fechaRecoleccion = formatter.format(obtenerFechaRecoleccionRandon(fecha.toEpochDay()));
			String numero = obtenerNumero();
			BigDecimal subTotal = obtenerSubTotal().setScale(2, RoundingMode.HALF_UP);
			BigDecimal iva = obtenerIva(subTotal).setScale(2, RoundingMode.HALF_UP);
			BigDecimal total = subTotal.add(iva).setScale(2, RoundingMode.HALF_UP);
			int idCliente = (int) (Math.random() * 99);
			if (idCliente == 0) {
				idCliente = 1;
			}
			int idTecnico = (int) (Math.random() * 29);
			if (idTecnico == 0) {
				idTecnico = 1;
			}
			String condicion = obtenerCondicionRandom();
			String estado = obtenerEstadoRandom();
			String presentacion = obtenerPresentacionRandom();
			String ubicacion = obtenerUbicacionRandom();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO [gestion_muestras].[dbo].[orden_trabajo](");
			sql.append("[id],[cantidad],[condicion_almacenamiento]");
			sql.append(",[estado],[fecha_ingreso],[fecha_recoleccion],[iva]");
			sql.append(",[numero],[presentacion_llegada],[sub_total],[total]");
			sql.append(",[ubicacion_temporal],[id_cliente],[id_tecnico_responsable]");
			sql.append(") VALUES(");
			sql.append(idOrden + "," + cantidad + ",'" + condicion + "'");
			sql.append(",'" + estado + "','" + fechaIngreso + "','" + fechaRecoleccion + "'," + iva);
			sql.append(",'" + numero + "','" + presentacion + "'," + subTotal + "," + total);
			sql.append(",'" + ubicacion + "'," + idCliente + "," + idTecnico);
			sql.append(");");

			scriptsOrdenes.add(sql.toString());

			String codigoMuestra = obtenerCodigoMuestra();
			String nombreMuestra = obtenerNombreMuestra();
			String temperatura = obtenerTemperatura();
			String fechaElimina = formatter.format(obtenerFechaRecoleccionRandon(fecha.toEpochDay()));
			int idTipo = (int) (Math.random() * 22);

			if (idTipo == 0) {
				idTipo = 1;
			}

			StringBuilder sqlMuestra = new StringBuilder();
			sqlMuestra.append("INSERT INTO [gestion_muestras].[dbo].[muestra](");
			sqlMuestra.append("[id],[cantidad],[codigo_muestra],[condicion_almacenamiento]");
			sqlMuestra.append(",[estado],[fecha_elimina],[fecha_ingreso]");
			sqlMuestra.append(",[fecha_recoleccion],[nombre],[proceso_muestra]");
			sqlMuestra.append(",[temperatura],[ubicacion_temporal],[id_cliente]");
			sqlMuestra.append(",[id_tipo_muestra]) VALUES(");
			sqlMuestra.append(idMuestra + "," + cantidad + ",'" + codigoMuestra + "','" + condicion + "'");
			sqlMuestra.append(",'A','" + fechaElimina + "','" + fechaIngreso + "'");
			sqlMuestra.append(",'" + fechaRecoleccion + "','" + nombreMuestra + "','I'");
			sqlMuestra.append(",'" + temperatura + "','" + ubicacion + "'," + idCliente);
			sqlMuestra.append("," + idTipo);
			sqlMuestra.append(");");

			scriptsMuestras.add(sqlMuestra.toString());

			int detalles = (int) (Math.random() * 5) + 1;
			for (int i = 0; i < detalles; i++) {
				int idServicio = (int) (Math.random() * 80);
				if (idServicio == 0) {
					idServicio = 1;
				}
				int idTecnicoDetalle = (int) (Math.random() * 29);
				if (idTecnicoDetalle == 0) {
					idTecnicoDetalle = 1;
				}
				StringBuilder sqlDetalle = new StringBuilder();
				sqlDetalle.append("INSERT INTO [gestion_muestras].[dbo].[muestra_orden_trabajo](");
				sqlDetalle.append("[id],[cantidad],[id_muestra]");
				sqlDetalle.append(",[id_orden_trabajo],[id_servicio],[id_tecnico_area])");
				sqlDetalle.append(" VALUES(");
				sqlDetalle.append(idDetalle + "," + cantidad + "," + idMuestra);
				sqlDetalle.append("," + idOrden + "," + idServicio + "," + idTecnicoDetalle);
				sqlDetalle.append(");");
				idDetalle++;
				scriptsDetalles.add(sqlDetalle.toString());
			}
			idMuestra++;
			idOrden++;
		}

		System.out.println("------------------------------------------ Ordenes");
		for (String string : scriptsOrdenes) {
			System.out.println(string);
		}

		System.out.println("------------------------------------------ Muestras");
		for (String string : scriptsMuestras) {
			System.out.println(string);
		}

		System.out.println("------------------------------------------ OrdenesMuestra");
		for (String string : scriptsDetalles) {
			System.out.println(string);
		}

	}

	public static String obtenerNombreMuestra() {
		String[] muestras = { "Chifles", "CHONTACUROS", "covid hijo", "covid hijo 2", "covid hijo 3", "covid hijo 4",
				"covid hijo 5", "covid nieto", "covid nieto 2", "HISOPADOS ENCIAS", "Hojarasca colectada",
				"lavado nasal cuyes", "N1", "Ortiga", "otra muestra hijo", "otro otro", "Producto de PCR",
				"PRODUCTOS DE PCR", "PRODUCTOS DE PCR- ADN CANCER", "PRODUCTOS DE PCR- ADN CANCER HUMANO",
				"Productos de PCR-ADN de Platano", "Productos de PCR-ARN SARS-CoV-2", "Sedimentos Cotopaxi",
				"Sueros de Vacas de Pichincha ", "Sueros Pacientes COVID-19 a los 15 dias.", "tr" };
		int pos = (int) (Math.random() * muestras.length);
		return muestras[pos];
	}

	public static String obtenerTemperatura() {
		String[] temp = { "menos de 0°", "entre 0° y 10°", "entre 11° y 20°", "mas de 21°" };
		int pos = (int) (Math.random() * temp.length);
		return temp[pos];
	}

	public static String obtenerUbicacionRandom() {
		int pos = (int) (Math.random() * 300);
		return "Refrigeradora-" + pos;
	}

	public static String obtenerPresentacionRandom() {
		String[] opciones = { "Funda", "Isopo", "Tubo", "Frasco" };
		int pos = (int) (Math.random() * opciones.length);
		return opciones[pos];
	}

	public static String obtenerEstadoRandom() {
		String[] estados = { "NUEVA", "APROBADA", "INFORME", "FINALIZADA" };
		int pos = (int) (Math.random() * estados.length);
		return estados[pos];
	}

	public static String obtenerCondicionRandom() {
		String[] condiciones = { "REFRIGERADO", "CONGELADO", "TRIZADO", "CALCINADO", "ASOLEADO", "HUMEDO", "MOJADO" };
		int pos = (int) (Math.random() * condiciones.length);
		return condiciones[pos];
	}

	public static LocalDate obtenerFechaRandon() {
		long minDay = LocalDate.of(2021, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2022, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}

	public static LocalDate obtenerFechaRecoleccionRandon(Long minDay) {
		long maxDay = LocalDate.of(2022, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}

	public static LocalDate obtenerFechaEliminaRandon(Long minDay) {
		long maxDay = LocalDate.of(2025, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		return LocalDate.ofEpochDay(randomDay);
	}

	public static String obtenerNumero() {
		String[] cod = { "QG", "BQ", "MB" };
		int pos = (int) (Math.random() * cod.length);
		int numero = (int) (Math.random() * 2000) + 1;
		return cod[pos] + "-" + numero;
	}

	public static String obtenerCodigoMuestra() {
		int numero = (int) (Math.random() * 2000) + 1;
		return "Muestra" + "-" + numero;
	}

	public static BigDecimal obtenerSubTotal() {
		return BigDecimal.valueOf((int) (Math.random() * 2000) + 1);
	}

	public static BigDecimal obtenerIva(BigDecimal subTotal) {
		return subTotal.multiply(new BigDecimal(0.12));
	}

}
