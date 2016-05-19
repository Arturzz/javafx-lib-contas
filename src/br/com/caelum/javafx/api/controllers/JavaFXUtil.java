package br.com.caelum.javafx.api.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXUtil {
	
	public static final String PROBLEMAS_INTERNOS = "Oops, problemas internos. Chame o instrutor. '-'";
	public static final String DEU_PAU_EXCEPTION = "Deu pau '-'";
	public static final String CLASSE_CONTA = "br.com.caelum.contas.modelo.Conta";
	public static final String PACOTE_BASE = "br.com.caelum.contas.";
	public static final String PACOTE_MODELO = PACOTE_BASE + "modelo.";
	public static final String MANIPULADOR_DE_CONTAS = "ManipuladorDeContas";
	public static final String NOVA_CONTA_FXML = "NovaConta.fxml";
	public static final String TELA_INICIAL_FXML = "Inicial.fxml";
	public static final String NOVO_SEGURO_FXML = "NovoSeguro.fxml";
	public static final String DETALHES_CONTA_FXML = "DetalhesConta.fxml";
	
	public static void mostraAlerta(String mensagem){
		Alert alerta = new Alert(AlertType.ERROR, mensagem, ButtonType.OK);
		alerta.setHeaderText(DEU_PAU_EXCEPTION);
		alerta.showAndWait();
	}
	
	static void trocaDeTela(String nomeFxml, ActionEvent event){
		try {
			AnchorPane base = FXMLLoader.load(JavaFXUtil.class.getClassLoader().getResource(nomeFxml));
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			Scene scene = new Scene(base);
			stage.setScene(scene);
		} catch (IOException e) {
			mostraAlerta(PROBLEMAS_INTERNOS);
			throw new RuntimeException(e);
		}
	}
}