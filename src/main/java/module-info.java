module com.jomariabejo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires org.controlsfx.controls;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens com.jomariabejo to javafx.fxml;
    exports com.jomariabejo;
    exports com.jomariabejo.model;
    opens com.jomariabejo.model to javafx.fxml, org.hibernate.orm.core;
    opens com.jomariabejo.controller to javafx.fxml;
    exports com.jomariabejo.controller;
    opens com.jomariabejo.utils to javafx.fxml;
}
