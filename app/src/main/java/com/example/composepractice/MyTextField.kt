package com.example.composepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun TextFieldPractice(){

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var textFieldState by remember {
        mutableStateOf("")
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            MyEt(
                textState = textFieldState,
                onChange = {
                    textFieldState = it
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            GreetButton(
                onButtonClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            textFieldState
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun MyEt(
    textState: String,
    onChange: (String) -> Unit
){

    OutlinedTextField(
        value = textState,
        onValueChange = {
            onChange(it)
        },
        label = {
            Text(text = "Enter Your Name")
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun GreetButton(
    text: String = "Greet",
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onButtonClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(36.dp)
    ) {
        Text(
            text = text,
                modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}