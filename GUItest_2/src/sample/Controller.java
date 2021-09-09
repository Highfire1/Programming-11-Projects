package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textGetName;
    public Button buttonGetName;
    public TextField addVal;
    public TextField subtractVal;
    public Button subtractbtn;
    public Button addbtn;
    public Label total;
    public double totalval;

    public void printName(ActionEvent actionEvent) {
        String name = textGetName.getText();
        System.out.println(name);
    }

    public void add(ActionEvent actionEvent) {
        double num = Double.parseDouble(addVal.getText());
        totalval += num;
        total.setText(Double.toString(totalval));
        addVal.clear();

    }

    public void substract(ActionEvent actionEvent) {
        double num = Double.parseDouble(subtractVal.getText());
        totalval -= num;
        total.setText(Double.toString(totalval));
    }
}
