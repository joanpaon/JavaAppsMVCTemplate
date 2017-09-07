/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
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
package org.japo.java.main;

import java.util.Properties;
import org.japo.java.controllers.Controller;
import org.japo.java.controllers.DAControllerFactory;
import org.japo.java.libraries.UtilesApp;
import org.japo.java.libraries.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class Main {

    // Fichero Propiedades Aplicación
    public static final String FICHERO_PROPIEDADES = "app.properties";

    // Propiedades App
    public static final String PRP_PUERTO_BLOQUEO = "gui.puerto_bloqueo";
    public static final String PRP_LOOK_AND_FEEL = "gui.look_and_feel";
    public static final String PRP_RUTA_FAVICON = "gui.ruta_favicon";
    public static final String PRP_DA_FILE = "da.fichero";
    public static final String PRP_DA_TYPE = "da.tipo";

    // Valores por Defecto
    public static final String DEF_PUERTO_BLOQUEO = "54321";    
    public static final String DEF_LOOK_AND_FEEL = UtilesSwing.LNF_WINDOWS;    
    public static final String DEF_RUTA_FAVICON = "img/favicon.png";   
    public static final String DEF_DA_FILE = "datos.json";
    public static final String DEF_DA_TYPE = DAControllerFactory.DA_TYPE_JSON;

    // Punto de entrada a la aplicación
    public static void main(String[] args) {
        // Inicializa Aplicación
        Main main = new Main();

        // Ejecuta la Aplicación
        main.launchApp();
    }

    // Ejecuta la aplicación
    private void launchApp() {
        // Cargar Propiedades Aplicación
        Properties prpApp = UtilesApp.cargarPropiedades(FICHERO_PROPIEDADES);

        // Crear Controlador
        Controller control = new Controller(prpApp);
    }
}
