package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.MyLazyList
import com.example.composepractice.ui.theme.MyList
import com.example.composepractice.ui.theme.colorsList

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLazyList()
//            TextFieldPractice()
//            MyList()
//            MainScreen()
        }
    }
}

@Composable
@Preview
fun ColorfulBox(modifier: Modifier = Modifier){
    val colorState = remember {
        mutableStateOf(colorsList[0])
    }
    Box(modifier = modifier
        .fillMaxSize()
        .background(
            color = colorState.value
        ),
        contentAlignment = Alignment.Center
    ) {
        MediumButton(
            onButtonClick = {
                colorState.value = it
        })
    }
}

@Composable
fun MediumButton(
    text: String = "Change Color",
    onButtonClick: (Color) -> Unit
){
    Button(
        onClick = {
            onButtonClick(colorsList.random())
        },
        modifier = Modifier.background(color = Color.White)
    ) {
        Text(text = text, color = Color.Magenta)
    }
}

@Composable
fun MainScreen(name: String = "sahil khan") {

//    ColorfulBox()
//    Text(text = "Hello $name!",
//        color = Color.White,
//        textAlign = TextAlign.Center)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}

@Composable
fun MainBoxScreen(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.Magenta
            )
    ) {
        MainScreen(name = "Sahil khan")
    }
}