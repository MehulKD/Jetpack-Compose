package com.carworkz.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
		
		
//		Greeting()
		
		
		/*	val painter= painterResource(id = R.drawable.image1)
			val description="lens in hand"
			val title="lens in hand"
			Box(modifier = Modifier
					.fillMaxWidth(0.5f)
					.padding(16.dp)
			   ){
				ImageCard(painter = painter, contentDescription =description , title = title)
				
			}*/
			
//			ColorBox(Modifier.fillMaxSize())
		
			
		}
	}
}

@Composable
fun ColorBox(modifier : Modifier=Modifier){
	
	val color = remember {
		mutableStateOf (Color.Yellow)
	}
	
	Box(modifier = modifier
			.background(color.value)
			.clickable {
				color.value = Color(
						Random.nextFloat(),
						Random.nextFloat(),
						Random.nextFloat(),
						1f
				                   )
			}
	   )
}

@Composable
fun ImageCard(
	painter : Painter,
	contentDescription:String,
	title:String,
	modifier : Modifier=Modifier
			 ){
	Card(
			modifier = modifier.fillMaxWidth(),
			shape = RoundedCornerShape(15.dp),
			elevation = 5.dp
		) {
		Box(modifier = Modifier.height(200.dp)){
			Image(painter = painter,
			      contentDescription = contentDescription,
			     contentScale = ContentScale.Crop
			      )
			
			Box(modifier = Modifier
					.fillMaxSize()
					.background(
							Brush.verticalGradient(
									colors = listOf(
											Color.Transparent,
											Color.Black
									               ),
									startY = 300f
							                      )
					           )
			   )
			
			Box(modifier = Modifier
					.fillMaxSize()
					.padding(12.dp),
			    contentAlignment = Alignment.BottomStart
			   ){
				Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
			}
		}
	}
}

@Composable
fun Greeting() {
	Column(
			modifier = Modifier
					.background(Color.Green)
					.fillMaxHeight(0.5f)
					.fillMaxWidth()
					.border(5.dp, Color.Magenta)
					.padding(5.dp)
					.border(5.dp, Color.Blue)
					.padding(5.dp)
					.border(10.dp, Color.Red)
					.padding(10.dp)
			
			) {
		Text(text = "Hello")
		Spacer(modifier = Modifier.height(50.dp))
		Text(text = "World")
	}
}
