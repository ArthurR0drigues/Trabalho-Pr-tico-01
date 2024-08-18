module br.cefetmg.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.cefetmg.gestaoentregasview to javafx.fxml;
    exports br.cefetmg.gestaoentregasview;
}
