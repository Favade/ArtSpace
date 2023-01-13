package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtScreen()
            }
        }
    }
}


@Composable
fun ArtScreen() {
    val year = listOf("(1503-1506)", "(1887)", "(1660)", "(1532)",  "(1918)")
    val artist = listOf("Leonardo da Vinci ", "Vincent Van Gogh", "Rembrandt", "Hans Holbein the Younger", "Amedeo Modigliani")
    val artImage =  listOf(R.drawable.monalisa, R.drawable.strawhat,R.drawable.rembrandt, R.drawable.herman,  R.drawable.sailorshouse)
    val artworkTitle = listOf("The Mona Lisa" , "Self-Portrait with a Straw Hat", "Self-Portrait", "Herman von Wedigh III",  "Girl in a sailor’s blouse")
    var next by remember{ mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        ArtPiece(
            artImg = artImage[next],
            artName = artworkTitle[next],
            modifier = Modifier.align(CenterHorizontally)
        )
        InfoCards(
            title = artworkTitle[next] ,
            author = artist[next] ,
            year = year[next]
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ButtonNavigation(
                txt = "Previous" ,
                modifier = Modifier.padding(end = 10.dp),
                clicked = {
                    if (next == 0) next += 4 else next--
                }
            )
            Spacer(modifier = Modifier.padding(start = 20.dp))
            ButtonNavigation(
                txt = "Next" ,
                clicked = {
                    if (next == 4) next -= 4 else next++
                }
            )
        }
    }

}


@Composable
fun ArtPiece(
    artImg: Int, 
    artName: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = artImg),
        contentDescription = artName,
    )
}
@Composable
fun InfoCards(
    title: String, 
    author: String, 
    year: String,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 5.dp,
    ) {
        Column{
            Text(
                text = title
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold)
                    ) {
                        append(author)
                    }

                    withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                        append(year)
                    }
                }
            )
        }
    }
}

@Composable
fun ButtonNavigation(
    txt: String,
    clicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = clicked,
    ) {
        Text(
            text = txt
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpace() {
    ArtScreen()
}
