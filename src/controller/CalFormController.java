package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class CalFormController {

    @FXML
    private TextField txtShow;

    @FXML
    private Label lbIAnswer;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCE;

    @FXML
    private Button btnDev;

    @FXML
    private Button btnEq;

    @FXML
    private Button btnMulti;

    @FXML
    private Button btnOnOff;

    @FXML
    private Button btnPointer;

    @FXML
    private Button btnSum;

    @FXML
    private Button btnsubs;

    @FXML
    private Button btnB;

    @FXML
    private TextArea txtHistory;

    @FXML
    private Button sqrt;

    @FXML
    private Button power2;

    @FXML
    private Button log;

    @FXML
    private Button power;

    @FXML
    private Button sin;

    @FXML
    private Button cos;


    private List<Button> btnList;
    private double answer;
    private String function;
    private List<String> historyList;

    public void initialize(){

        txtShow.setEditable(false);
        txtShow.setDisable(true);  // Απενεργοποίηση του TextField
        txtHistory.setEditable(false);
        txtHistory.setDisable(true);

        answer=0;

        function="empty";
        historyList = new ArrayList<>();

        btnList = FXCollections.observableArrayList(btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPointer,btnEq,
                btnSum,btnsubs,btnMulti,btnDev,btnC,btnCE,btnB,sqrt,power2,power,cos,sin,log);

        onOffFunction();
        setAnswer();
        functions();
        off();
    }

    private void functions() {
        btnC.setOnAction(event -> {
            txtShow.clear();
        });
        btnCE.setOnAction(event -> {
            function = "empty";
            answer = 0;
            lbIAnswer.setText("");
            historyList.clear(); // Καθαρισμός ιστορικού
            txtHistory.clear();
        });

        btnB.setOnAction(event -> {
                    String currentText = txtShow.getText();
                    if (currentText != null && currentText.length() > 0) {
                        txtShow.setText(currentText.substring(0, currentText.length() - 1));  // Διαγραφή τελευταίου χαρακτήρα
                    }
                });

        btn0.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"0":"0");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("0");
            }
        });
        btn1.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"1":"1");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("1");
            }
        });
        btn2.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"2":"2");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("2");
            }
        });
        btn3.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"3":"3");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("3");
            }
        });
        btn4.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"4":"4");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("4");
            }
        });
        btn5.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"5":"5");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("5");
            }
        });
        btn6.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"6":"6");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("6");
            }
        });
        btn7.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"7":"7");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("7");
            }
        });
        btn8.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"8":"8");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("8");
            }
        });
        btn9.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+"9":"9");
            if (function == "equal")
            {
                function = "empty";
                lbIAnswer.setText("9");
            }
        });
        btnPointer.setOnAction(event -> {
            txtShow.setText(txtShow.getText()!=null? txtShow.getText()+".":"0.");
        });
        btnSum.setOnAction(event -> {
            action();
            function = "sum";
        });
        btnsubs.setOnAction(event -> {
            action();
            function = "sub";
        });
        btnMulti.setOnAction(event -> {
            action();
            function = "multi";
        });
        btnDev.setOnAction(event -> {
            action();
            function = "dev";
        });
        btnEq.setOnAction(event -> {
            action();
            function = "equal";
        });
        sqrt.setOnAction(event -> {
            function = "sqrt";
            action();

        });
        power.setOnAction(event -> {

            action();
            function = "power";

        });
        power2.setOnAction(event -> {
            function = "power2";
            action();

        });
        log.setOnAction(event -> {
            function = "log";
            action();

        });
        sin.setOnAction(event -> {
            function = "sin";
            action();

        });
        cos.setOnAction(event -> {
            function = "cos";
            action();

        });
    }

    private void setText(String value) {
        txtShow.setText(txtShow.getText() != null ? txtShow.getText() + value : value);
    }

    private void setAnswer(){
        if(answer == (int)answer) {
            lbIAnswer.setText(String.valueOf((int) answer));
        }
        else {
            lbIAnswer.setText(String.valueOf(answer));
            }
        txtShow.clear();
    }

    private void action() {
        String HistoryEntryCustom;
        double tempAnswer;
        if (txtShow.getText().isEmpty()) {
            return;
        }
        double inputValue = Double.parseDouble(txtShow.getText());

            switch (function) {
                case "empty":
                    System.out.println(inputValue + "hi");
                    answer = inputValue; // Προσθήκη ιστορικού με το "=" για πρώτη πράξη
                    setAnswer();
                    break;
                case "sum":
                    System.out.println(inputValue);
                    answer += inputValue;
                    addToHistory(inputValue, "+");  // Προσθήκη ιστορικού για πρόσθεση
                    setAnswer();
                    break;
                case "sub":
                    answer -= inputValue;
                    addToHistory(inputValue, "-");  // Προσθήκη ιστορικού για αφαίρεση
                    setAnswer();
                    break;
                case "multi":
                    answer *= inputValue;
                    addToHistory(inputValue, "*");  // Προσθήκη ιστορικού για πολλαπλασιασμό
                    setAnswer();
                    break;
                case "dev":
                    if (inputValue != 0) {
                        answer /= inputValue;
                        addToHistory(inputValue, "/");  // Προσθήκη ιστορικού για διαίρεση
                    } else {
                        txtShow.setText("Error");  // Αν διαίρεση με 0, εμφανίζει σφάλμα
                    }
                    setAnswer();
                    break;
                case "equal":
                    addToHistory(inputValue, "=");  // Προσθήκη ιστορικού για ίσο
                    setAnswer();
                    function = "empty";
                    break;

                case "sqrt" :
                    tempAnswer = answer;
                    answer = Math.sqrt(inputValue);
                    setAnswer();
                    HistoryEntryCustom =tempAnswer + " ^ " + inputValue + " = " + answer;
                    historyList.add(HistoryEntryCustom);
                    txtHistory.appendText(HistoryEntryCustom + "\n");
                    break;

                case "power" :
                    tempAnswer = answer;
                    answer = Math.pow(answer, inputValue);// Προσθήκη ιστορικού για πρόσθεση
                    setAnswer();
                    HistoryEntryCustom =tempAnswer + " ^ " + inputValue + " = " + answer;
                    historyList.add(HistoryEntryCustom);
                    txtHistory.appendText(HistoryEntryCustom + "\n");

                    break;

                case "power2" :
                    answer = inputValue * inputValue;
                    setAnswer();

                    HistoryEntryCustom =inputValue + "  " + "^ 2 " + " = " + answer;
                    historyList.add(HistoryEntryCustom);
                    txtHistory.appendText(HistoryEntryCustom + "\n");
                    function = "empty";
                    break;

                case "log" :
                    int base = 10;
                    answer = Math.log(inputValue) / Math.log(base);
                    setAnswer();
                    break;

                case "cos" :
                    break;

                case "sin" :
                    System.out.println("hey");
                    double angleInRadiansSin = Math.toRadians(inputValue);
                    double sinValue = Math.sin(angleInRadiansSin);
                    double toleranceSin = 1e-6;

                    if (Math.abs(sinValue) < toleranceSin) {
                        answer = 0;
                        setAnswer();
                    }
                    else {
                        answer = inputValue;
                        setAnswer();
                    }
                    break;

        }
    }

    private void addToHistory(double inputValue, String operation) {
        String historyEntry;

        switch (operation) {
            case "^2" :
                historyEntry = operation + " " + (int)inputValue + " = " + (int)answer;
                break;
            case "sqrt" :
                break;
        }


        if (inputValue == (int)inputValue && answer == (int)answer) {
            historyEntry = lbIAnswer.getText() + " " + operation + " " + (int)inputValue + " = " + (int)answer;
        }
        else {
            if (inputValue == (int) inputValue) {
                historyEntry = lbIAnswer.getText() + " " + operation + " " + (int) inputValue + " = " + answer;
            } else {
                historyEntry = lbIAnswer.getText() + " " + operation + " " + inputValue + " = " + answer;
            }
        }
        historyList.add(historyEntry);

        // Χρησιμοποιούμε appendText για να προσθέτουμε στο υπάρχον κείμενο
        txtHistory.appendText(historyEntry + "\n");
    }

    private void off() {
        for (Button btn:btnList) {
            btn.setDisable(true);
        }
        txtShow.clear();
        answer = 0;
        setAnswer();
        lbIAnswer.setText("");


    }

    private void on() {
        for (Button btn:btnList) {
            btn.setDisable(false);
        }
        txtShow.clear();
        answer = 0;
        setAnswer();
        lbIAnswer.setText("");
    }

    private void onOffFunction() {
        btnOnOff.setOnAction(event -> {
            if (btnOnOff.getText().equals("ON")){
                on();

                txtShow.setDisable(false);  // Ενεργοποίηση του txtShow
                txtHistory.setDisable(false);
                btnOnOff.setText("OFF");
            }else if (btnOnOff.getText().equals("OFF")){
                off();
                txtShow.setDisable(true);  // Απενεργοποίηση του txtShow
                txtHistory.setDisable(true);
                txtHistory.clear();
                btnOnOff.setText("ON");
            }
        });
    }
}