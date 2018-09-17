package utiles;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javafx.fxml.LoadException;

/**
 * LoadProperties Clase administradora de la obtencion de parametros
 * configurados en los archivos .properties
 * 
 * @author Yair Carreno Lizarazo
 * 
 */
public class LoadProperties {

	private static LoadProperties singletonProp = null;
	private static ResourceBundle defaultProp;
	private static Locale loc = new Locale("", "", "");

	public static final String PROPERTIES_NOT_FOUND = "No se encontro el archivo de propiedades solicitado.";

	public static final int PROPERTY_NOT_FOUND_CODE = 101;

	public static final String PROPERTY_NOT_FOUND = "101: No se encontro propiedad solicitada.";

	private LoadProperties() throws LoadException {
		try {
			defaultProp = ResourceBundle.getBundle("parametros", loc);
		} catch (MissingResourceException e) {
			throw new LoadException(PROPERTIES_NOT_FOUND + e.getMessage());
		}
	}

	/**
	 * Retorna la unica instancia del paquete de propiedades. Si no existe la
	 * crea.
	 * 
	 * @return LoadProperties unica instancia del paquete de propiedades.
	 * @throws LoadException
	 *             Excepciones relacionadas con funcionalidades de procesamiento
	 *             de archivos de otros operadores.
	 */
	public static synchronized LoadProperties getInstance() throws LoadException {
		if (singletonProp == null) {
			singletonProp = new LoadProperties();
		}
		return singletonProp;
	}

	/**
	 * Asegura que el paquete de propiedades no tenga mas de una instancia y no
	 * permite su clonacion.
	 * 
	 * @throws CloneNotSupportedException
	 *             clonacion no permitida.
	 * @return Object nunca sera retornado ya que no es permitido.
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * Retorna la propiedad solicitada del paquete o archivo indicado.
	 * 
	 * @param nameProperty
	 *            String propiedad solicitada.
	 * @param propertyFile
	 *            String nombre del archivo que contiene la propiedad.
	 * @throws LoadException
	 *             Excepciones relacionadas con funcionalidades de procesamiento
	 *             de archivos de otros operadores.
	 * @return String valor de la propiedad.
	 */
	public String getProperty(String nameProperty, String propertyFile) throws LoadException {

		try {

			return defaultProp.getString(nameProperty);

		} catch (MissingResourceException e) {
			throw new LoadException(PROPERTY_NOT_FOUND + e.getMessage());
		}
	}

	/**
	 * Ingresa la propiedad solicitada del paquete o archivo indicado.
	 * 
	 * @param nameProperty
	 *            String propiedad solicitada.
	 * @param propertyFile
	 *            String nombre del archivo que contiene la propiedad.
	 * @throws LoadException
	 *             Excepciones relacionadas con funcionalidades de procesamiento
	 *             de archivos de otros operadores.
	 * @return String valor de la propiedad.
	 */
	public String setProperty(String nameProperty, String propertyFile) throws LoadException {

		try {

			return defaultProp.getString(nameProperty);

		} catch (MissingResourceException e) {
			throw new LoadException(PROPERTY_NOT_FOUND + e.getMessage());
		}
	}

	/**
	 * Retorna la propiedad solicitada del archivo proyectoPlantilla.properties.
	 * 
	 * @param nameProperty
	 *            String propiedad solicitada.
	 * @throws LoadException
	 *             Excepciones relacionadas con funcionalidades de procesamiento
	 *             de archivos de otros operadores.
	 * @return String valor de la propiedad.
	 */
	public String getProperty(String nameProperty) throws LoadException {
		return this.getProperty(nameProperty, "parametros");
	}
}