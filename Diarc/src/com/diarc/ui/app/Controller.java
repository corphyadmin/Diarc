package com.diarc.ui.app;

import com.diarc.palabras.Palabra;
import com.diarc.util.Utilidades;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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

public class Controller implements Initializable {
    @FXML
    private AnchorPane menuPane;

    // Botones del menú principal
    @FXML
    private JFXButton btnFavorite, btnRandom, btnList;

    // Imágenes que representan los iconos de los botones
    @FXML
    private ImageView imgFavorite, imgRandom, imgList;

    // Botones de del submenú
    @FXML
    private JFXButton btnExploreDiarc;

    //ToggleButton que muestra u oculta el texto de los items del menú principal
    @FXML
    private JFXToggleButton tgTextMenu;

    // Panel que contiene el submenu
    @FXML
    private AnchorPane submenuPane;

    // Panel que contiene la información de explorar Diarc
    @FXML
    private AnchorPane exploreDiarcPane;

    // Panel que muestra las palabras disponibles en el diccionario
    @FXML
    private AnchorPane listPane;

    // Botón atrás para ir al panel Inicio
    @FXML
    private JFXButton btnBack, btnBack1, btnBack2, btnBack3, btnBack4, btnBack5;

    // Palabras sugeridas
    @FXML
    private JFXButton btnWord1, btnWord2, btnWord3, btnWord4, btnWord5;

    // Campo de texto para ingresar la palabra a buscar
    @FXML
    private JFXTextField txtSearchWord;

    // Botón de búsqueda
    @FXML
    private JFXButton btnSearch;

    // Label que indica un mensaje de error en la búsqueda de la palabra
    @FXML
    private Label lbSearchError;

    // Panel que contiene la información de la palabra buscada
    @FXML
    private AnchorPane searchPane;

    // Palabra buscada por el usuario
    @FXML
    private Label lbWord;

    // Definición de la palabra buscada
    @FXML
    private TextArea txtDefinition;

    // Imagen de la palabra buscada
    @FXML
    private ImageView imgWord;

    // Botón favoritos
    @FXML
    private JFXButton btnAddFavorite;

    // Panel favoritos
    @FXML
    private AnchorPane favoritePane;

    // Tabla que muestra la lista de las palabras disponibles en el diccionario
    @FXML
    private JFXTreeTableView<Palabra> tableViewGeneral, tableViewAssembler, tableViewCpu, tableViewFavorites;

    // Campo de texto para filtrar la tabla que contiene las palabras del diccionario
    @FXML
    private JFXTextField inputFilterGeneral, inputFilterAssembler, inputFilterCpu, inputFilterFavorites;

    // Botones para ver la definición de la palabra seleccionada de una tabla
    @FXML
    private JFXButton btnShowDefGeneral, btnShowDefAssembler, btnShowDefCpu, btnShowDefFavorites, btnDeleteFavorite;

    // Atributo estático que almacena las palabras sugeridas
    private static Object[][] randomWordGroup = Utilidades.randomWordGroup();

    /**
     * Invocado para inicializar el controlador despu&eacute;s de que su elemento ra&iacute;z haya sido procesado por
     * completo. Al iniciar la aplicaci&oacute;n se ejecutan las acciones definidas en el m&eacute;todo.
     *
     * @param location  La ubicaci&oacute;n utilizada para resolver las rutas relativas para el objeto ra&iacute;z, o nulo
     *                  si la ubicaci&oacute;n no se conoce.
     * @param resources Los imagenPalabra utilizados para localizar el objeto ra&iacute;z, o null si el objeto ra&iacute;z no
     *                  fue localizado.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Lee el contenido del archivo plano para identificar las palabras favoritas.
        try {
            Utilidades.readWordFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Mostrar palabras sugeridas
        mainRandomWord();
        // Llenar tablas y filtrar su contenido
        tablesAndTextField();
        //Llenar tabla de favoritos
        updateAllTableFavorite();
        // Formatear la palabra de búsqueda ingresada
        Utilidades.textFormatted(txtSearchWord);
        // Agregar evento para poder presionar Enter al botón Buscar
        Utilidades.addEventKeyPress(menuPane, btnSearch);
    }

    /**
     * Crea el vector de tablas y el vector de campos de texto los cuales son los par&aacute;metros de los m&eacute;todos que llenan
     * las tablas con las palabras disponibles en el diccionario y filtran su contenido con su correspondiente validaci&oacute;n.
     */
    private void tablesAndTextField() {
        // Llenar la tabla con las palabras disponibles en el diccionario
        var tablaArray = new JFXTreeTableView[3];
        tablaArray[0] = tableViewGeneral;
        tablaArray[1] = tableViewAssembler;
        tablaArray[2] = tableViewCpu;
        Utilidades.fillList(tablaArray);

        // Filtrar la tabla con las palabras disponibles
        var textFieldArray = new JFXTextField[3];
        textFieldArray[0] = inputFilterGeneral;
        textFieldArray[1] = inputFilterAssembler;
        textFieldArray[2] = inputFilterCpu;
        Utilidades.filterList(tablaArray, textFieldArray);

        // Formatear la palabra de búsqueda ingresada
        Utilidades.textFormatted(inputFilterGeneral);
        Utilidades.textFormatted(inputFilterAssembler);
        Utilidades.textFormatted(inputFilterCpu);
    }

