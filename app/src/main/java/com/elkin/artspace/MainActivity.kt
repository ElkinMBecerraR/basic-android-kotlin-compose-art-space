package com.elkin.artspace

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = { Text("Galeria") })
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
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .padding(20.dp, 60.dp, 20.dp, 10.dp)
                .size(600.dp, 500.dp)
                .background(Color.Cyan)
                .border(2.dp, Color.Gray)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.ima_1),
                contentDescription = "1",
                modifier = Modifier.padding(40.dp)

            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .size(300.dp, 80.dp)
            ) {
                Text(text = "Hola jdskfjkdsjfds fdsfds", modifier = Modifier.padding(10.dp, 10.dp))
                Text(text = "Holaa (2017)", modifier = Modifier.padding(10.dp, 25.dp))
            }
        }

        Row() {
            Button(onClick = { /*TODO*/ },modifier = modifier.size(150.dp)) {
                Text(text = "Antes")

            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { /*TODO*/ }, modifier = modifier.size(150.dp)) {
                Text(text = "Siguiente")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PantallaGaleria(modifier = Modifier)

}