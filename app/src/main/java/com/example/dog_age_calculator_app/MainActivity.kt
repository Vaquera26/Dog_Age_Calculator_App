package com.example.dog_age_calculator_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp
import com.example.dog_age_calculator_app.ui.theme.Dog_Age_Calculator_AppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dog_Age_Calculator_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.Center,

                    ) {
                        GreetingImage(imagen = R.drawable.perrito)
                        Spacer(modifier = Modifier.height(16.dp))
                        OutLineTextFieldSample("Ingrese su edad")
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingImage(
    imagen: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val image = painterResource(id = imagen)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(500.dp, 200.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun OutLineTextFieldSample(
    textoTF: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        var text = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = text.value,
            label = { Text(textoTF) },
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp
                )
                .width(350.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dog_Age_Calculator_AppTheme {
        Column(
            verticalArrangement = Arrangement.Center,

        ) {
            GreetingImage(imagen = R.drawable.perrito)
            Spacer(modifier = Modifier.height(80.dp))
            OutLineTextFieldSample("Ingrese su edad")
        }
    }
}