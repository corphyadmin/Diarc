package com.diarc.util;

import com.diarc.palabras.ListaPalabras;
import com.diarc.palabras.Palabra;
import com.diarc.ui.app.Controller;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * <p>Clase que contiene los m&eacute;todos principales que realizan acciones importantes para el funcionamiento de la
 * aplicaci&oacute;n. Sus m&eacute;todos son comunes ya que est&aacute;n definidos con un alcance est&aacute;tico.</p>
 *
 * @author Luis Guillermo Gómez Galeano
 * @author Oscar Javier Gómez Sánchez
 * @author Jose Alirio Díaz Suarez
 * @version 1.0
 */

public class Utilidades {
    /**
     * Lista de palabras Generales.
     */
    private static final ObservableList<Palabra> GENERALWORDS = new ListaPalabras().getListGeneralWords();

    /**
     * Lista de palabras de Instrucciones Assembler.
     */
    private static final ObservableList<Palabra> ASSEMBLERWORDS = new ListaPalabras().getListAssemblerWords();

    /**
     * Lista de palabras de Interrupciones CPU.
     */
    private static final ObservableList<Palabra> CPUWORDS = new ListaPalabras().getListCpuWords();

    /**
     * Lista de palabras totales del diccionario.
     */
    private static final ObservableList<Palabra> ALLWORDS = new ListaPalabras().getFinalList();

    /**
     * Almacena la posici&oacute;n de la &uacute;ltima palabra buscada o mostrada.
     */
    private static int lastIndex = -1;

