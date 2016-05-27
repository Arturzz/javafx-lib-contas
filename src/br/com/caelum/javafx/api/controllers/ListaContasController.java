package br.com.caelum.javafx.api.controllers;

import static br.com.caelum.javafx.api.controllers.JavaFXUtil.DETALHES_CONTA_FXML;
import static br.com.caelum.javafx.api.controllers.JavaFXUtil.MANIPULADOR_DE_CONTAS;
import static br.com.caelum.javafx.api.controllers.JavaFXUtil.NOVA_CONTA_FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import br.com.caelum.javafx.api.modelo.ContaDao;

public class ListaContasController extends Controller {
	
	public ListaContasController(TableView<Object> listaContas) {
		listaContas.getSelectionModel().selectedItemProperty().addListener((linha, antigo, novo) -> {
			Object conta = linha.getValue();
			ActionEvent event = new ActionEvent(listaContas, listaContas);
			JavaFXUtil.trocaDeTela(DETALHES_CONTA_FXML, event, conta);
		});
		ObservableList<Object> dados = FXCollections.observableArrayList(ContaDao.getContas());
		listaContas.setItems(dados);
	}

	public void criaConta(ActionEvent event) {
		JavaFXUtil.trocaDeTela(NOVA_CONTA_FXML, event);
	}

	public void salvarDados(ActionEvent event) {

	}

	@Override
	protected String getNomeDoManipulador() {
		return MANIPULADOR_DE_CONTAS;
	}

}
