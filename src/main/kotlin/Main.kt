// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun boton() {
    var count = 0
    val listaImagenes = listOf("5.png", "10.png", "20.png", "50.png", "100.jpg")
    var text by remember { mutableStateOf("") }
    var comprobadorVentana by remember { mutableStateOf(false) }
    if (!comprobadorVentana) {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Surface(
                    modifier = Modifier.size(300.dp),
                    color = Color.Transparent
                ) {
                    Image(painter = painterResource("perfectCookie.png"),
                        contentDescription = "una galleta",
                        modifier = Modifier.clickable {
                            count++
                            text = count.toString()
                        })
                }
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text,
                    color = Color.Blue,
                    fontSize = 60.sp,
                    modifier = Modifier.padding(30.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(10.dp)
            ) {
                when (count) {
                    5 -> Image(
                        painter = painterResource(listaImagenes[0]),
                        contentDescription = "logro 5",
                        modifier = Modifier.height(60.dp).width(60.dp)
                    )
                    10 -> Image(
                        painter = painterResource(listaImagenes[1]),
                        contentDescription = "logro 10",
                        modifier = Modifier.height(80.dp).width(80.dp)
                    )
                    20 -> Image(
                        painter = painterResource(listaImagenes[2]),
                        contentDescription = "logro 20",
                        modifier = Modifier.height(80.dp).width(80.dp)
                    )
                    50 -> Image(
                        painter = painterResource(listaImagenes[3]),
                        contentDescription = "logro 50",
                        modifier = Modifier.height(80.dp).width(80.dp)
                    )
                    100 -> comprobadorVentana = true
                }
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(onClick = {
                    count = 0
                    text = ""
                },
                modifier = Modifier.padding(10.dp)) { Text("Restart") }
            }
        }
    }
    if (comprobadorVentana) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Felicidades has llegado a 100 clicks, debes estar muy aburrido!!",
                    fontSize = 50.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(onClick = {
                    count = 0
                    text = ""
                    comprobadorVentana = false
                },
                modifier = Modifier.padding(10.dp)
                ) { Text("Restart") }
            }
        }
    }
}


fun main() = application {
    val icon = painterResource("icono.png")
    Window(
        onCloseRequest = ::exitApplication,
        icon = icon,
        title = "clicker"
    ) {
        boton()
    }
}
