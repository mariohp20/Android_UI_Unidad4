package com.pe.lugaresapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LugaresApp(
    windowSizeClass: WindowWidthSizeClass,
    viewModel: LugaresViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when (windowSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            Scaffold(
                topBar = { TopAppBar(title = { Text("Lugares para visitar") }) }
            ) { innerPadding ->
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                ) {
                    ListaLugares(
                        lugares = uiState.lugares,
                        onLugarClick = viewModel::seleccionarLugar,
                        modifier = Modifier.weight(1f)
                    )
                    DetalleLugar(
                        lugar = uiState.lugarSeleccionado ?: uiState.lugares.first(),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        else -> {
            if (uiState.lugarSeleccionado == null) {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Lugares para visitar") }) }
                ) { innerPadding ->
                    ListaLugares(
                        lugares = uiState.lugares,
                        onLugarClick = viewModel::seleccionarLugar,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            } else {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(uiState.lugarSeleccionado!!.nombre) },
                            navigationIcon = {
                                IconButton(onClick = viewModel::volverALaLista) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = "Volver a la lista")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    DetalleLugar(
                        lugar = uiState.lugarSeleccionado!!,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ListaLugares(lugares: List<Lugar>, onLugarClick: (Lugar) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(horizontal = 12.dp)) {
        items(lugares) { lugar ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onLugarClick(lugar) },
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = lugar.imagenUrl,
                        contentDescription = lugar.nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(8.dp)
                    )
                    Text(
                        text = lugar.nombre,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}

@Composable
fun DetalleLugar(lugar: Lugar, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        AsyncImage(
            model = lugar.imagenUrl,
            contentDescription = lugar.nombre,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = lugar.nombre, fontWeight = FontWeight.Bold, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = lugar.descripcion, fontSize = 16.sp)
    }
}