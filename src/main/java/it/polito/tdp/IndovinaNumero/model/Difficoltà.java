package it.polito.tdp.IndovinaNumero.model;

public class Difficoltà {

	public enum Livello{
		
		Facile,
		Medio,
		Difficile;
	}
	
	private int NMax;
	private int TMax;
	
	private Livello livello;

	public Difficoltà(Livello livello) {
		this.livello=livello;
		
		switch(livello) {
			case Facile: {
				this.NMax = 100;
				this.TMax = 15;
				break;
			}
			case Medio: {
				this.NMax = 100;
				this.TMax = 8;
				break;
			}
			case Difficile: {
				this.NMax = 100;
				this.TMax = 4;
				break;
			}
		}
		
	}

	@Override
	public String toString() {
		return this.livello.toString();
	}

	public int getTMax() {
		return TMax;
	}

	public void setTMax(int tMax) {
		TMax = tMax;
	}

	public int getNMax() {
		return NMax;
	}

	public void setNMax(int nMax) {
		NMax = nMax;
	}

	public Livello getLivello() {
		return livello;
	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}
	
	
	
}
