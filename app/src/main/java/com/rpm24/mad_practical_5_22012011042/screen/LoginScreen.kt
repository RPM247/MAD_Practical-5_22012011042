package com.rpm24.mad_practical_5_22012011042.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.rpm24.mad_practical_5_22012011042.components.FormField
import com.rpm24.mad_practical_5_22012011042.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.rpm24.mad_practical_5_22012011042.showMsg
import com.rpm24.mad_practical_5_22012011042.ui.theme.MAD_Practical5_22012011042Theme

@Composable
fun LoginScreen(context: Context?=null, modifier: Modifier = Modifier, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                FormField(label = "Email", textState = email, onTextChange = { email = it })
                FormField(label = "Password", isPassword = true, textState = password, onTextChange = { password = it })
                Text(
                    text = "Forgot Password",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.End)
                )
                Button(
                    onClick = {
                        showMsg(context!!,"Login Successfully!!!")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ){
                    Text("LOGIN", fontSize = 18.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Don't have an account?   ",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
            Text(
                text = "SIGN UP",
                fontSize = 16.sp,
                color = colorResource(id = R.color.purple_200),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .clickable{
                        navController.navigate("registration")
                    }
            )
        }
    }
}
@Preview
@Composable
fun LoginPreview(){
    MAD_Practical5_22012011042Theme {
        val mockNavController = TestNavHostController(LocalContext.current)
        LoginScreen(navController = mockNavController)
    }
}

