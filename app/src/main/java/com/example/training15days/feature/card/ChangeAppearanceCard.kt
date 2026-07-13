package com.example.training15days.feature.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.training15days.R

// Cleaned up color definitions (Using higher contrast for the gradient)
val darkBlueGradientStart = Color(0xFF1E4570)
val cardColorGradientEnd = Color(0xFF132D48)

val gradientBrush = Brush.verticalGradient(
    colors = listOf(darkBlueGradientStart, cardColorGradientEnd)
)

@Composable
fun ScreenshotThemeCard() {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 6.dp, shape = RoundedCornerShape(18.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(18.dp))
        ) {
            // 1. Your Background PNG Image
            Image(
                painter = painterResource(id = R.drawable.img_blue), // <-- Replace with your actual PNG file name
                contentDescription = null, // Backgrounds usually don't need a description
                contentScale = ContentScale.Crop, // This ensures it fills the entire background area
                modifier = Modifier.matchParentSize() // Forces the image to exactly match the Box dimensions
            )

            // 2. Your Existing Content Row
            Row(
                modifier = Modifier.matchParentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 12.dp, end = 2.dp)
                        .clipToBounds()
                ) {
                    val themeImages = listOf(
                        R.drawable.img_theme1,
                        R.drawable.img_theme2,
                        R.drawable.img_theme3,
                        R.drawable.img_theme4,
                    )

                    themeImages.forEachIndexed { index, imageRes ->
                        val yOffset = when (index) {
                            0 -> 50.dp
                            1 -> 65.dp
                            2 -> 35.dp
                            3 -> 65.dp
                            else -> 0.dp
                        }

                        Box(
                            modifier = Modifier
                                .width(52.dp)
                                .fillMaxHeight()
                        ) {
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = "Theme ${index + 1}",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .offset(y = yOffset)
                                    .clip(RoundedCornerShape(6.dp))
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Customize Button
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 20.dp)
                        .width(90.dp)
                        .height(36.dp)
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(18.dp))
                        .clip(RoundedCornerShape(18.dp))
                        .background(cardColorGradientEnd)
                        .border(
                            border = BorderStroke(1.dp, colorResource(id = R.color.gold_premium)),
                            shape = RoundedCornerShape(18.dp)
                        )
                        .clickable { /* Handle click */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Customize",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CustomThemeCardPreview() {
    ScreenshotThemeCard()
}