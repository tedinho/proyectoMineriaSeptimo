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
		String[] nombres = { "Alan", "Jacinto", "Martinez", "Alicia", "Jes�s", "Mirta", "Andrea", "null", "Josefina",
				"M�nica", "Andr�s", "Juan", "null", "Nicol�s", "Antonia", "Juana", "null", "No�", "Antonio", "Ju�rez",
				"Noelia", "Azul", "Julia", "Paula", "Bartolom�", "Juli�n", "Patricio", "Bel�n", "Juliana", "Renzo",
				"Celeste", "Julio", "Rodrigo", "Edgardo", "Leandro", "Rodr�guez", "Felicia", "Luis", "Romina",
				"Florencia", "Luisa", "Rosario", "Gaspar", "Marcelo", "Tato", "Gerardo", "Marcos", "Tom�s", "Gim�nez",
				"Mar�a", "Victor", "Gonzalo", "Mariano", "Yayo", "Gustavo", "Mart�n", "null", "Zulema", "null",
				"Google", "Adidas", "Mickey", "Renault", "Lego", "Superman", "Versace", "Disney", "Nilo", "Quito",
				"Par�s", "Paran�", "Brasil", "Sucre", "Mississippi", "Argentina", "Panam�", "Everest", "Paraguay",
				"Asunci�n", "Aconcagua", "Bolivia", "Jap�n", "Marte", "Ecuador", "Rusia", "Tierra", "Chile", "Am�rica",
				"Neptuno" };
		int numero = (int) (Math.random() * (nombres.length));
		return nombres[numero];
	}

	public static String obtenerApellidoRandom() {
		String[] apellidos = { "Gonz�lez", "G�mez", "Gonz�lez", "D�az", "Gonz�lez", "Gonz�lez", "Rodr�guez", "Gonz�lez",
				"G�mez", "Gonz�lez", "Rodr�guez", "null", "Rodr�guez", "Fern�ndez", "D�az", "Rodr�guez", "Rodr�guez",
				"Fern�ndez", "Mart�nez", "D�az", "Fern�ndez", "Fern�ndez", "null", "L�pez", "G�mez", "D�az", "P�rez",
				"L�pez", "Mart�nez", "G�mez", "L�pez", "null", "Fern�ndez", "G�mez", "Rodr�guez", "Romero", "Flores",
				"Mart�nez", "L�pez", "Lucero", "Romero", "Ben�tez", "Romero", "Garc�a", "null", "Garc�a", "Sosa",
				"S�nchez", "L�pez", "Mart�nez", "D�az", "null", "P�rez", "Quiroga", "Ruiz", "Ram�rez", "null", "Cruz",
				"P�rez", "Mu�oz", "Mart�nez", "P�rez", "Silva", "Fern�ndez", "S�nchez", "G�mez" };
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
