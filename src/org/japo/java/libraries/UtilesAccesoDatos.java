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
package org.japo.java.libraries;

import org.japo.java.controllers.DAControllerCSV;
import org.japo.java.controllers.DAControllerJSON;
import org.japo.java.controllers.DAControllerPRP;
import org.japo.java.controllers.DAControllerSBIN;
import org.japo.java.controllers.DAControllerSXML;
import org.japo.java.controllers.IDAController;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesAccesoDatos {

    // Tipos Persistencia
    public static final String PERSISTENCE_TYPE_CSV = "CSV";
    public static final String PERSISTENCE_TYPE_JSON = "JSON";
    public static final String PERSISTENCE_TYPE_PRP = "PRP";
    public static final String PERSISTENCE_TYPE_SBIN = "SBIN";
    public static final String PERSISTENCE_TYPE_SXML = "SXML";

    // Devuelve el Controlador de Persistencia
    public static final IDAController obtenerControladorAccesoDatos(String tipo) {
        // Referencia DAC
        IDAController dac;

        // Instancia Controlador Fersistencia
        switch (tipo) {
            case PERSISTENCE_TYPE_CSV:
                dac = new DAControllerCSV();
                break;
            case PERSISTENCE_TYPE_PRP:
                dac = new DAControllerPRP();
                break;
            case PERSISTENCE_TYPE_SBIN:
                dac = new DAControllerSBIN();
                break;
            case PERSISTENCE_TYPE_SXML:
                dac = new DAControllerSXML();
                break;
            case PERSISTENCE_TYPE_JSON:
            default:
                dac = new DAControllerJSON();
        }

        // Devuelve Controlador Persistencia
        return dac;
    }
}
