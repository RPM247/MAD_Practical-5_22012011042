package com.rpm24.mad_practical_5_22012011042.screen.components

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rpm24.mad_practical_5_22012011042.screen.LoginScreen
import com.rpm24.mad_practical_5_22012011042.screen.RegistrationScreen


@Composable
fun AppNavigation(context: Context, navController: NavHostController, paddingValues: PaddingValues){
    NavHost(navController = navController, startDestination = "login")
    {
        composable("login")
        {
            LoginScreen(context,
                navController = navController,
            )
        }
        composable("registration") {
            RegistrationScreen(context,
                navController = navController,
            )
        }
    }
}