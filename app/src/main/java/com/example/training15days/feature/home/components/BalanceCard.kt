package com.example.training15days.feature.home.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.training15days.R
import com.example.training15days.feature.home.CardColor
import com.example.training15days.feature.home.Gold
import com.example.training15days.feature.home.LightBlue

@Composable
fun BalanceCard(modifier: Modifier = Modifier) {
    val animatedProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1200,
                easing = FastOutSlowInEasing
            )
        )
    }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(100.dp),
                contentAlignment = Alignment.Center
            ) {
                val strokeWidth6 = 14f
                val strokeWidth8 = 14f
                val strokeWidth12 = 14f

                Canvas(modifier = Modifier.size(90.dp)) {
                    val progress = animatedProgress.value

                    drawArc(
                        color = Gold.copy(alpha = 0.1f),
                        startAngle = 0f,
                        sweepAngle = 360f * progress,
                        useCenter = false,
                        style = Stroke(width = strokeWidth6)
                    )

                    drawArc(
                        color = LightBlue,
                        startAngle = -150f + (50f * progress),
                        sweepAngle = 260f * progress,
                        useCenter = false,
                        style = Stroke(width = strokeWidth8, cap = StrokeCap.Round)
                    )

                    drawArc(
                        color = Gold,
                        startAngle = 120f + (50f * progress),
                        sweepAngle = 20f * progress,
                        useCenter = false,
                        style = Stroke(width = strokeWidth12, cap = StrokeCap.Round)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    DashboardIcon(
                        iconRes = R.drawable.wallet1,
                        modifier = Modifier.size(25.dp)
                    )
                    Text(
                        text = "Accounts",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total Balances",
                        fontWeight = FontWeight.Medium,
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp
                    )
                    DashboardIcon(
                        iconRes = R.drawable.ic_eye,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                BalanceRow(currency = "៛", amount = "២៣២,២៣៣", color = Gold)
                BalanceRow(currency = "$", amount = "29388", color = LightBlue)
            }
        }
    }
}

@Composable
fun BalanceRow(currency: String, amount: String, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = amount,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = currency,
            color = color,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

