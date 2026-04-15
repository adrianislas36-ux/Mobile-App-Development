package com.example.lab_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_4.ui.theme.Lab4Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICalculatorApp()
        }
    }
}

@Composable
fun BMICalculatorApp() {

    var weightInput by remember { mutableStateOf("") }
    var heightInput by remember { mutableStateOf("") }
    var bmiResult by remember { mutableStateOf("") }
    var diagnosis by remember { mutableStateOf("") }
    var resultColor by remember { mutableStateOf(Color.Black) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Input de Peso [cite: 4]
        TextField(
            value = weightInput,
            onValueChange = { weightInput = it },
            label = { Text("Type your weight in KG") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Input de Altura [cite: 5]
        TextField(
            value = heightInput,
            onValueChange = { heightInput = it },
            label = { Text("Type your height in M") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Botón de cálculo [cite: 6]
        Button(
            onClick = {
                val weight = weightInput.toDoubleOrNull()
                val height = heightInput.toDoubleOrNull()

                // Resiliencia a errores (campos vacíos o cero)
                if (weight != null && height != null && height > 0) {
                    val bmi = weight / (height * height) // Fórmula [cite: 9, 10, 11]
                    bmiResult = "Your BMI: %.2f".format(bmi)

                    // Lógica de diagnóstico y colores [cite: 12, 13, 14, 15, 16, 18]
                    when {
                        bmi < 18.5 -> {
                            diagnosis = "Underweight"
                            resultColor = Color.Blue
                        }
                        bmi in 18.5..24.9 -> {
                            diagnosis = "Healthy"
                            resultColor = Color.Green
                        }
                        bmi in 25.0..29.9 -> {
                            diagnosis = "Overweight"
                            resultColor = Color(0xFFFFA500) // Naranja
                        }
                        else -> {
                            diagnosis = "Obesity"
                            resultColor = Color.Red
                        }
                    }
                } else {
                    diagnosis = "Please enter valid numbers"
                    bmiResult = ""
                    resultColor = Color.Black
                }
            },
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text("Calculate my BMI")
        }

        // Mostrar Resultados
        if (bmiResult.isNotEmpty()) {
            Text(
                text = bmiResult,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Text(
            text = diagnosis,
            fontSize = 22.sp,
            color = resultColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
