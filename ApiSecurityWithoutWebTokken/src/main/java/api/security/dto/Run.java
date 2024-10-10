package api.security.dto;

import java.util.ArrayList;

public class Run {

	public static void main(String[] args) {

		Tenista t = new Tenista();
		Run r = new Run();
		Tenista[] tenistas;
// getMaximumWeight
		tenistas = r.getTennisPlayers("chile");
		System.out.println();
		System.out.println("Cantidad de tenistas chilenos: " + tenistas.length);
		t.mostrarTenistas(tenistas);
		/*
		System.out.println("\nmayores alturas: ");
		t.mostrarTenistas(t.getMaximumHeight(tenistas));
		System.out.println("\nmenores alturas: ");
		t.mostrarTenistas(t.getMinimumHeight(tenistas));
				
		System.out.println("\nmayores pesos: ");
		t.mostrarTenistas(t.getMaximumWeight(tenistas)); */
		System.out.println("\nmenores pesos: ");
		t.mostrarTenistas(t.getMinimumWeight(tenistas));
		System.out.println("\nmejor ranking: ");
		System.out.println(t.getBestTennisPlayers(tenistas));

		/*
		tenistas = r.getTennisPlayers("argentina");
		System.out.println();
		System.out.println("Cantidad de tenistas argentinos: " + tenistas.length);
		t.mostrarTenistas(tenistas);
		System.out.println("\nmayores alturas: ");
		t.mostrarTenistas(t.getMaximumHeight(tenistas));
		System.out.println("\nmenores alturas: ");
		t.mostrarTenistas(t.getMinimumHeight(tenistas));
		System.out.println("\nmayores pesos: ");
		t.mostrarTenistas(t.getMinimumWeight(tenistas));
		System.out.println("\nmenores pesos: ");
		t.mostrarTenistas(t.getMinimumWeight(tenistas));
		System.out.println("\nmejor ranking: ");
		System.out.println(t.getBestTennisPlayers(tenistas));
*/
	}

	public Tenista[] getTennisPlayers(String pais) {

		Tenista[] tenistas = null;

		if (pais.equalsIgnoreCase("chile")) {

			tenistas = new Tenista[5];

			tenistas[0] = new Tenista("chile", "alejandro tabilo", 1.88f, 75f, 21);
			tenistas[1] = new Tenista("chile", "nicolas jarry", 2.1f, 75f, 26); //90 kg
			tenistas[2] = new Tenista("chile", "christian garin", 1.85f, 85f, 116);
			tenistas[3] = new Tenista("chile", "tomas barrios", 1.91f, 88f, 160);
			tenistas[4] = new Tenista("chile", "matias soto", 1.70f, 75f, 335); // peso 75 kg
		} else if (pais.equalsIgnoreCase("argentina")) {

			tenistas = new Tenista[8];

			tenistas[0] = new Tenista("argentina", "sebastian baez", 1.70f, 70f, 23);
			tenistas[1] = new Tenista("argentina", "francisco cerundolo", 1.85f, 80f, 29);
			tenistas[2] = new Tenista("argentina", "tomas etcheverry", 1.96f, 82f, 33);
			tenistas[3] = new Tenista("argentina", "mariano navone", 1.78f, 73f, 36);
			tenistas[4] = new Tenista("argentina", "facundo diaz acosta", 1.83f, 75f, 64);
			tenistas[5] = new Tenista("argentina", "federico coria", 1.80f, 73f, 79);
			tenistas[6] = new Tenista("argentina", "camilo hugo carabelli", 1.85f, 83f, 93);
			tenistas[7] = new Tenista("argentina", "thiago agustin tirante", 1.85f, 81f, 94);
		}

		return tenistas;
	}

}

class Tenista {

	private String pais;
	private String nombre;
	private float estatura;
	private float peso;
	private int ranking;

	public Tenista() {

	}

	public Tenista(String pais, String nombre, float estatura, float peso, int ranking) {

		this.pais = pais;
		this.nombre = nombre;
		this.estatura = estatura;
		this.peso = peso;
		this.ranking = ranking;
	}

	public String getPais() {

		return this.pais;
	}

	public String getNombre() {

		return this.nombre;
	}

	public float getEstatura() {

		return this.estatura;
	}

	public float getPeso() {

		return this.peso;
	}

	public int getRanking() {
		return this.ranking;
	}

