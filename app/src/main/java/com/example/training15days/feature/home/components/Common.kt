package com.example.training15days.feature.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.training15days.feature.home.CardColor
import com.example.training15days.feature.home.DarkBlue

@Composable
fun DashboardIcon(
    iconRes: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(iconRes),
        contentDescription = null,
        modifier = modifier,
        tint = Color.White
    )
}

@Composable
fun HeaderText(text: String, modifier: Modifier = Modifier) {
    Text(
        color = Color.White,
        modifier = modifier.padding(5.dp),
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    )
}
