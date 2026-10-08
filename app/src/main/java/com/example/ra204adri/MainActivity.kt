package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "pantalla1") {
        composable("pantalla1") { Pantalla1(navController) }
        composable("pantalla2") { Pantalla2(navController) }
        composable("pantalla3") { Pantalla3(navController) }
    }
}

@Composable
fun Pantalla1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla 1", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { navController.navigate("pantalla2") }) {
            Text("Ir a Pantalla 2")
        }
    }
}

@Composable
fun Pantalla2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla 2", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { navController.navigate("pantalla3") }) {
            Text("Ir a Pantalla 3")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}

@Composable
fun Pantalla3(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla 3", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { navController.navigate("pantalla1") }) {
            Text("Ir a Pantalla 1")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}