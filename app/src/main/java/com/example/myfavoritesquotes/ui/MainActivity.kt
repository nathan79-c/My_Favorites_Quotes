package com.example.myfavoritesquotes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfavoritesquotes.data.model.QuotesModel
import com.example.myfavoritesquotes.ui.screen.AllQuotes
import com.example.myfavoritesquotes.ui.screen.QuotesElement
import com.example.myfavoritesquotes.ui.theme.MyFavoritesQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFavoritesQuotesTheme {
                  AllQuotes(
                        onClick = { },
                        quotes = testApp, modifier =
                            Modifier
                    )

            }
        }
    }
}

val testApp = listOf(
    QuotesModel("Ce n’est pas la montagne à gravir qui vous fera abandonner, c’est le\n" +
            "caillou dans votre chaussure","Mohamed Ali"),
    QuotesModel("Il faut toujours se réserver le droit de rire le lendemain de ses idées\n" +
            "de la veille.","Napoléon Bonaparte"),
    QuotesModel("Nous sommes ce que nous pensons. Tout ce que nous sommes résulte\n" +
            "de nos pensées. Avec nos pensées, nous bâtissons notre monde.","Bouddha"),
    QuotesModel("Ne croyez pas les individus, fiez-vous aux enseignements ; ne croyez\n" +
            "pas les mots, fiez-vous au sens ultime, ne croyez pas l'intellect, fiez-vous\n" +
            "à la sagesse.","Bouddha"),
    QuotesModel("Le travail d'équipe permet à des personnes ordinaires de faire des\n" +
            "choses extraordinaires.","Andrew Carnegie"),
    QuotesModel("Ne cherchez pas la sécurité, c’est le jeu le plus dangereux au monde.","Winston Churchill")
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFavoritesQuotesTheme {

    }
}