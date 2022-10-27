package dad.scenebuilder;

import javafx.beans.property.SimpleStringProperty;

public class Model {
    
    public SimpleStringProperty pantalla = new SimpleStringProperty();

    public final SimpleStringProperty pantallaProperty() {
		return this.pantalla;
	}
	
	public final String getPantalla() {
		return this.pantallaProperty().get();
	}
	
	public final void setPantalla(final String pantalla) {
		this.pantallaProperty().set(pantalla);
	}
    
}
