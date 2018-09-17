package utiles;

import javafx.fxml.LoadException;

public class Utilidades {

	
	public static String readFile(String name){
		String value = "";
		try {
			value = LoadProperties.getInstance().getProperty(name);
		} catch (LoadException e) {
			e.printStackTrace();
		}
		return value;
	}
}
