package com.example.composepractice.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun MyLazyList(){
    val marvelHeroes = mutableListOf<String>()
    for (i in 1..200){
        marvelHeroes.add("Sahil")
        marvelHeroes.add("Telina")
    }
    LazyColumn {
        itemsIndexed(marvelHeroes.toList()){ index, hero ->
            TextItem(index, hero)
        }
//        items(5000){
//            TextItem(index = it)
//        }
    }
}

@Composable
fun MyList(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(state = scrollState)
    ) {
        for (i in 1..50){
            TextItem(index = i)
        }
    }
}



@Composable
fun TextItem(index: Int = 0, text: String = "This is item"){
    Text(
        text = "$text $index",
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = colorsList.random(),
        fontWeight = FontWeight.Bold,
    )
}