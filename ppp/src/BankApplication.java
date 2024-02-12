import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BankApplication extends Application {
    public double balance=00.00;
    public Button b1=new Button("Deposit");
    public Button b2=new Button("Withdrawal");
    public Button b3=new Button("Check Balance");
    public Button b4=new Button("Exit");
    public Label l1=new Label();
    public Label l3=new Label();
    public TextField t1=new TextField();
    public static void main(String [] args){launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(20);
        Pane p= new Pane();
        Scene scene=new Scene(root,800,600);
        primaryStage.setTitle("Bank App");
        root.requestFocus();
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);
        Label l2=new Label("Hello User");
        l2.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        b1.setEffect(dropShadow);
        b2.setEffect(dropShadow);
        b3.setEffect(dropShadow);
        b4.setEffect(dropShadow);
        Pane s = new Pane();
        Button okay=new Button("Okay");
        Button cancel=new Button("Cancel");
        okay.setEffect(dropShadow);
        cancel.setEffect(dropShadow);
        okay.setLayoutX(100);
        cancel.setLayoutX(160);
        okay.setVisible(false);
        cancel.setVisible(false);
        s.getChildren().addAll(okay,cancel);
        s.setMaxSize(300,300);
        l1.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        l3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        b1.setOnAction(event -> {
            root.getChildren().removeAll(l2,l1,t1,b1,b2,b3,b4,l3);
            root.getChildren().addAll(l1,t1,s,l3);
            l3.setText("");
            l1.setVisible(true);
            l1.setText("Amount You Deposit is : 0.00$");
            okay.setVisible(true);
            cancel.setVisible(true);
            cancel.setOnAction(event1 -> {
                root.getChildren().removeAll(l1,t1,s,l3);
                root.getChildren().addAll(l2,l1,t1,b1,b2,b3,b4,l3);
                okay.setVisible(false);
                cancel.setVisible(false);
                t1.setVisible(false);
                l1.setText("");
                l3.setText("");
                t1.clear();
                l1.setVisible(false);
            });
            t1.setVisible(true);
            t1.textProperty().addListener((observable, oldValue, newValue) -> {
                l1.setVisible(true);
                l1.setText("Amount You Deposit is : " + newValue +"$");
                okay.setOnAction(event1 -> {
                    try {
                        if(t1.getText().isEmpty()){
                            l3.setText("Warning:You must fill this field.");
                            l3.setStyle("-fx-text-fill: red;");
                        }
                        if(Double.parseDouble(t1.getText())<0){
                            l3.setText("Warning:You must enter a valid a amount.");
                            l3.setStyle("-fx-text-fill: red;");
                        }
                        else{
                            root.getChildren().removeAll(l1,t1,s,l3);
                            root.getChildren().addAll(l2,l1,t1,b1,b2,b3,b4,l3);
                            t1.clear();
                            okay.setVisible(false);
                            cancel.setVisible(false);
                            l1.setText("");
                            l3.setText("");
                            t1.setVisible(false);
                            balance=balance+Double.parseDouble(newValue);
                        }
                    }
                    catch (NumberFormatException e){
                        l3.setText("Warning:You must enter a valid a amount.");
                        l3.setStyle("-fx-text-fill: red;");
                    }
                });
            });
        });
        b2.setOnAction(event -> {
            root.getChildren().removeAll(l2,l1,t1,b1,b2,b3,b4,l3);
            root.getChildren().addAll(l1,t1,s,l3);
            l3.setText("");
            l1.setVisible(true);
            l1.setText("Amount You Withdrawal is : 0.00$");
            okay.setVisible(true);
            cancel.setVisible(true);
            cancel.setOnAction(event1 -> {
                root.getChildren().removeAll(l1,t1,s,l3);
                root.getChildren().addAll(l2,l1,t1,b1,b2,b3,b4,l3);
                okay.setVisible(false);
                cancel.setVisible(false);
                l1.setText("");
                t1.setVisible(false);
                l3.setText("");
                t1.clear();
                l1.setVisible(false);
            });
            t1.setVisible(true);
            t1.textProperty().addListener((observable, oldValue, newValue) -> {
                l1.setVisible(true);
                l1.setText("Amount You Withdrawal is : " + newValue +"$");
                okay.setOnAction(event1 -> {
                    try {
                        if(t1.getText().isEmpty()){
                            l3.setText("Warning:You must fill this field.");
                            l3.setStyle("-fx-text-fill: red;");
                        }
                        if(Double.parseDouble(t1.getText())<0){
                            l3.setText("Warning:You must enter a valid a amount.");
                            l3.setStyle("-fx-text-fill: red;");
                        }
                        else{
                            root.getChildren().removeAll(l1,t1,s,l3);
                            root.getChildren().addAll(l2,l1,t1,b1,b2,b3,b4,l3);
                            t1.clear();
                            okay.setVisible(false);
                            cancel.setVisible(false);
                            l1.setText("");
                            l3.setText("");
                            t1.setVisible(false);
                            if(balance<Double.parseDouble(newValue)){
                                l3.setText("Warning:You balance isn't enough.");
                                l3.setStyle("-fx-text-fill: red;");
                            }
                            else{
                                balance=balance-Double.parseDouble(newValue);
                            }
                        }
                    }
                    catch (NumberFormatException e){
                        l3.setText("Warning:You must enter a valid a amount.");
                        l3.setStyle("-fx-text-fill: red;");
                    }
                });
            });
        });
        b3.setOnAction(event -> {
            l3.setText("");
            t1.setVisible(false);
            okay.setVisible(false);
            cancel.setVisible(false);
            if(balance==0)
                l1.setText("Your Balance is : 0.00$");
            else
                l1.setText("Your Balance is : "+String.valueOf(balance)+"$");
            l1.setVisible(true);
        });
        b4.setOnAction(event -> primaryStage.close());
        b4.setStyle("-fx-background-color: red ; -fx-text-fill: white;");
        t1.setMaxWidth(250);
        t1.setPromptText("Enter amount");
        t1.setVisible(false);
        l1.setVisible(false);
        b1.setStyle("-fx-background-color: #8FBC8F; -fx-text-fill: white;");
        b2.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
        b3.setStyle("-fx-background-color: #ADD8E6; -fx-text-fill: white;");
        b4.setStyle("-fx-background-color: #DC143C; -fx-text-fill: white;");
        okay.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        cancel.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        t1.setStyle("-fx-background-color: #F0FFFF;");
        b1.setOnMouseEntered(event -> {
            b1.setStyle("-fx-background-color: #5f9f5f; -fx-text-fill: white;");
        });
        b1.setOnMouseExited(event -> {
            b1.setStyle("-fx-background-color: #8FBC8F; -fx-text-fill: white;");
        });
        b2.setOnMouseEntered(event -> {
            b2.setStyle("-fx-background-color: #fa2600; -fx-text-fill: white;");
        });
        b2.setOnMouseExited(event -> {
            b2.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
        });
        b3.setOnMouseEntered(event -> {
            b3.setStyle("-fx-background-color: #72bcd4; -fx-text-fill: white;");
        });
        b3.setOnMouseExited(event -> {
            b3.setStyle("-fx-background-color: #ADD8E6; -fx-text-fill: white;");
        });
        b4.setOnMouseEntered(event -> {
            b4.setStyle("-fx-background-color: #960e29; -fx-text-fill: white;");
        });
        b4.setOnMouseExited(event -> {
            b4.setStyle("-fx-background-color: #DC143C; -fx-text-fill: white;");
        });
        okay.setOnMouseEntered(event -> {
            okay.setStyle("-fx-background-color: #315a7d; -fx-text-fill: white;");
        });
        okay.setOnMouseExited(event -> {
            okay.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        });
        cancel.setOnMouseEntered(event -> {
            cancel.setStyle("-fx-background-color: #315a7d; -fx-text-fill: white;");
        });
        cancel.setOnMouseExited(event -> {
            cancel.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        });


        root.getChildren().addAll(l2,l1,t1,b1,b2,b3,b4,l3);
    }
}
