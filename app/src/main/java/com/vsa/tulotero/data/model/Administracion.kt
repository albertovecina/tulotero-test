package com.vsa.tulotero.data.model

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
data class Administracion(
    var id: String? = "",
    var nombre: String? = "",
    var urlFoto: String? = "",
    var telefono: String? = "",
    var poblacion: String? = "",
    var direccion: String? = "",
    var latitud: Double? = 0.0,
    var longitud: Double? = 0.0,
    var enabled: Boolean = false,
    var mail: String? = "",
    var provincia: String? = "",
    var codigoPostal: String? = "",
    var licencia: String? = "",
    var licenciaNombre: String? = "",
    var licenciaApellidos: String? = "",
    var licenciaDni: String? = "",
    var numero: String? = "",
    var comercial: String? = "",
    var mapImage: String? = ""
)