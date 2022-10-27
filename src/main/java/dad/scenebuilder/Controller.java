package dad.scenebuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{
    private Calculadora calc = new Calculadora();
    private Model model = new Model(); 
    
    @FXML
    private GridPane view;

    @FXML
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,cButton,ceButton,sumarButton,restarButton,igualButton,dividirButton,comaButton,multiplicarButton;
    
    @FXML
    private TextField pantallaField;

    

    public Controller() throws IOException{

        FXMLLoader f = new FXMLLoader(getClass().getResource("/interfaz.fxml"));
        f.setController(this);
        f.load(); 
    }
    //me importo las funciones onaction del scenebuilder
    @FXML
    public void numberAction(ActionEvent e) {
        Button b = (Button)e.getSource();
        calc.insertar(b.getText().charAt(0));
        model.setPantalla(calc.getPantalla());
    }
    @FXML
    public void comaAction(ActionEvent e) {
        calc.insertarComa();
        model.setPantalla(calc.getPantalla());
    }
    @FXML
    public void deleteAction(ActionEvent e) {
        calc.borrar();
        model.setPantalla(calc.getPantalla());
    }
    @FXML
    public void deleteAllAction(ActionEvent e) {
        calc.borrarTodo();
        model.setPantalla(calc.getPantalla());
    }

    @FXML
    public void operarAction(ActionEvent e) {
        Button b = (Button)e.getSource();
        calc.operar(b.getText().charAt(0));
        model.setPantalla(calc.getPantalla());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.pantallaProperty().bindBidirectional(pantallaField.textProperty());
    }
    public GridPane getView(){
        return view;
    }
}
