package com.example.training15days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.training15days.feature.card.PropertyCard
import com.example.training15days.feature.home.HomeScreen
import com.example.training15days.ui.theme.Training15DaysTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Training15DaysTheme {
                   HomeScreen()
//                sampletest
            }
        }
    }
}

@Composable
fun sampletest(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        item {
            PropertyCard(
                title = "Student in rural area studying at a young age was captured by the moeys team",
                imagePlaceholder = R.drawable.img_studentstudy,
                profileImage = R.drawable.img_moeys
            )
        }
        item {
            PropertyCard(
                title = "Student in rural area studying at a young age was captured by the moeys team",
                imagePlaceholder = R.drawable.img_studentstudy,
                profileImage = R.drawable.img_moeys
            )
        }
        item {
            PropertyCard(
                title = "Student in rural area studying at a young age was captured by the moeys team",
                imagePlaceholder = R.drawable.img_studentstudy,
                profileImage = R.drawable.img_moeys
            )
        }
    }
}