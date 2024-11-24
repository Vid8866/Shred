package com.example.shred
import android.icu.text.DateTimePatternGenerator.DisplayWidth
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shred.ui.theme.ShredTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rides = listOf(
            Ride("Vogel", "15.11.2024" , "Snowboarding", "Beginner" ),
            Ride("Kranjska Gora", "21.11.2024" , "Snowboarding", "Intermediate" ),
            Ride("Katschberg", "12.12.2024" , "Snowboarding", "Expert" ),
            Ride("Rogla", "18.12.2024" , "Skiing", "Intermediate" )


        )

        setContent {
            ShredTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn {
                        items(rides) {
                            CardView(it)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CardView(ride: Ride) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_area_chart_24),
                contentDescription = "Photo of hill",
                modifier = Modifier.width(50.dp)
                    .height(50.dp)

            )
            Text(
                text = ride.location,
                modifier = Modifier.padding(12.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.baseline_date_range_24),
                contentDescription = "Photo of snowboarder",
                modifier = Modifier.width(50.dp)
                    .height(50.dp)
            )
            Text(
                text = ride.date,
                modifier = Modifier.padding(12.dp)
            )
        }
        Row {
            if (ride.sport == "Snowboarding")
                Image(
                    painter = painterResource(id = R.drawable.baseline_snowboarding_24),
                    contentDescription = "Photo of snowboarder",
                    modifier = Modifier.width(50.dp)
                        .height(50.dp)
                )
            else
                Image(
                    painter = painterResource(id = R.drawable.baseline_downhill_skiing_24),
                    contentDescription = "Photo of snowboarder",
                    modifier = Modifier.width(50.dp)
                        .height(50.dp)
                )

            Text(
                text = ride.level,
                modifier = Modifier.padding(12.dp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(
                text = "Join ride",
                color = Color.Blue,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .offset(x = 140.dp)

            )
        }

    }

}


