package com.example.dog_age_calculator_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.dog_age_calculator_app.ui.theme.Dog_Age_Calculator_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dog_Age_Calculator_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DogAgeCalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun DogAgeCalculatorScreen() {
    var humanAge by remember { mutableStateOf("") }
    var dogAge by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        GreetingImage(imagen = R.drawable.perrito)
        Spacer(modifier = Modifier.height(40.dp))
        GreetingText(textolbl = "My Dog Years", size = 30.sp)

        OutLineTextFieldSample(
            labelText = "Enter your age",
            value = humanAge,
            onValueChange = { humanAge = it },
            readOnly = false
        )

        Spacer(modifier = Modifier.height(30.dp))

        ButtonWithElevation("Calculate", onClick = {
            try {
                val age = humanAge.toInt()
                dogAge = (age * 7).toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(context, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        })

        Spacer(modifier = Modifier.height(30.dp))

        OutLineTextFieldSample(
            labelText = "Dog Age",
            value = dogAge,
            onValueChange = {},
            readOnly = true
        )

        Spacer(modifier = Modifier.height(100.dp))

        ButtonWithElevation("Erase", onClick = {
            humanAge = ""
            dogAge = ""
        })
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
    labelText: String,
    value: String,
    onValueChange: (String) -> Unit,
    readOnly: Boolean
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            readOnly = readOnly,
            label = {
                Text(
                    text = labelText,
                    fontSize = 17.sp,
                    style = TextStyle(fontSize = 14.sp)
                )
            },
            onValueChange = onValueChange,
            modifier = Modifier
                .padding(
                    top = 0.dp,
                    bottom = 16.dp
                )
                .width(350.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF2FDE89),
                unfocusedBorderColor = Color(0xFF1C2541)
            )
        )
    }
}

@Composable
fun GreetingText(
    textolbl: String,
    size: androidx.compose.ui.unit.TextUnit
) {
    Column {
        Text(
            text = textolbl,
            fontWeight = FontWeight.Bold,
            fontSize = size,
            lineHeight = 28.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    bottom = 50.dp,
                    start = 30.dp
                )
        )
    }
}

@Composable
fun ButtonWithElevation(
    buttonText: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onClick,
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            modifier = Modifier
                .width(200.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1C2541),
                contentColor = Color.White
            )
        ) {
            Text(
                text = buttonText,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dog_Age_Calculator_AppTheme {
        DogAgeCalculatorScreen()
    }
}
