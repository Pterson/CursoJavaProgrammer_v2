module com.example.sistemadecadastro {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.sistemadecadastro to javafx.fxml;
    exports com.example.sistemadecadastro;
}