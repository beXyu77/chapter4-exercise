module com.example.chapter4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;


    opens com.example.chapter4 to javafx.fxml;
    exports com.example.chapter4;
}