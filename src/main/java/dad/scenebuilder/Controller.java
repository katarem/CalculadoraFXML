package dad.scenebuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

        //Manejador de evento (click de boton)
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent e) {
                if(e.getSource()==cButton)
                    calc.borrar();
                else if(e.getSource()==ceButton)
                    calc.borrarTodo();
                else if(e.getSource()==comaButton)
                    calc.insertarComa();
                else if(e.getSource()==sumarButton || e.getSource()==restarButton || e.getSource()==multiplicarButton || e.getSource()==dividirButton || e.getSource()==igualButton)
                    calc.operar(e.toString().charAt(0));
                else
                    calc.insertar(e.toString().charAt(0));
                pantallaField.setText(calc.getPantalla());
            }
    };

    //Agrupamos botones y añadimos evento a disparar + manejador de evento.
    Group g = new Group(cButton,ceButton,comaButton,sumarButton,restarButton,multiplicarButton,dividirButton,igualButton,button0,button1,button2,button3,button4,button5,button6,button7,button8,button9);
    g.addEventFilter(ActionEvent.ACTION, buttonHandler);


    }
    public GridPane getView(){
        return view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
