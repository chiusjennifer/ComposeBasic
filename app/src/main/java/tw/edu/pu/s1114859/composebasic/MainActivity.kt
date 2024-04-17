package tw.edu.pu.s1114859.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.s1114859.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Compose實例")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var msg by remember { mutableStateOf("行動應用軟體開發")}
    var count = remember { mutableStateOf(0) }
    var password by remember { mutableStateOf("") }

    Column {
        TextField(
            value = msg,
            onValueChange = { newText ->
                msg = newText
            },
            label = { Text(text = "訊息") },
            placeholder = { Text(text = "請輸入您的訊息") },
            keyboardOptions = KeyboardOptions
                (keyboardType = KeyboardType.Number)

        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "請輸入密碼") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions
                (keyboardType = KeyboardType.Password)
        )



        Row {
            Text(
                text = "$name ",
                fontFamily = FontFamily(Font(R.font.hand)),
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = modifier
            )
            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "圖片",
                alpha = 0.5f,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)

            )


        }
        Button(onClick = {
            if (msg == "行動應用軟體開發"){
                msg = "Android App"
                count.value=0
            }
            else{
                msg = "行動應用軟體開發"
            }

        },
            colors = buttonColors(Color.DarkGray),
            shape= RoundedCornerShape(20.dp),
            //shape= CutCornerShape(10)
            border= BorderStroke(1.dp, Color.Blue),
            elevation =  ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp

            )
        ){
            Image(
                painterResource(id = R.drawable.animal0),
                contentDescription ="黃色小鴨",
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "按鈕 ",
                color = Color.Magenta
            )
            Text(
                text = msg,
                color = Color.Green
            )


        }
        Box (
            modifier=Modifier.fillMaxSize(),
            contentAlignment= Alignment.Center
        ){
            //var count by remember { mutableStateOf(0) }


            Text(
            text = count.value.toString(),
            fontSize = 50.sp,
            modifier = Modifier.clickable { count.value += 1 }
        )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}