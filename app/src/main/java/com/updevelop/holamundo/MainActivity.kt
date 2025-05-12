package com.updevelop.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
        enableEdgeToEdge()
        setContent {
            HolaMundoTheme {
                var mensaje by remember { mutableStateOf("Hola mundo!") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        mensaje = mensaje,
                        modifier = Modifier.padding(innerPadding),
                        onCambiarClick = {
                            mensaje = "¡Bienvenido a Up Develop!"
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    mensaje: String,
    modifier: Modifier = Modifier,
    onCambiarClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = mensaje,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onCambiarClick) {
            Text("Cambiar Mensaje")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HolaMundoTheme {
        Greeting(
            mensaje = "Hola mundo!",
            onCambiarClick = {}, // función vacía
        )
    }
}