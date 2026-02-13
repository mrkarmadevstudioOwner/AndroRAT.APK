package com.lunex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            // LoginScreen will be provided by feature-auth module
            // LoginScreen(
            //     onNavigateToDashboard = { navController.navigate("dashboard") }
            // )
        }
        
        composable("dashboard") {
            // DashboardScreen will be provided by feature-dashboard module
            // DashboardScreen(
            //     onNavigateToBilling = { navController.navigate("billing") }
            // )
        }
        
        composable("billing") {
            // BillingScreen will be provided by feature-billing module
        }
    }
}
