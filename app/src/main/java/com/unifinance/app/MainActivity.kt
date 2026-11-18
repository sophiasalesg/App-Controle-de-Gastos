package com.unifinance.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniFinanceScreen()
        }
    }
}


@Composable
fun UniFinanceScreen() {
    var saldo by remember { mutableStateOf(500.0) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "UniFinance",
                fontSize = 28.sp,
                color = Color(0xFF6D28D9)
            )

            Text("Meu controle financeiro")

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF6D28D9)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(24.dp)) {
                    Text("Saldo disponível", color = Color.White)
                    Text(
                        "R$ %.2f".format(saldo),
                        fontSize = 30.sp,
                        color = Color.White
                    )
                }
            }

            Button(
                onClick = { saldo += 100.0 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simular receita de R$ 100")
            }

            Button(
                onClick = { saldo -= 25.0 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simular despesa de R$ 25")
            }
        }
    }
}