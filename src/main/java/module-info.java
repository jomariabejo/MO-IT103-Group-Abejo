module com.example.fx123 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.payrollsystem.jomariabejo to javafx.fxml;
    exports com.payrollsystem.jomariabejo;
    exports com.payrollsystem.jomariabejo.controller;
    opens com.payrollsystem.jomariabejo.controller to javafx.fxml;
}