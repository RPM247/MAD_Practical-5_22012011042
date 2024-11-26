package com.rpm24.mad_practical_5_22012011042

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.rpm24.mad_practical_5_22012011042.screen.LoginScreen
import com.rpm24.mad_practical_5_22012011042.screen.components.AppNavigation
import com.rpm24.mad_practical_5_22012011042.ui.theme.MAD_Practical5_22012011042Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MAD_Practical5_22012011042Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(context = this, navController = navController , paddingValues = innerPadding)
                }
            }
        }
    }
}

@SuppressLint("ShowToast")
fun showMsg(context: Context, msg: String){
    val toast = Toast.makeText(context, msg,Toast.LENGTH_SHORT)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAD_Practical5_22012011042Theme {
        val mockNavController = TestNavHostController(LocalContext.current)
        LoginScreen(navController = mockNavController)
    }
}

