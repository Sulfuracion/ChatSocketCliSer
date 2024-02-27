package org.example.mensajesServidor.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.mensajesServidor.DataBase.DataBaseController;

import java.sql.Connection;

import static org.example.mensajesServidor.DataBase.DataBaseController.usuarioExiste;

public class LayoutController {

    @FXML
    private Button aceptarButton;

    @FXML
    private PasswordField areaContrasena;

    @FXML
    private TextField areaUsuario;

    @FXML
    private Button cancelarButton;

    @FXML
    void SalirApp(ActionEvent event) {

    }



    @FXML
    void probarUsuario(ActionEvent event) {
        if (usuarioExiste(areaUsuario.getText(), areaContrasena.getText()) == true){
            abrirSelector();
        }else{
            usuarioExiste(areaUsuario.getText(), areaContrasena.getText());
        }

    }

    public void abrirSelector() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mensajesServidor/selector.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Selector");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

