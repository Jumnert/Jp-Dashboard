
package com.example.training15days.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.training15days.R
import com.example.training15days.feature.home.DarkBlue

@Composable
fun HomeTopBar(badgeCount: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkBlue)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.width(200.dp),
                painter = painterResource(R.drawable.ac),
                contentDescription = "Acleda Logo"
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /* Handle click */ }) {
                BadgedBox(
                    badge = {
                        if (badgeCount > 0) {
                            Badge {
                                Text(text = badgeCount.toString())
                            }
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_notification),
                        contentDescription = "Notifications",
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(R.drawable.unnamed),
                contentDescription = "bakong khqr",
                modifier = Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
        }
    }
}