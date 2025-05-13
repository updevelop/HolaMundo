package com.updevelop.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.updevelop.holamundo.ui.theme.HolaMundoTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HolaMundoTheme {
                var mensaje by remember { mutableStateOf("Hola mundo!") }
                var nombreUsuario by remember { mutableStateOf("") }

                Greeting(
                    mensaje = mensaje,
                    nombreUsuario = nombreUsuario,
                    onNombreChange = { nombreUsuario = it },
                    onCambiarClick = {
                        mensaje = if (nombreUsuario.isNotBlank())
                            "Hola, $nombreUsuario 👋"
                        else
                            "Por favor ingresa tu nombre"
                    },
                    onResetClick = {
                        mensaje = "Hola mundo!"
                        nombreUsuario = ""
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(
    mensaje: String,
    nombreUsuario: String,
    onNombreChange: (String) -> Unit,
    onCambiarClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = mensaje,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = nombreUsuario,
                onValueChange = onNombreChange,
                label = { Text("Ingresa tu nombre") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onCambiarClick) {
                Text("Mostrar Saludo")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = onResetClick) {
                Text("Reiniciar")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HolaMundoTheme {
        Greeting(
            mensaje = "Hola mundo!",
            nombreUsuario = "Sergio",
            onNombreChange = {},
            onCambiarClick = {},
            onResetClick = {}
        )
    }
}