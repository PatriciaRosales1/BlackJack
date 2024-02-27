module ad.blackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens ad.blackjack to javafx.fxml;
    exports ad.blackjack;
}