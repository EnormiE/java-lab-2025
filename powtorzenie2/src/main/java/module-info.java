module org.example.powtorzenie2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.powtorzenie2 to javafx.fxml;
    exports org.example.powtorzenie2;
}