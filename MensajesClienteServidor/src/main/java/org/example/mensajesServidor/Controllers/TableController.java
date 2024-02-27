package org.example.mensajesServidor.Controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.example.mensajesServidor.model.Usuario;

import static org.example.mensajesServidor.DataBase.DataBaseController.obtenerUsuarios;

public class TableController {

    @FXML
    private TableColumn<Usuario, String> ContrasenaColum;

    @FXML
    private TableColumn<Usuario, Integer> IDColum;

    @FXML
    private Button chatearButton;

    @FXML
    private Button mostrar;

    @FXML
    private TableColumn<Usuario, String> nombreColum;

    @FXML
    private TableView<Usuario> vistaChats;

    ObservableList<Usuario>list= FXCollections.observableArrayList(


    );

    @FXML
    void AbrirChat(ActionEvent event) {
        abrirSelector();

    }

    @FXML
    void MostrarChats(ActionEvent event) {
        obtenerUsuarios();

    }

    @FXML
    void mostrarTablaButton(ActionEvent event) {
        obtenerUsuarios();
    }

    public void abrirSelector() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mensajesServidor/hello-view.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Servidor");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
