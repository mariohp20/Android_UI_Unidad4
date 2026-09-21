package com.pe.lugaresapp

data class Lugar(
    val nombre: String,
    val descripcion: String,
    val imagenUrl: String
)

fun listaDeLugares() = listOf(
    Lugar(
        "Plaza de Armas de Lima",
        "Centro histórico y político de la ciudad, rodeado de edificios coloniales.",
        "https://picsum.photos/seed/plazadearmas/600/400"
    ),
    Lugar(
        "Parque Kennedy",
        "Conocido por sus gatos callejeros y su ambiente bohemio en Miraflores.",
        "https://picsum.photos/seed/parquekennedy/600/400"
    ),
    Lugar(
        "Circuito Mágico del Agua",
        "El complejo de fuentes más grande del mundo, con shows de luz y agua.",
        "https://picsum.photos/seed/circuitomagico/600/400"
    ),
    Lugar(
        "Malecón de Miraflores",
        "Extenso paseo frente al mar, ideal para caminar o ver el atardecer.",
        "https://picsum.photos/seed/maleconmiraflores/600/400"
    ),
    Lugar(
        "Huaca Pucllana",
        "Sitio arqueológico preincaico en pleno distrito de Miraflores.",
        "https://picsum.photos/seed/huacapucllana/600/400"
    ),
    Lugar(
        "Barranco",
        "Distrito bohemio conocido por su arte urbano y vida nocturna.",
        "https://picsum.photos/seed/barranco/600/400"
    )
)

data class LugaresUiState(
    val lugares: List<Lugar> = listaDeLugares(),
    val lugarSeleccionado: Lugar? = null
)