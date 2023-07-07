/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.IndovinaNumero.model.Difficoltà;
import it.polito.tdp.IndovinaNumero.model.Gioco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ComboBox;

public class FXMLController {
	
	private Gioco model; //non possiamo creare model qua dentro!
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="btnPRova"
    private Button btnPRova; // Value injected by FXMLLoader

    @FXML // fx:id="txtCom"
    private TextArea txtCom; // Value injected by FXMLLoader

    @FXML // fx:id="txtNMax"
    private TextField txtNMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtProva"
    private TextField txtProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="txtTMax"
    private TextField txtTMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader
    
    @FXML // fx:id="barTentativi"
    private ProgressBar barTentativi; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Difficoltà> comboDifficolta;
    
    @FXML
    void doNuovaPartita(ActionEvent event) {
    	//reset del gioco
    
    	Difficoltà livello = comboDifficolta.getValue();
    	model.IniziaGioco(livello);
    	
    	//aggiornamenti interfaccia grafica
    	this.txtTentativi.setText( Integer.toString(this.model.getTMax()-this.model.getNTentativiFatti()) );
    	this.txtNMax.setText(Integer.toString(this.model.getNMax()) );
    	this.txtTMax.setText(Integer.toString(this.model.getTMax()));
//    	this.txtRisultato.setText(Integer.toString(numeroSegreto));
    	
    	this.btnPRova.setDisable(false);
    	this.txtRisultato.clear();
    	this.txtProva.clear();
    	this.txtCom.clear();
    	
    	this.barTentativi.setProgress(0);

    }

    @FXML
    void doProva(ActionEvent event) {
    	
    	//leggere numero scelto
    	int guess;
    	try {
    		guess = Integer.parseInt(this.txtProva.getText());
    	}catch(NumberFormatException e) {
    		this.txtCom.setText("inserire un numero!");
    		return;
    	}
    	
    	//fare controlli sul numero
    	
    	//chiamare modello per effettuare tentativo 
    	Gioco.OutcomeGioco risultato = this.model.giocoFaiTentativo(guess);
    	//int risultato = this.model.giocoFaiTentativo(guess);
    	
    	//aggiornamenti interfaccia grafico
    	this.txtTentativi.setText( Integer.toString(this.model.getTMax()-this.model.getNTentativiFatti()) );
    	this.barTentativi.setProgress((double) this.model.getNTentativiFatti() / this.model.getTMax());
    	
    	//giocare
    	//if (risultato == 0) {
    	if (risultato == Gioco.OutcomeGioco.Vinto) {
    		this.txtRisultato.appendText("Hai vinto. Il numero segreto era " + this.model.getNumeroSegreto() + "\n");
    		this.btnPRova.setDisable(true);
    		return;
    	}
    	
    	//if (risultato == 1) {
    	if (risultato == Gioco.OutcomeGioco.Perso) {
    		this.txtRisultato.appendText("Hai perso. Il numero segreto era " + this.model.getNumeroSegreto() + "\n");
    		this.btnPRova.setDisable(true);
    		return;
    	}
    	
    	//if(risultato == 2) {
    	if (risultato == Gioco.OutcomeGioco.TroppoAlto) {
    		this.txtRisultato.appendText("Numero troppo alto\n");
    	}else  {
    		this.txtRisultato.appendText("Numero troppo basso\n");
    	}
    	
    	
    	
    }
    
    public void setModel(Gioco model) {
    	this.model = model;
    }
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnPRova != null : "fx:id=\"btnPRova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMax != null : "fx:id=\"txtNMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTMax != null : "fx:id=\"txtTMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

        
        //lo facciamo qua perche si deve mettere prima che viene popolata la scena
        this.comboDifficolta.getItems().add(new Difficoltà( Difficoltà.Livello.Facile));
        this.comboDifficolta.getItems().add(new Difficoltà( Difficoltà.Livello.Medio));
        this.comboDifficolta.getItems().add(new Difficoltà( Difficoltà.Livello.Difficile));
        
    }

}
