/* 
 * Copyright 2018 - José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.controllers;

import org.japo.java.libraries.UtilesAccesoDatos;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.japo.java.models.Model;
import org.japo.java.views.View;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class Controller {

    // Propiedades
    public static final String PRP_PERSISTENCE_TYPE = "persistence_type";
    public static final String PRP_PERSISTENCE_FILENAME = "persistence_filename";

    // Valores por defecto
    public static final String DEF_PERSISTENCE_TYPE = UtilesAccesoDatos.PERSISTENCE_TYPE_JSON;
    public static final String DEF_PERSISTENCE_FILENAME = "data.json";

    // Referencias
    private final Properties prp;
    private final Model model;
    private final View view;
    private final IDAController dac;

    // Constructor Predeterminado
    public Controller(Properties prp) {
        // Memoriza Referencias
        this.prp = prp;

        // Crear Modelo
        model = new Model();

        // Controlador de Acceso a Datos
        dac = UtilesAccesoDatos.obtenerControladorAccesoDatos(prp.getProperty(PRP_PERSISTENCE_TYPE, DEF_PERSISTENCE_TYPE));

        // Crear Vista
        view = new View(model, this, prp);
    }
    
    // Arranque del programa
    public final void start() {
        EventQueue.invokeLater(() -> {
            view.setVisible(true);
        });
    }

    // Persistencia > Modelo > Vista
    public void importarPersistencia(ActionEvent evt) {
        try {
            // Fichero de Datos
            String fichero = prp.getProperty(PRP_PERSISTENCE_FILENAME, DEF_PERSISTENCE_FILENAME);

            // Persistencia > Modelo
            dac.importarModelo(model, fichero);

            // Modelo > Vista
            sincronizarModeloVista(model, view);

            // Mensaje - Importación OK
            JOptionPane.showMessageDialog(view, "Datos importados correctamente");
        } catch (Exception e) {
            // Mensaje - Importación NO
            JOptionPane.showMessageDialog(view, "Error al importar los datos");
        }
    }

    // Vista > Modelo > Persistencia
    public void exportarPersistencia(ActionEvent evt) {
        // Validar Datos Vista
        if (validarControlesSubjetivos(view)) {
            try {
                // Vista > Modelo
                sincronizarVistaModelo(view, model);

                // Fichero de Datos
                String fichero = prp.getProperty(PRP_PERSISTENCE_FILENAME, DEF_PERSISTENCE_FILENAME);

                // Modelo > Persistencia
                dac.exportarModelo(model, fichero);

                // Mensaje - Exportación OK
                JOptionPane.showMessageDialog(view, "Datos exportados correctamente");
            } catch (Exception e) {
                // Mensaje - Exportación NO
                JOptionPane.showMessageDialog(view, "Error al exportar los datos");
            }
        } else {
            // Mensaje - Validación Pendiente
            JOptionPane.showMessageDialog(view, "Hay datos erróneos.");
        }
    }

    // Modelo > Vista 
    public void sincronizarModeloVista(Model model, View view) {

    }

    // Vista (Subjetivo) > Modelo
    private void sincronizarVistaModelo(View view, Model model) {

    }

    // Validar Controles Subjetivos
    private boolean validarControlesSubjetivos(View view) {
//        // Validación Controles Subjetivos
//        boolean item1OK = UtilesValidacion.validarCampoTexto(view.txfItem1, Model.ER_ITEM1, "?");
//        boolean item2OK = UtilesValidacion.validarCampoTexto(view.txfItem2, Model.ER_ITEM2, "?");
//
//        // Devolver Validación
//        return item1OK && item2OK;
        return true;
    }
}
