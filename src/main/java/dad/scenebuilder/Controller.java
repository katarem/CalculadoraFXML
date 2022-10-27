package dad.scenebuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{
    
    @FXML
    private GridPane view;

    @FXML
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,cButton,ceButton,sumarButton,restarButton,igualButton,dividirButton,comaButton,multiplicarButton;
    
    @FXML
    private TextField pantallaField;

    private Calculadora calc;
    private Model model;

    public Controller() throws IOException{

        FXMLLoader f = new FXMLLoader(getClass().getResource("/interfaz.fxml"));
        f.setController(this);
        f.load();

        model = new Model();
        calc = new Calculadora();

        //Bindings
        model.pantalla.bind(pantallaField.textProperty());

        //EventListeners
        igualButton.setOnAction(e -> calcular('='));
        sumarButton.setOnAction(e -> calcular('+'));
        restarButton.setOnAction(e -> calcular('-'));
        multiplicarButton.setOnAction(e -> calcular('*'));
        dividirButton.setOnAction(e -> calcular('/'));
        cButton.setOnAction(e -> calcular('c'));
        ceButton.setOnAction(e -> calcular('e'));
        comaButton.setOnAction(e -> calcular(','));
        button0.setOnAction(e -> calcular('0'));
        button1.setOnAction(e -> calcular('1'));
        button3.setOnAction(e -> calcular('3'));
        button4.setOnAction(e -> calcular('4'));
        button5.setOnAction(e -> calcular('5'));
        button2.setOnAction(e -> calcular('2'));
        button6.setOnAction(e -> calcular('6'));
        button7.setOnAction(e -> calcular('7'));
        button8.setOnAction(e -> calcular('8'));
        button9.setOnAction(e -> calcular('9'));

    }
    public GridPane getView(){
        return view;
    }
    private void calcular(char a){
        if(a=='c')
            calc.borrar();
        else if(a=='e')
            calc.borrarTodo();
        else if(a==',')
            calc.insertarComa();
        else if(Character.isDigit(a))
            calc.insertar(a);
        else
            calc.operar(a);
        pantallaField.setText(calc.getPantalla());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
