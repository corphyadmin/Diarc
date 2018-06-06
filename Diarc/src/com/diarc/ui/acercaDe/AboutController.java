package com.diarc.ui.acercaDe;

import com.diarc.util.Utilidades;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * <p>Define la l&oacute;gica de tras de la interfaz. Se usan las etiquetas @FXML sobre los objetos y m&eacute;todos
 * definidos en el archivo FXML para lograr comunicarse con ellos y poder aplicar acciones cuando se usan.</p>
 *
 * <p>Esta clase implementa los m&eacute;todos y objetos especificados en el archivo FXML los cuales son de
 * car&aacute;cter obligatorio para el correcto funcionamiento de la interfaz gr&aacute;fica. Implementa la interface
 * {@link Initializable} para ejecutar acciones cuando inicia la aplicaci&oacute;n.</p>
 *
 * @author Luis Guillermo Gómez Galeano
 * @author Oscar Javier Gómez Sánchez
 * @author Jose Alirio Díaz Suarez
 * @version 1.0
 */

public class AboutController implements Initializable {

    /**
     * Invocado para inicializar el controlador despu&eacute;s de que su elemento ra&iacute;z haya sido procesado por
     * completo. Al iniciar la aplicaci&oacute;n se ejecutan las acciones definidas en el método.
     *
     * @param location  La ubicaci&oacute;n utilizada para resolver las rutas relativas para el objeto ra&iacute;z, o nulo
     *                  si la ubicaci&oacute;n no se conoce.
     * @param resources Los recursos utilizados para localizar el objeto ra&iacute;z, o null si el objeto ra&iacute;z no
     *                  fue localizado.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Utilidades.showTrayMessage(String.format("Hola %s!", System.getProperty("user.name")), "Gracias por usar Diarc");
    }

    /**
     * Abre el navegador predeterminado del sistema operativo para cargar la pagina web del repositorio del proyecto.
     */
    private void loadWebPage() {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/corphyadmin/Diarc"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Ejecuta el método para abrir el navegador y cargar la pagina web del repositorio del proyecto.
     */
    @FXML
    private void loadGitHub() {
        loadWebPage();
    }
}
