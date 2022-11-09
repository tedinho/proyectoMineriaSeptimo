package com.uisrael.septimo.mineria.proyecto;

public class DatosClienteUtil {

	public static void crearInsertsCliente() {
		int id = 1;
		for (int i = 0; i < 100; i++) {
			int numero = (int) (Math.random() * 200) + 1;
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO [gestion_muestras].[dbo].[cliente](");
			sql.append("[id],[correo],[estado],[nombre],[nombre_empresa],");
			sql.append("[telefono],[ruc],[tipo]) VALUES (");
			sql.append(id + ",'ejemplo_correo" + numero + "@yopmail.com',");
			sql.append("'A','" + obtenerNombreCompleto() + "','" + obtenerNombreEmpresaRandom()
					+ "','"
					+ obtenerNumero() + "',");
			sql.append("'0010000000" + id + "','I'");
			sql.append(");");
			id++;
			System.out.println(sql);
		}
	}

	public static String obtenerNombreCompleto() {
		return obtenerNombreRandom() + " " + obtenerApellidoRandom();
	}

	public static String obtenerNombreEmpresaRandom() {
		String[] nombres = { "SEID", "Zurita", "Pokem", "LabPo", "Imp", "POL", "UHJ", "OPS", "UNL", null, null };
		int numero = (int) (Math.random() * (nombres.length));
		String elegido = nombres[numero];
		if (elegido == null) {
			return "null";
		} else {
			return elegido + " Laboratorio";
		}
	}

	public static String obtenerNombreRandom() {
		String[] nombres = { "Alan", "Jacinto", "Martinez", "Alicia", "Jesús", "Mirta", "Andrea", "null", "Josefina",
				"Mónica", "Andrés", "Juan", "null", "Nicolás", "Antonia", "Juana", "null", "Noé", "Antonio", "Juárez",
				"Noelia", "Azul", "Julia", "Paula", "Bartolomé", "Julián", "Patricio", "Belén", "Juliana", "Renzo",
				"Celeste", "Julio", "Rodrigo", "Edgardo", "Leandro", "Rodríguez", "Felicia", "Luis", "Romina",
				"Florencia", "Luisa", "Rosario", "Gaspar", "Marcelo", "Tato", "Gerardo", "Marcos", "Tomás", "Giménez",
				"María", "Victor", "Gonzalo", "Mariano", "Yayo", "Gustavo", "Martín", "null", "Zulema", "null",
				"Google", "Adidas", "Mickey", "Renault", "Lego", "Superman", "Versace", "Disney", "Nilo", "Quito",
				"París", "Paraná", "Brasil", "Sucre", "Mississippi", "Argentina", "Panamá", "Everest", "Paraguay",
				"Asunción", "Aconcagua", "Bolivia", "Japón", "Marte", "Ecuador", "Rusia", "Tierra", "Chile", "América",
				"Neptuno" };
		int numero = (int) (Math.random() * (nombres.length));
		return nombres[numero];
	}

	public static String obtenerApellidoRandom() {
		String[] apellidos = { "González", "Gómez", "González", "Díaz", "González", "González", "Rodríguez", "González",
				"Gómez", "González", "Rodríguez", "null", "Rodríguez", "Fernández", "Díaz", "Rodríguez", "Rodríguez",
				"Fernández", "Martínez", "Díaz", "Fernández", "Fernández", "null", "López", "Gómez", "Díaz", "Pérez",
				"López", "Martínez", "Gómez", "López", "null", "Fernández", "Gómez", "Rodríguez", "Romero", "Flores",
				"Martínez", "López", "Lucero", "Romero", "Benítez", "Romero", "García", "null", "García", "Sosa",
				"Sánchez", "López", "Martínez", "Díaz", "null", "Pérez", "Quiroga", "Ruiz", "Ramírez", "null", "Cruz",
				"Pérez", "Muñoz", "Martínez", "Pérez", "Silva", "Fernández", "Sánchez", "Gómez" };
		int numero = (int) (Math.random() * (apellidos.length));
		return apellidos[numero];
	}

	public static String obtenerNumero() {
		int numeroUno = (int) (Math.random() * (8)) + 1;
		int numeroDos = (int) (Math.random() * (8)) + 1;
		int numerotres = (int) (Math.random() * (8)) + 1;
		int numerocuatro = (int) (Math.random() * (8)) + 1;
		int numerocinco = (int) (Math.random() * (8)) + 1;
		int numeroseis = (int) (Math.random() * (8)) + 1;
		int numerosiete = (int) (Math.random() * (8)) + 1;
		int numeroocho = (int) (Math.random() * (8)) + 1;
		int numeronueve = (int) (Math.random() * (8)) + 1;
		return numeroUno + "" + numeroDos + numerotres + numerocuatro + numerocinco + numeroseis + numerosiete
				+ numeroocho + numeronueve;
	}

}
