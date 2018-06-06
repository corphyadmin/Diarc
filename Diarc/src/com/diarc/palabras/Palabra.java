package com.diarc.palabras;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <p>Representa una palabra del diccionario. Extiende al modelo de datos que se utiliza en JFXTreeTableView,
 * el cual es utilizado para implementar&nbsp;la funci&oacute;n de agrupaci&oacute;n.</p>
 *
 * @author Luis Guillermo Gómez Galeano
 * @author Oscar Javier Gómez Sánchez
 * @author Jose Alirio Díaz Suarez
 * @version 1.0
 */

public final class Palabra extends RecursiveTreeObject<Palabra> {
    // Atributos

    /**
     * Nombre de la palabra.
     */
    private final StringProperty wordName;

    /**
     * Definici&oacute;n de la palabra.
     */
    private final StringProperty wordDefinition;

    /**
     * Ruta de la imagen de la palabra.
     */
    private final StringProperty imagePath;

    /**
     * Estado para identificar si es o no favorito.
     */
    private boolean isFavorite;

    // Constructor

    /**
     * Constructor de la clase el cual crea una nueva palabra.
     */

    public Palabra(String wordName, String wordDefinition, String imagePath) {
        this.wordName = new SimpleStringProperty(wordName);
        this.wordDefinition = new SimpleStringProperty(wordDefinition);
        this.imagePath = new SimpleStringProperty(imagePath);
        this.isFavorite = false;
    }

    /**
     * Retorna el valor del nombre de la palabra en formato String.
     *
     * @return Nombre de la palabra.
     */
    public String getWordName() {
        return wordName.get();
    }

    /**
     * Retorna el valor del nombre de la palabra en formato StringProperty.
     *
     * @return Nombre de la palabra.
     */
    public StringProperty wordNameProperty() {
        return wordName;
    }

    /**
     * Retorna el valor de la definici&oacute;n de la palabra.
     *
     * @return Definici&oacute;n de la palabra.
     */
    public String getWordDefinition() {
        return wordDefinition.get();
    }

    /**
     * Retorna el valor de la ruta de la imagen de la palabra.
     *
     * @return Ruta de la imagen de la palabra.
     */
    public String getImagePath() {
        return imagePath.get();
    }

    /**
     * Retorna el estado de la palabra.
     *
     * @return <ul>
     * <li><strong>true:</strong> Si la palabra es favorita.</li>
     * <li><strong>false:</strong> Si la palabra no es favorita.</li>
     * </ul>
     */
    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * Modifa el estado de la palabra.
     *
     * @param state <ul>
     *              <li><strong>true:</strong> Si la palabra es favorita.</li>
     *              <li><strong>false:</strong> Si la palabra no es favorita.</li>
     *              </ul>
     */
    public void setFavorite(boolean state) {
        this.isFavorite = state;
    }
}
