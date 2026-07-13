package com.example.training15days.feature.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.training15days.R
import com.example.training15days.feature.home.CardColor

val DarkBlue = Color(0xFF18314D)


@Composable
fun SpecialOfferCard(modifier: Modifier = Modifier, imgPlaceholder: Int, title: String) {
    ElevatedCard(
        modifier = modifier
            .width(150.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = imgPlaceholder,
                contentDescription = title,
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .weight(0.7f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            ) {
                Text(
                    text = title,
                    color = colorResource(R.color.gold_premium),
                    fontSize = 14.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun offercardcarousel(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            SpecialOfferCard(imgPlaceholder = R.drawable.img_so1, title = "get 50% Off at Clinic")
        }
        item {
            SpecialOfferCard(imgPlaceholder = R.drawable.img_so2, title = "Pay with ACLEDA save 50% on Store")
        }
        item {
            SpecialOfferCard(imgPlaceholder = R.drawable.img_so3, title = "Pay for fuel cheaper with ACLEDA ")
        }
        item {
            SpecialOfferCard(imgPlaceholder = R.drawable.img_so4, title = "Discount up to 10% with ACLEDA Cards")
        }
    }
}

@Preview
@Composable
private fun speacialoffercardpreview() {
    SpecialOfferCard(imgPlaceholder = R.drawable.img_so4, title = "A Speacial Promotion Offer")
}