package com.example.piano

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piano.ui.theme.PianoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PianoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)





                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
piano();
}
@Composable
fun piano(){

    val raws = arrayOf(R.raw.doo,R.raw.re,R.raw.mi,R.raw.fa,R.raw.sol,R.raw.la,R.raw.si,);
    val context = LocalContext.current
    Column (
        Modifier
            .fillMaxSize()
            .background(Color.Black)){
        Row(Modifier.weight(0.5f).fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Bechstein" ,color = Color.Red,modifier = Modifier.align(Alignment.CenterVertically), fontFamily = FontFamily.Cursive, fontSize = 35.sp );


        }
        Box(Modifier.background(Color.Red).fillMaxWidth().weight(0.01f)){

        }
        Row(Modifier
            .background(Color.DarkGray)
                .weight(1f)
                .fillMaxHeight()

            .padding(2.dp)

            , horizontalArrangement = Arrangement.spacedBy(5.dp))
            {

            for (i in raws.indices) {


                Box(
                    Modifier.fillMaxHeight().weight(1f).border(2.dp, Color.Black)
                        .background(Color.White).clickable {
                        (MediaPlayer.create(context, raws[i]).start())
                    }) {

                }
                Box(Modifier.height(150.dp).weight(0.5f).background(Color.Black)){}
            }
        }

    }



}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PianoTheme {
        Greeting("Android")
    }
}