    /**
     * Actualiza la tabla de favoritos y filtra su contenido con su correspondiente validaci&oacute;n.
     */
    private void updateAllTableFavorite() {
        Utilidades.fillListFavorites(tableViewFavorites);
        Utilidades.filterListFavorite(tableViewFavorites, inputFilterFavorites);
        Utilidades.textFormatted(inputFilterFavorites);
        // System.out.println("Se ha actualizado toda la tabla de favoritos.");
    }

    /**
     * Actualiza el texto de las palabras sugeridas.
     */
    private void mainRandomWord() {
        btnWord1.setText(((Palabra) randomWordGroup[0][0]).getWordName());
        btnWord2.setText(((Palabra) randomWordGroup[1][0]).getWordName());
        btnWord3.setText(((Palabra) randomWordGroup[2][0]).getWordName());
        btnWord4.setText(((Palabra) randomWordGroup[3][0]).getWordName());
        btnWord5.setText(((Palabra) randomWordGroup[4][0]).getWordName());
    }

    /**
     * Actualiza el texto de la palabra buscada o mostrada.
     *
     * @param name       Nombre de la palabra.
     * @param definition Definici&oacute;n de la palabra.
     * @param imagePath  Ruta de la imagen de la palabra.
     */
    private void fillWord(String name, String definition, String imagePath) {
        lbWord.setText(name);
        txtDefinition.setText(definition);
        if (!imagePath.isEmpty()) imgWord.setImage(new Image(imagePath));
    }

    /**
     * Comprueba si es o no favorita y cambia el estado del icono de Favoritos.
     *
     * @param isSelected <ul>
     *                   <li><strong>true:</strong> Si la palabra es favorita el icono estar&aacute; activo.</li>
     *                   <li><strong>false:</strong> Si la palabra no es favorita el icono estar&aacute; desactivado.</li>
     *                   </ul>
     */
    private void establishIcon(boolean isSelected) {
        if (isSelected) {
            var imageView = new ImageView(new Image("/com/diarc/imagenes/addFavoriteActive.png"));
            imageView.setFitWidth(34);
            imageView.setFitHeight(34);
            btnAddFavorite.setGraphic(imageView);
        } else {
            var imageView = new ImageView(new Image("/com/diarc/imagenes/addFavorite.png"));
            imageView.setFitWidth(34);
            imageView.setFitHeight(34);
            btnAddFavorite.setGraphic(imageView);
        }
    }

