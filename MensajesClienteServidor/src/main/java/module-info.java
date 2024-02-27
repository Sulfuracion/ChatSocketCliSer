module org.example.mensajesclienteservidor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.mensajesServidor to javafx.fxml;
    exports org.example.mensajesServidor;
    exports org.example.mensajesServidor.Controllers;
    opens org.example.mensajesServidor.Controllers to javafx.fxml;
}