	public void setPais(String pais) {

		this.pais = pais;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public void setEstatura(float estatura) {

		this.estatura = estatura;
	}

	public void setPeso(float peso) {

		this.peso = peso;
	}

	public void setRanking(int ranking) {

		this.ranking = ranking;
	}

	public void getDate(Tenista[] tenistas) {

		for (Tenista t : tenistas)
			System.out.println(t);
	}

	public Tenista getBestTennisPlayers(Tenista[] tenistas) {

		Tenista mejorRanking = tenistas[0];

		for (Tenista t : tenistas)
			if (t.ranking < mejorRanking.ranking)
				mejorRanking = t;

		return mejorRanking;
	}

	public Tenista[] getMaximumHeight(Tenista[] tenistas) {

		Tenista[] mayoresEstaturas = null;

		int i = 0;
		float mayorEstatura = tenistas[i++].peso;
		ArrayList<Integer> estaturas = new ArrayList<Integer>();

		for (; i < tenistas.length; i++)
			if (tenistas[i].estatura >= mayorEstatura) {
				mayorEstatura = tenistas[i].estatura;

				if (mayorEstatura == tenistas[i].estatura)
					estaturas.add(i);
			}

		mayoresEstaturas = new Tenista[estaturas.size()];

		for (int j = 0; j < estaturas.size(); j++) {

			mayoresEstaturas[j] = tenistas[estaturas.get(j)];
		}

		return mayoresEstaturas;
	}

	public Tenista[] getMinimumHeight(Tenista[] tenistas) {

		Tenista[] menoresEstaturas = null;

		int i;
		float menorEstatura = tenistas[0].peso;
		ArrayList<Integer> estaturas = new ArrayList<Integer>();

		for (i = 0; i < tenistas.length; i++)
			if (tenistas[i].estatura <= menorEstatura) {
				menorEstatura = tenistas[i].estatura;

				if (menorEstatura == tenistas[i].estatura)
					estaturas.add(i);
			}

		menoresEstaturas = new Tenista[estaturas.size()];

		for (int j = 0; j < estaturas.size(); j++) {

			menoresEstaturas[j] = tenistas[estaturas.get(j)];
		}

		return menoresEstaturas;
	}

	public Tenista[] getMaximumWeight(Tenista[] tenistas) {

		Tenista[] mayoresPesos = null;

		int i = 0;
		float mayorPeso = tenistas[i++].peso;
		ArrayList<Integer> pesos = new ArrayList<Integer>();

		for (; i < tenistas.length; i++)
			if (tenistas[i].peso >= mayorPeso) {
				mayorPeso = tenistas[i].peso;

				if (mayorPeso == tenistas[i].peso)
					pesos.add(i);
			}

		if(pesos.size() > 1) {
		mayoresPesos = new Tenista[pesos.size()];

		for (int j = 0; j < pesos.size(); j++) {

			mayoresPesos[j] = tenistas[pesos.get(j)];
		}
		}
		else {
			mayoresPesos = new Tenista[1];
			mayoresPesos[0] = tenistas[i];
		}

		return mayoresPesos;
	}

	public Tenista[] getMinimumWeight(Tenista[] tenistas) {

		Tenista[] menoresPesos = null;

		int i = 0;
		float menorPeso = tenistas[i++].peso;
		ArrayList<Integer> pesos = new ArrayList<Integer>();

		for (; i < tenistas.length; i++)
			if (tenistas[i].peso <= menorPeso) {
				menorPeso = tenistas[i].peso;

				if (menorPeso == tenistas[i].peso)
					pesos.add(i);
			}

		if(pesos.size() > 1) {
		menoresPesos = new Tenista[pesos.size()];

		for (int j = 0; j < pesos.size(); j++) {

			menoresPesos[j] = tenistas[pesos.get(j)];
		}
		}
		else {
			menoresPesos = new Tenista[1];
			menoresPesos[0] = tenistas[0];
		}

		return menoresPesos;
	}

	public void mostrarTenistas(Tenista[] tenistas) {

		for (Tenista t : tenistas)
			System.out.println(t);
	}

	@Override
	public String toString() {

		return "[" + this.pais + "] => nombre: " + this.nombre + ", estatura: " + this.estatura + ", peso: " + this.peso
				+ ", ranking: " + this.ranking;
	}
}