    /**
     * M&eacute;todo principal que controla la visibilidad de los paneles.
     *
     * @param event Evento que indica que se produjo una acci&oacute;n en este caso un clic en una de las opciones del men&uacute;.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnExploreDiarc) {
            exploreDiarcPane.setVisible(true);
            searchPane.setVisible(false);
            favoritePane.setVisible(false);
            listPane.setVisible(false);
        } else if (event.getSource() == btnFavorite) {
            // Actualizar tabla de favoritos
            updateAllTableFavorite();
            favoritePane.setVisible(true);
            searchPane.setVisible(false);
            listPane.setVisible(false);
            exploreDiarcPane.setVisible(false);
        } else if (event.getSource() == btnList) {
            listPane.setVisible(true);
            searchPane.setVisible(false);
            favoritePane.setVisible(false);
            exploreDiarcPane.setVisible(false);
        } else {
            if (event.getSource() == btnBack) {
                exploreDiarcPane.setVisible(false);
                // Generar palabras sugeridas
                randomWordGroup = Utilidades.randomWordGroup();
                // Mostrar palabras sugeridas
                mainRandomWord();
            }
            if (event.getSource() == btnBack2 || event.getSource() == btnBack3 || event.getSource() == btnBack4) {
                //establece el botón favoritos sin activar
                establishIcon(false);
                listPane.setVisible(false);
                // Generar palabras sugeridas
                randomWordGroup = Utilidades.randomWordGroup();
                // Mostrar palabras sugeridas
                mainRandomWord();
            }
            if (event.getSource() == btnBack5) {
                //establece el botón favoritos sin activar
                establishIcon(false);
                favoritePane.setVisible(false);
                // Generar palabras sugeridas
                randomWordGroup = Utilidades.randomWordGroup();
                // Mostrar palabras sugeridas
                mainRandomWord();
            }
        }
    }

    /**
     * Realiza la b&uacute;squeda de la palabra ingresada y muestra el panel con los resultados obtenidos.
     *
     * @param event Evento que indica que se produjo una acci&oacute;n en este caso un clic en el bot&oacute;n de b&uacute;squeda.
     */
    @FXML
    private void searchWord(ActionEvent event) {
        if (event.getSource() == btnSearch) {
            var searchWord = txtSearchWord.getText().trim();
            if (!searchWord.isEmpty()) {
                var word = Utilidades.containsWord(searchWord);
                if (word != null) {
                    lbSearchError.setVisible(false);
                    imgWord.setImage(null);
                    // Mostar Palabra
                    fillWord(word.getWordName(), word.getWordDefinition(), word.getImagePath());
                    establishIcon(word.isFavorite());
                    favoritePane.setVisible(false);
                    exploreDiarcPane.setVisible(false);
                    listPane.setVisible(false);
                    searchPane.setVisible(true);
                } else {
                    lbSearchError.setText("La palabra no está disponible");
                    lbSearchError.setVisible(true);
                }
            } else {
                lbSearchError.setVisible(false);
            }
        } else if (event.getSource() == btnBack1) {
            searchPane.setVisible(false);
            // Generar palabras sugeridas
            randomWordGroup = Utilidades.randomWordGroup();
            // Mostrar palabras sugeridas
            mainRandomWord();
        }
    }

    /**
     * Muestra la palabra sugerida dependiendo de la opci&oacute;n del usuario.
     *
     * @param event Evento que indica que se produjo una acci&oacute;n en este caso un clic en la palabra sugerida.
     */
    @FXML
    private void showSuggestedWord(ActionEvent event) {
        Palabra temp;
        imgWord.setImage(null);
        if (event.getSource() == btnWord1) {
            temp = Utilidades.getWordFromPosition((int) randomWordGroup[0][1]);
            fillWord(temp.getWordName(), temp.getWordDefinition(), temp.getImagePath());
            establishIcon(temp.isFavorite());
        } else if (event.getSource() == btnWord2) {
            temp = Utilidades.getWordFromPosition((int) randomWordGroup[1][1]);
            fillWord(temp.getWordName(), temp.getWordDefinition(), temp.getImagePath());
            establishIcon(temp.isFavorite());
        } else if (event.getSource() == btnWord3) {
            temp = Utilidades.getWordFromPosition((int) randomWordGroup[2][1]);
            fillWord(temp.getWordName(), temp.getWordDefinition(), temp.getImagePath());
            establishIcon(temp.isFavorite());
        } else if (event.getSource() == btnWord4) {
            temp = Utilidades.getWordFromPosition((int) randomWordGroup[3][1]);
            fillWord(temp.getWordName(), temp.getWordDefinition(), temp.getImagePath());
            establishIcon(temp.isFavorite());
        } else if (event.getSource() == btnWord5) {
            temp = Utilidades.getWordFromPosition((int) randomWordGroup[4][1]);
            fillWord(temp.getWordName(), temp.getWordDefinition(), temp.getImagePath());
            establishIcon(temp.isFavorite());
        }
        searchPane.setVisible(true);
    }

    /**
     * Ejecuta el método para agregar o eliminar una palabra de la lista de favoritos.
     */
    @FXML
    private void addFavorite() {
        establishIcon(Utilidades.addWordFavorite());
    }

