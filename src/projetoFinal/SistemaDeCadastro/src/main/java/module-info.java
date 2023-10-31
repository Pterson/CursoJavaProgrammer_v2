module projeto.com.impacta.sistemadecadastro {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens projeto.com.impacta.sistemadecadastro to javafx.fxml;
    exports projeto.com.impacta.sistemadecadastro;

    exports projeto.com.impacta.sistemadecadastro.controller;
    opens projeto.com.impacta.sistemadecadastro.controller to javafx.fxml;
}