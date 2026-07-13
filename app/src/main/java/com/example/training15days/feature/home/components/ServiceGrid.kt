package com.example.training15days.feature.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.training15days.R
import com.example.training15days.feature.home.CardColor

@Composable
fun ServiceGrid(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ServiceItemLarge(
                iconRes = R.drawable.wallet,
                label = "Payments",
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemLarge(
                iconRes = R.drawable.add_circle,
                label = "Mobile Top-up",
                modifier = Modifier.weight(1.1f)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            ServiceItemSmall(iconRes = R.drawable.credit_card, label = "Cards", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemSmall(iconRes = R.drawable.ic_scanners, label = "Scan QR", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemSmall(iconRes = R.drawable.arrows_square_up_down, label = "Transfers", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            ServiceItemSmall(iconRes = R.drawable.arrow_circle_down, label = "Deposits", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemSmall(iconRes = R.drawable.folder, label = "Loans", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemSmall(iconRes = R.drawable.currency, label = "Quick Cash", modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ServiceItemLarge(iconRes: Int, label: String, modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier.height(70.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            DashboardIcon(
                iconRes = iconRes,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ServiceItemSmall(iconRes: Int, label: String, modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DashboardIcon(
                iconRes = iconRes,
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }
    }
}