    /**
     * Muestra una palabra aleatoria.
     */
    @FXML
    private void showRandomWord() {
        var randomWord = Utilidades.randomWord();
        establishIcon(false);
        imgWord.setImage(null);
        fillWord(randomWord.getWordName(), randomWord.getWordDefinition(), randomWord.getImagePath());
        favoritePane.setVisible(false);
        listPane.setVisible(false);
        exploreDiarcPane.setVisible(false);
        searchPane.setVisible(true);
    }

    /**
     * Muestra la palabra seleccionada de cualquiera de las tablas de la aplicaci&oacute;n.
     *
     * @param event Evento clic que identifica el bot&oacute;n de la tabla correspondiente para mostrar la
     *              definici&oacute;n de la palabra.
     */
    @FXML
    private void getSelectionWord(ActionEvent event) {
        Palabra word = null;
        var isDelete = false;
        imgWord.setImage(null);
        try {
            if (event.getSource() == btnShowDefGeneral) {
                if (tableViewGeneral.getSelectionModel().getSelectedItem() != null) {
                    word = Utilidades.containsWord(tableViewGeneral.getSelectionModel().getSelectedItem().getValue().getWordName());
                    fillWord(word.getWordName(), word.getWordDefinition(), word.getImagePath());
                }
            } else if (event.getSource() == btnShowDefAssembler) {
                if (tableViewAssembler.getSelectionModel().getSelectedItem() != null) {
                    word = Utilidades.containsWord(tableViewAssembler.getSelectionModel().getSelectedItem().getValue().getWordName());
                    fillWord(word.getWordName(), word.getWordDefinition(), word.getImagePath());
                }
            } else if (event.getSource() == btnShowDefCpu) {
                if (tableViewCpu.getSelectionModel().getSelectedItem() != null) {
                    word = Utilidades.containsWord(tableViewCpu.getSelectionModel().getSelectedItem().getValue().getWordName());
                    fillWord(word.getWordName(), word.getWordDefinition(), word.getImagePath());
                }
            } else if (event.getSource() == btnShowDefFavorites) {
                if (tableViewFavorites.getSelectionModel().getSelectedItem() != null) {
                    word = Utilidades.containsWord(tableViewFavorites.getSelectionModel().getSelectedItem().getValue().getWordName());
                    fillWord(word.getWordName(), word.getWordDefinition(), word.getImagePath());
                }
            } else if (event.getSource() == btnDeleteFavorite) {
                if (tableViewFavorites.getSelectionModel().getSelectedItem() != null) {
                    Utilidades.removeWordFavorite(tableViewFavorites.getSelectionModel().getSelectedItem().getValue().getWordName());
                    updateAllTableFavorite();
                    isDelete = true;
                }
            }
            if (!isDelete) {
                establishIcon(word.isFavorite());
                favoritePane.setVisible(false);
                listPane.setVisible(false);
                searchPane.setVisible(true);
            }
        } catch (Exception e) {
            e.getCause();
        }
    }

    /**
     * Muestra u oculta el sub-menú o menú secundario.
     */
    @FXML
    private void showMenu() {
        if (submenuPane.visibleProperty().getValue()) {
            submenuPane.setVisible(false);
            submenuPane.toBack();
        } else {
            submenuPane.toFront();
            submenuPane.setVisible(true);
        }
    }

    /**
     * Muestra el texto que indica la funcionalidad de los botones del menú.
     */
    @FXML
    private void showTextMenu() {
        if (tgTextMenu.isSelected()) {
            imgFavorite.setFitHeight(32);
            btnFavorite.setContentDisplay(ContentDisplay.TOP);
            imgRandom.setFitHeight(32);
            btnRandom.setContentDisplay(ContentDisplay.TOP);
            imgList.setFitHeight(32);
            btnList.setContentDisplay(ContentDisplay.TOP);
        } else {
            imgFavorite.setFitHeight(40);
            btnFavorite.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            imgRandom.setFitHeight(40);
            btnRandom.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            imgList.setFitHeight(40);
            btnList.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }

    /**
     * Muestra la informaci&oacute;n acerca del proyecto.
     */
    @FXML
    private void showAbout() {
        Utilidades.loadWindow(getClass().getResource("/com/diarc/ui/acercaDe/acercaDe.fxml"), "Acerca de");
    }
}