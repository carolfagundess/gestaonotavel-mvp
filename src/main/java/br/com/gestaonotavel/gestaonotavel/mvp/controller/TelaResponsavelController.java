package br.com.gestaonotavel.gestaonotavel.mvp.controller;

import br.com.gestaonotavel.gestaonotavel.mvp.model.Responsavel;
import br.com.gestaonotavel.gestaonotavel.mvp.service.ResponsavelService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carol
 */
public class TelaResponsavelController implements Initializable {

    @FXML
    private TableView<Responsavel> tableView;
    @FXML
    private TableColumn<Responsavel, String> colunaCpf;
    @FXML
    private TableColumn<Responsavel, String> colunaNome;
    @FXML
    private TableColumn<Responsavel, String> colunaTelefone;
    @FXML
    private Button botaoAdd;

    private ObservableList<Responsavel> observableList;

    private ResponsavelService responsavelService = new ResponsavelService();

    public void preencherTabela() {

        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        observableList = FXCollections.observableArrayList(responsavelService.buscarTodos());

        tableView.setItems(observableList);
    }

    @FXML
    void aoClicarNoBotao(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/br/com/gestao/notavel/mvp/view/TelaCadastroResponsavel.fxml");
        if (fxmlLocation == null) {
            System.err.println("Erro: arquivo FXML não encontrado");
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastrar Responsável");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherTabela();
    }

}
