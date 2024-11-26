package com.rpm24.mad_practical_5_22012011042.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.rpm24.mad_practical_5_22012011042.R
import com.rpm24.mad_practical_5_22012011042.components.FormField
import com.rpm24.mad_practical_5_22012011042.showMsg
import com.rpm24.mad_practical_5_22012011042.ui.theme.MAD_Practical5_22012011042Theme

@Composable
fun RegistrationScreen(context: Context?=null, modifier: Modifier = Modifier, navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val scrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            FormField(label = "Name", textState = name, onTextChange = { name = it })
            FormField(label = "Phone Number", isNumber = true, textState = phone, onTextChange = { phone = it })
            FormField(label = "City", textState = city, onTextChange = { city = it })
            FormField(label = "Name", textState = name, onTextChange = { name = it })
            FormField(label = "Email", textState = email, onTextChange = { email = it })
            FormField(label = "Password", isPassword = true, textState = password, onTextChange = { password = it })
            FormField(label = "Confirm Password", isPassword = true, textState = confirmPassword, onTextChange = { confirmPassword = it })

            Button(
                onClick = {
                    showMsg(context!!,"Login Successfully")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ){
                Text(text = "REGISTER", fontSize = 18.sp)

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Do you have an account?   ",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
            Text(
                text = "LOGIN",
                fontSize = 16.sp,
                color = colorResource(id=R.color.pink),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 50.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    MAD_Practical5_22012011042Theme {
        val mockNavController = TestNavHostController(LocalContext.current)
        RegistrationScreen(navController = mockNavController)
    }
}