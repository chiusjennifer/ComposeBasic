package tw.edu.pu.s1114859.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
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
        Button(onClick = {},
            colors = buttonColors(Color.DarkGray)

        ) {
            Text(
                "按鈕",
                color = Color.White
            )

        }
        Box (
            modifier=Modifier.fillMaxSize(),
            contentAlignment= Alignment.Center
        ){
            //var count by remember { mutableStateOf(0) }
            var count = remember { mutableStateOf(0) }

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