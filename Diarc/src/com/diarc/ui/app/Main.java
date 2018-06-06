package com.diarc.ui.app;

import com.diarc.util.Utilidades;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <p>Clase que contiene los m&eacute;todos para ejecutar la aplicaci&oacute;n. Esta hereda de la clase {@link Application}
 * desde la cual se extienden las aplicaciones JavaFX.</p>
 *
 * @author Luis Guillermo Gómez Galeano
 * @author Oscar Javier Gómez Sánchez
 * @author Jose Alirio Díaz Suarez
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Es el punto de entrada principal para todas las aplicaciones JavaFX. El m&eacute;todo de inicio se invoca
     * despu&eacute;s de que el m&eacute;todo {@code init} haya retornado, y despu&eacute;s de que el sistema est&eacute;
     * listo para que la aplicaci&oacute;n comience a ejecutarse.
     * <strong><em>NOTA:</em></strong> Este m&eacute;todo se invoca en el subproceso de la aplicaci&oacute;n JavaFX.
     *
     * @param primaryStage Escenario principal para esta aplicaci&oacute;n, en la que se puede configurar aspectos como
     *                     el t&iacute;tulo, tama&ntilde;o, estilos, icono, redimensi&oacute;n de la ventana.
     * @throws Exception Construye una nueva excepci&oacute;n con null sin mensaje de detalle.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("interfaz.fxml"));
        primaryStage.setTitle("Diarc");
        primaryStage.getIcons().add(new Image("/com/diarc/imagenes/DiarcLogo.png"));
        primaryStage.setResizable(false);
        var scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/diarc/estilos/estilos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            try {
                Utilidades.writeWordFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Inicia la ejecuci&oacute;n de cualquier programa en Java. Dicho m&eacute;todo representa el &uacute;nico
     * mecanismo autom&aacute;tico para realizar tareas al invocarse una Clase, esto es, al momento de ejecutarse determinada
     * Clase siempre ser&aacute; ejecutado todo el contenido dentro de este m&eacute;todo.
     *
     * @param args Par&aacute;metro de entrada, siempre ser&aacute; un array de String's (String[]) el cual es tomado de
     *             la l&iacute;nea de comandos o una fuente alterna.
     */
    public static void main(String[] args) {
        launch(args);
    }
}