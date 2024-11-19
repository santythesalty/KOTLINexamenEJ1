package com.santy.examenej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import com.example.examenej1.VideoGame

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoGameList(videoGames = generateVideoGames())
        }
    }
}

// Generador de lista de videojuegos
fun generateVideoGames(): List<VideoGame> {
    return listOf(
        VideoGame("Game 1", "49.99", "https://loremflickr.com/400/400/seville?lock=1"),
        VideoGame("Game 2", "59.99", "https://loremflickr.com/400/400/seville?lock=2"),
        VideoGame("Game 3", "39.99", "https://loremflickr.com/400/400/seville?lock=3"),
        VideoGame("Game 4", "29.99", "https://loremflickr.com/400/400/seville?lock=4"),
        VideoGame("Game 5", "   19.99", "https://loremflickr.com/400/400/seville?lock=5")
    )
}

@Composable
fun VideoGameList(videoGames: List<VideoGame>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videoGames) { videoGame ->
            VideoGameItem(videoGame)
        }
    }
}

@Composable
fun VideoGameItem(videoGame: VideoGame) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = videoGame.imageUrl,
            contentDescription = videoGame.name,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(
                text = videoGame.name,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = videoGame.price,
                fontSize = 16.sp
            )
        }
    }
}
