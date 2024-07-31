package com.elkin.artspace

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elkin.artspace.ui.theme.ArtSpaceTheme
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ), title = { Text("Escudos de Equipos") })
                    },

                    ) { innerPadding ->
                    PantallaGaleria(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaGaleria(modifier: Modifier = Modifier) {
    val primeraImagen = R.drawable.colombia
    val segundaImagen = R.drawable.milan
    var terceraImagen = R.drawable.soccer_badge

    var titulo by remember {
        mutableStateOf(R.string.Imagen_uno)
    }

    var anio by remember {
        mutableStateOf(R.string.Imagen_uno)
    }

    var imagenActual by remember {
        mutableStateOf(primeraImagen)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PantallaImagen(imagenActual = imagenActual)
        TituloImagen(titulo = titulo, anio = anio)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {
                    when (imagenActual) {
                        primeraImagen -> {
                            imagenActual = terceraImagen
                            titulo = R.string.Imagen_tres
                            anio = R.string.Imagen_tres
                        }

                        segundaImagen -> {
                            imagenActual = primeraImagen
                            titulo = R.string.Imagen_uno
                            anio = R.string.Imagen_uno
                        }

                        else -> {
                            imagenActual = segundaImagen
                            titulo = R.string.Imagen_dos
                            anio = R.string.Imagen_dos
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Anterior",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Blue
                )

            }

            // siguiente boton
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {
                when (imagenActual) {
                    primeraImagen -> {
                        imagenActual = segundaImagen
                        titulo = R.string.Imagen_dos
                        anio = R.string.Imagen_dos
                    }

                    segundaImagen -> {
                        imagenActual = terceraImagen
                        titulo = R.string.Imagen_tres
                        anio = R.string.Imagen_tres
                    }

                    else -> {
                        imagenActual = primeraImagen
                        titulo = R.string.Imagen_uno
                        anio = R.string.Imagen_uno
                    }
                }
            }, colors = ButtonDefaults.buttonColors()) {
                Text(
                    text = "Siguiente",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Blue
                )

            }

        }
    }
}

@Composable
fun PantallaImagen(modifier: Modifier = Modifier, @DrawableRes imagenActual: Int) {
    Image(
        painter = painterResource(imagenActual),
        contentDescription = stringResource(R.string.Imagen_uno),
        modifier = modifier
            .fillMaxWidth()
            .padding(50.dp, 100.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TituloImagen(@StringRes titulo: Int, @StringRes anio: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = titulo),
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            fontSize = 32.sp
        )

        Text(
            text = stringResource(id = anio),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PantallaGaleria(modifier = Modifier)

}