    /**
     * Carga una nueva ventana a partir de un nuevo archivo FXML.
     *
     * @param location Ruta del archivo de interfaz gr&aacute;fica.
     * @param title    T&iacute;tulo de la ventana.
     */
    public static void loadWindow(URL location, String title) {
        try {
            var loader = new FXMLLoader(location);
            Parent parent = loader.load();
            var stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.getIcons().add(new Image("/com/diarc/imagenes/DiarcLogo.png"));
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Muestra una notificaci&oacute;n en el sistema operativo.
     *
     * @param title   T&iacute;tulo de la notificaci&oacute;n.
     * @param message Mensaje que se mostrar&aacute; al usuario.
     */
    public static void showTrayMessage(String title, String message) {
        try {
            var tray = SystemTray.getSystemTray();
            var image = ImageIO.read(Controller.class.getResource("/com/diarc/imagenes/DiarcLogo.png"));
            var trayIcon = new TrayIcon(image, "Diarc");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Diarc");
            tray.add(trayIcon);
            trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
            tray.remove(trayIcon);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Reconoce el evento de presionar la tecla Enter para ejecutar una funcionalidad de un bot&oacute;n.
     *
     * @param ap  Contenedor padre del bot&oacute;n.
     * @param btn Bot&oacute;n afectado por el evento.
     */
    public static void addEventKeyPress(AnchorPane ap, Button btn) {
        ap.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                btn.fire();
                evt.consume();
            }
        });
    }

    /**
     * Formatea el texto ingresado en un campo de texto para permitir solo caracteres alfanum&eacute;ricos en may&uacute;sculas o
     * min&uacute;sculas, el espacio y los signos <strong>()/-</strong>.
     *
     * @param textField Campo de texto a validar.
     */
    public static void textFormatted(JFXTextField textField) {
        UnaryOperator<TextFormatter.Change> filter = txt -> {
            if (txt.isAdded()) {
                // La expresión "[a-zA-Z0-9\s()/-]" Permite caracteres alfanuméricos, el espacio y los signos ()/-
                if (!txt.getText().matches("[a-zA-Z0-9\\s()/-]")) txt.setText("");
            }
            return txt;
        };
        textField.setTextFormatter(new TextFormatter<>(filter));
    }

    /**
     * LLena la tabla de Favoritos.
     *
     * @param tableViews Tabla a llenar.
     */
    public static void fillListFavorites(JFXTreeTableView<Palabra> tableViews) {
        JFXTreeTableColumn<Palabra, String> clTFavorites = new JFXTreeTableColumn<>("Palabras Favoritas");
        clTFavorites.setCellValueFactory(param -> {
            if (clTFavorites.validateValue(param)) {
                return param.getValue().getValue().wordNameProperty();
            } else {
                return clTFavorites.getComputedValue(param);
            }
        });

        tableViews.getColumns().setAll(clTFavorites);
        tableViews.setRoot(new RecursiveTreeItem<>(getWordsFavorites(), RecursiveTreeObject::getChildren));
        tableViews.setShowRoot(false);
    }

    /**
     * Obtiene y almacena las palabras favoritas en una lista.
     *
     * @return Lista de palabras favoritas.
     */
    private static ObservableList<Palabra> getWordsFavorites() {
        ObservableList<Palabra> favoriteListAll = FXCollections.observableArrayList();
        for (var allWord : ALLWORDS) {
            if (allWord.isFavorite()) {
                favoriteListAll.add(allWord);
            }
        }
        return favoriteListAll;
    }

    /**
     * Filtra la tabla de Favoritos.
     *
     * @param tableViews Tabla a filtrar.
     * @param input      Campo de texto para digitar las palabras contenidas en la tabla Favoritos.
     */
    public static void filterListFavorite(JFXTreeTableView<Palabra> tableViews, JFXTextField input) {
        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tableViews.setPredicate(new Predicate<TreeItem<Palabra>>() {
                    @Override
                    public boolean test(TreeItem<Palabra> palabraTreeItem) {
                        return palabraTreeItem.getValue().wordNameProperty().getValue().contains(newValue)
                                || palabraTreeItem.getValue().wordNameProperty().getValue().toLowerCase().contains(newValue);
                    }
                });
            }
        });
    }

    /**
     * Llena las tablas con los nombres de las palabras disponibles en el diccionario.
     *
     * @param tableViews Array de Tablas con tama&ntilde;o de tres posiciones:
     *                   <ul>
     *                   <li><strong>Posici&oacute;n 0:</strong> Tabla para las palabras Generales.</li>
     *                   <li><strong>Posici&oacute;n 1:</strong> Tabla para las palabras de Instrucciones Assembler.</li>
     *                   <li><strong>Posici&oacute;n 2:</strong> Tabla para las palabras de Interrupciones CPU.</li>
     *                   </ul>
     */
    public static void fillList(JFXTreeTableView<Palabra>[] tableViews) {
        JFXTreeTableColumn<Palabra, String> clTGeneral = new JFXTreeTableColumn<>("Lista de palabras");
        clTGeneral.setCellValueFactory(param -> {
            if (clTGeneral.validateValue(param)) {
                return param.getValue().getValue().wordNameProperty();
            } else {
                return clTGeneral.getComputedValue(param);
            }
        });


        JFXTreeTableColumn<Palabra, String> clTAssembler = new JFXTreeTableColumn<>("Lista de palabras");
        clTAssembler.setCellValueFactory(param -> {
            if (clTAssembler.validateValue(param)) {
                return param.getValue().getValue().wordNameProperty();
            } else {
                return clTAssembler.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<Palabra, String> clTCpu = new JFXTreeTableColumn<>("Lista de palabras");
        clTCpu.setCellValueFactory(param -> {
            if (clTCpu.validateValue(param)) {
                return param.getValue().getValue().wordNameProperty();
            } else {
                return clTCpu.getComputedValue(param);
            }
        });

        tableViews[0].getColumns().setAll(clTGeneral);
        tableViews[0].setRoot(new RecursiveTreeItem<>(GENERALWORDS, RecursiveTreeObject::getChildren));
        tableViews[0].setShowRoot(false);

        tableViews[1].getColumns().setAll(clTAssembler);
        tableViews[1].setRoot(new RecursiveTreeItem<>(ASSEMBLERWORDS, RecursiveTreeObject::getChildren));
        tableViews[1].setShowRoot(false);

        tableViews[2].getColumns().setAll(clTCpu);
        tableViews[2].setRoot(new RecursiveTreeItem<>(CPUWORDS, RecursiveTreeObject::getChildren));
        tableViews[2].setShowRoot(false);
    }


    /**
     * Filtra las tablas que contienen las palabras disponibles en el diccionario.
     *
     * @param tableViews Array de tablas a filtrar con tama&ntilde;o de tres posiciones:
     *                   <ul>
     *                   <li><strong>Posici&oacute;n 0:</strong> Tabla para las palabras Generales.</li>
     *                   <li><strong>Posici&oacute;n 1:</strong> Tabla para las palabras de Instrucciones Assembler.</li>
     *                   <li><strong>Posici&oacute;n 2:</strong> Tabla para las palabras de Interrupciones CPU.</li>
     *                   </ul>
     * @param input      Array de campos de texto con tama&ntilde;o de tres posiciones:
     *                   <ul>
     *                   <li><strong>Posici&oacute;n 0:</strong> Campo de texto para digitar las palabras contenidas en
     *                   la tabla General.</li>
     *                   <li><strong>Posici&oacute;n 1:</strong> Campo de texto para digitar las palabras contenidas en
     *                   la tabla de Instrucciones Assembler.</li>
     *                   <li><strong>Posici&oacute;n 2:</strong> Campo de texto para digitar las palabras contenidas en
     *                   la tabla de Interrupciones CPU.</li>
     *                   </ul>
     */
    public static void filterList(JFXTreeTableView<Palabra>[] tableViews, JFXTextField[] input) {
        input[0].textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tableViews[0].setPredicate(new Predicate<TreeItem<Palabra>>() {
                    @Override
                    public boolean test(TreeItem<Palabra> palabraTreeItem) {
                        return palabraTreeItem.getValue().wordNameProperty().getValue().contains(newValue)
                                || palabraTreeItem.getValue().wordNameProperty().getValue().toLowerCase().contains(newValue);
                    }
                });
            }
        });

        input[1].textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tableViews[1].setPredicate(new Predicate<TreeItem<Palabra>>() {
                    @Override
                    public boolean test(TreeItem<Palabra> palabraTreeItem) {
                        return palabraTreeItem.getValue().wordNameProperty().getValue().contains(newValue)
                                || palabraTreeItem.getValue().wordNameProperty().getValue().toLowerCase().contains(newValue);
                    }
                });
            }
        });

        input[2].textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                tableViews[2].setPredicate(new Predicate<TreeItem<Palabra>>() {
                    @Override
                    public boolean test(TreeItem<Palabra> palabraTreeItem) {
                        return palabraTreeItem.getValue().wordNameProperty().getValue().contains(newValue)
                                || palabraTreeItem.getValue().wordNameProperty().getValue().toLowerCase().contains(newValue);
                    }
                });
            }
        });
    }

    /**
     * Verifica si la palabra a buscar esta disponible en la lista que contiene todas las palabras.
     *
     * @param word Palabra a buscar.
     * @return <ul>
     * <li><strong>Palabra:</strong> si esta fue encontrada.</li>
     * <li><strong>null:</strong> si esta no fue encontrada.</li>
     * </ul>
     */
    public static Palabra containsWord(String word) {
        for (var i = 0; i < ALLWORDS.size(); i++) {
            if (word.equalsIgnoreCase(ALLWORDS.get(i).getWordName())) {
                lastIndex = i;
                return ALLWORDS.get(i);
            }
        }
        return null;
    }

    /**
     * Genera un n&uacute;mero aleatorio entre cero y el tama&ntilde;o de una lista de palabras.
     *
     * @param size Tama&ntilde;o de la lista de palabras.
     * @return N&uacute;mero aleatorio.
     */
    private static int randomNumber(int size) {
        return ThreadLocalRandom.current().nextInt(0, size);
    }

    /**
     * Genera una palabra aleatoria.
     *
     * @return Palabra aleatoria.
     */
    public static Palabra randomWord() {
        var p = new int[2];
        var numero = randomNumber(ALLWORDS.size());
        p[1] = randomNumber(ALLWORDS.size()); // Palabra final
        while (true) {
            if (p[1] != numero) {
                p[0] = p[1];
                p[1] = numero;
                break;
            } else {
                numero = randomNumber(ALLWORDS.size());
            }
        }
        lastIndex = numero;
        return ALLWORDS.get(p[1]);
    }

    /**
     * Genera un grupo de palabras sugeridas las cuales son aleatorias.
     *
     * @return Matriz de tipo Object con tama&ntilde;o de 5 filas por 2 columnas:
     * <ul>
     * <li><strong>Filas:</strong> Objetos de tipo Palabra.</li>
     * <li><strong>columnas:</strong> Posici&oacute;n de cada uno de los objetos de tipo Palabra.</li>
     * </ul>
     */
    public static Object[][] randomWordGroup() {
        int number, end, start = 0;
        var objects = new Object[5][2];
        var arrayList = new ArrayList<Integer>();
        end = GENERALWORDS.size();
        for (var i = 0; i < 5; i++) {
            number = ThreadLocalRandom.current().nextInt(start, end);
            if (!arrayList.contains(number)) {
                if (i < 3) { // Tres palabra generales
                    arrayList.add(number);
                    objects[i][0] = GENERALWORDS.get(number);
                    objects[i][1] = number;
                    if (i == 2) { // Una palabra de interrupciones CPU
                        start = GENERALWORDS.size();
                        end = GENERALWORDS.size() + ASSEMBLERWORDS.size();
                    }
                }
                if (i == 3) { // Una palabra de instrucciones assembler
                    arrayList.add(number);
                    objects[i][0] = ALLWORDS.get(number);
                    objects[i][1] = number;
                    start = GENERALWORDS.size() + ASSEMBLERWORDS.size();
                    end = ALLWORDS.size();
                }
                if (i == 4) {
                    arrayList.add(number);
                    objects[i][0] = ALLWORDS.get(number);
                    objects[i][1] = number;
                }
            } else {
                i--;
            }
        }
        return objects;
    }

    /**
     * Obtiene la palabra a mostrar. Esta es una palabra sugerida aleatoriamente por la aplicaci&oacute;n.
     *
     * @param position Posici&oacute;n de la palabra a mostrar.
     * @return Palabra a mostrar.
     */
    public static Palabra getWordFromPosition(int position) {
        lastIndex = position;
        return ALLWORDS.get(position);
    }

    /**
     * Con la posici&oacute;n de la ultima palabra buscada o mostrada, se determina el estado <strong>Favorito</strong>
     * Agregando la palabra a la lista de Favoritos.
     *
     * @return <ul>
     * <li><strong>true:</strong> Si la palabra no es favorita se agrega a la lista.</li>
     * <li><strong>false:</strong> Si la palabra es favorita no se agrega a lista.</li>
     * </ul>
     */
    public static boolean addWordFavorite() {
        if (ALLWORDS.get(lastIndex).isFavorite()) {
            ALLWORDS.get(lastIndex).setFavorite(false);
            return false;
        } else {
            ALLWORDS.get(lastIndex).setFavorite(true);
            return true;
        }
    }

    /**
     * Elimina una palabra Favorita.
     *
     * @param word Palabra a eliminar.
     */
    public static void removeWordFavorite(String word) {
        for (var aw : ALLWORDS) {
            if (aw.getWordName().equalsIgnoreCase(word)) {
                aw.setFavorite(false);
            }
        }
    }

    /**
     * Escribe la posici&oacute;n de las palabras favoritas en un archivo plano.
     *
     * @throws IOException Se&ntilde;ala que se ha producido una excepci&oacute;n de E / S de alg&uacute;n tipo.
     */
    public static void writeWordFile() throws IOException {
        var guardar = "";
        var canalWriter = new FileWriter("./Resources/favorite.txt");
        var write = new BufferedWriter(canalWriter);
        for (var i = 0; i < ALLWORDS.size(); i++) {
            if (ALLWORDS.get(i).isFavorite()) {
                guardar = i + ";" + guardar;
            }
        }
        // System.out.println(guardar);
        write.write(guardar);
        write.close();
        canalWriter.close();
    }

    /**
     * Lee el contenido del archivo plano para identificar las palabras favoritas.
     *
     * @throws IOException Se&ntilde;ala que se ha producido una excepci&oacute;n de E / S de alg&uacute;n tipo.
     */
    public static void readWordFile() throws IOException {
        String arrWords[], temp;
        var folder = new File("./Resources");
        var file = new File("./Resources/favorite.txt");
        if (!file.exists()) {
            folder.mkdirs();
            file.createNewFile();
        }
        var canalLeer = new FileReader(file);
        var leer = new BufferedReader(canalLeer);
        if (file.length() != 0) {
            temp = leer.readLine();
            // System.out.println(temp);
            arrWords = temp.split(";");
            for (var aw : arrWords) ALLWORDS.get(Integer.parseInt(aw)).setFavorite(true);
        }
    }
}
