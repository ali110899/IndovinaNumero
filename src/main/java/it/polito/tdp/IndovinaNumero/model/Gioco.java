package it.polito.tdp.IndovinaNumero.model;

public class Gioco {
	
	public enum OutcomeGioco {

		Vinto,
		Perso, 
		TroppoAlto,
		TroppoBasso
	}

	//Dati funzionamento Applicazione
	private int TMax;
	private int NMax;
	private int NTentativiFatti;
	private int numeroSegreto;
	
	public void IniziaGioco(Difficoltà livello) {

		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
    
	}
	
	
	public OutcomeGioco giocoFaiTentativo(int tentativo ) {
		this.NTentativiFatti++;
		
		// Caso:0 Vittoria(return 0)
		if(tentativo==this.numeroSegreto) {
			return OutcomeGioco.Vinto;
		
    	}
    	// Caso :1 Perso(return 1)
    	if(this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	
    	// caso:2-3 Non indovinato, ritenta (return 2-3)
    	if(tentativo>this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto;
    	} else {
    		return OutcomeGioco.TroppoBasso;
    	}
		
	}
	
	
	/* Soluzione facile 
	public int giocoFaiTentativo(int tentativo ) {
		this.NTentativiFatti++;
		
		// Caso:0 Vittoria(return 0)
		if(tentativo==this.numeroSegreto) {
			return 0;
		
    	}
    	// Caso :1 Perso(return 1)
    	if(this.NTentativiFatti == this.TMax) {
    		return 1;
    	}
    	
    	// caso:2-3 Non indovinato, ritenta (return 2-3)
    	if(tentativo>this.numeroSegreto) {
    		return 2;
    	} else {
    		return 3;
    	}
		
	}
	*/

	public int getNTentativiFatti() {
		return NTentativiFatti;
	}

	public void setNTentativiFatti(int nTentativiFatti) {
		NTentativiFatti = nTentativiFatti;
	}

	public int getNumeroSegreto() {
		return numeroSegreto;
	}

	public void setNumeroSegreto(int numeroSegreto) {
		this.numeroSegreto = numeroSegreto;
	}

	public int getTMax() {
		return TMax;
	}

	public int getNMax() {
		return NMax;
	}
	
	
}
