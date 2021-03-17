package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary model = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlien;

    @FXML
    private TextArea txtResult;

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	ArrayList<String> parole = new ArrayList<String>();
    	parole.clear();
    	String alienTranslate="";
    	String alienAdd="";
    	String translateWord="";
    	String[] campo = txtAlien.getText().split(" ");
    	for(String s: campo) {
    		parole.add(s);
    	}
    	if(campo.length==1) {
    				alienTranslate = campo[0].toLowerCase();
    					if(alienTranslate.matches("[a-z]*")) {
    						txtAlien.clear();
    						String ww =	model.translateWord(alienTranslate);
    						txtResult.setText(ww);
    						
    					}else {
    			txtResult.setText("Errore nella scrittura della Parola da tradurre");
    			return;
    					}
    	}
    	
    	if(campo.length==2) {
    					alienAdd = campo[0].toLowerCase();
    					translateWord = campo[1].toLowerCase();
    				if(alienAdd.matches("[a-z]*") && translateWord.matches("[a-z]*")) {
    					model.addWord(alienAdd,translateWord);
    					txtAlien.clear();
    				}else {
    					txtResult.setText("Errore nella scrittura della Parola da aggiungere al dizionario");
    					return;}
    	}
    	txtAlien.clear();
    }

    @FXML
    void initialize() {
        assert txtAlien != null : "fx:id=\"txtAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
