package com.example.training15days.feature.home

import androidx.compose.foundation.Canvas
    import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import kotlinx.coroutines.delay
import com.example.training15days.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import kotlin.math.absoluteValue
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import com.example.training15days.feature.card.CarouselItem
import com.example.training15days.feature.card.PropertyCarousel
import com.example.training15days.feature.card.ScreenshotThemeCard
import com.example.training15days.feature.card.offercardcarousel
val DarkBlue1 = Color(0xFF020617) // Deepest Navy
val DarkBlue = Color(0xFF0F172A)  // Primary Professional Background
val Gold = Color(0xFFEAB308)      // Premium Gold Accent
val LightBlue = Color(0xFF38BDF8)  // Modern Highlight Blue
val CardColor = Color(0xFF1E293B)  // Card Surface
val CardColor1 = Color(0xFF334155) // Card Surface Highlight

@Composable
fun DashboardIcon(
    iconRes: Int,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(iconRes),
        contentDescription = null,


        modifier = modifier,
        tint = Color.Unspecified
    )
}

@OptIn(ExperimentalFoundationApi::class) // Required for using stickyHeader API
@Composable
fun HomeScreen() {
    val sampleCarouselItemse = remember {
        listOf(
            CarouselItem(
                title = "Student in rural area studying at a young age was captured by the moeys team",
                imagePlaceholder = R.drawable.img_studentstudy,
                profileImage = R.drawable.img_moeys
            ),
            CarouselItem(
                title = "Second sample property card for checking horizontal swipe behavior",
                imagePlaceholder = R.drawable.img_potiential, // Reuse or change res
                profileImage = R.drawable.img_potential
            ),
            CarouselItem(
                title = "Third sample property card to fully test out the dot indicators",
                imagePlaceholder = R.drawable.img_forte, // Reuse or change res
                profileImage = R.drawable.forte
            ),
            CarouselItem(
                title = "Third sample property card to fully test out the dot indicators",
                imagePlaceholder = R.drawable.img_forte, // Reuse or change res
                profileImage = R.drawable.forte
            ),
            CarouselItem(
                title = "Third sample property card to fully test out the dot indicators",
                imagePlaceholder = R.drawable.img_forte, // Reuse or change res
                profileImage = R.drawable.forte
            )
        )
    }
    val sampleCarouselItems = remember {
        listOf(
            CarouselSection("Payments", R.drawable.wallet),
            CarouselSection("Top-up", R.drawable.add_circle),
            CarouselSection("Cards", R.drawable.credit_card),
            CarouselSection("Scan QR", R.drawable.scanic),
            CarouselSection("Transfers", R.drawable.arrows_square_up_down),
            CarouselSection("Deposits", R.drawable.arrow_circle_down),
            CarouselSection("Loans", R.drawable.folder),
            CarouselSection("Quick Cash", R.drawable.currency)
        )
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkBlue,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 14.dp)
        ) {

            stickyHeader {
                HomeTopBar(
                    badgeCount = 0,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DarkBlue) // Prevents elements from bleeding underneath your topbar text/icons
                )
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                BalanceCard(modifier = Modifier.padding(horizontal = 16.dp))
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                ServiceGrid(modifier = Modifier.padding(horizontal = 16.dp))
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                SectionCarousel(sections = sampleCarouselItems)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                HeaderText(text = "Recommended", modifier = Modifier.padding(horizontal = 16.dp))
                ImageCarousel()
            }

//            item {
//                Spacer(modifier = Modifier.height(16.dp))
//                HeaderText(text = "Recent Transactions", modifier = Modifier.padding(horizontal = 16.dp))
//                ContactCarousel()
//            }

//            item {
//                Spacer(modifier = Modifier.height(16.dp))
//                HeaderText(text = "Other News", modifier = Modifier.padding(horizontal = 16.dp))
//                ImageCarousel()
//            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HeaderText(text = "Recommended Place", modifier = Modifier.padding(horizontal = 16.dp))
                PropertyCarousel(items = sampleCarouselItemse)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                HeaderText(text = "Special Offer", modifier = Modifier.padding(horizontal = 16.dp))
                offercardcarousel()
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HeaderText(text = "Appearance", modifier = Modifier.padding(horizontal = 16.dp))
            }
            item {
                ScreenshotThemeCard()
            }

        }
    }
}

data class CarouselSection(val name: String, val iconRes: Int)
private data class DashboardSectionWrapper(val name: String, val iconRes: Int)

@Composable
fun HeaderText(text: String, modifier: Modifier = Modifier) {
    Text(
        color = Color.White,
        modifier = Modifier
            .padding(5.dp),
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,

        )
}

@Composable
fun SectionCarousel(
    sections: List<CarouselSection>,
    modifier: Modifier = Modifier
        .clip(RoundedCornerShape(8.dp)),
    onSectionClick: (CarouselSection) -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(sections) { section ->
                CarouselItem(
                    name = section.name,
                    icon = painterResource(id = section.iconRes),
                    onClick = { onSectionClick(section) }
                )
            }
        }
    }
}

@Composable
fun CarouselItem(
    name: String,
    icon: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(80.dp)
            .clickable { onClick() }
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(DarkBlue)
                .border(shape = RoundedCornerShape(8.dp),width = 1.5.dp,color = Color.DarkGray
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = name,
                modifier = Modifier.size(28.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier
) {
    val imageList = remember {
        listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4
        )
    }

    val pagerState = rememberPagerState { imageList.size }

    // Auto-scroll logic with safety check for user interaction
    LaunchedEffect(pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            while (true) {
                delay(4000) // Wait 4 seconds between scrolls
                if (!pagerState.isScrollInProgress) {
                    val nextPage = (pagerState.currentPage + 1) % imageList.size
                    pagerState.animateScrollToPage(
                        page = nextPage,
                        animationSpec = tween(durationMillis = 800)
                    )
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageSpacing = 4.dp
        ) { page ->
            AsyncImage(
                model = imageList[page],
                contentDescription = "Banner Image $page",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                ).absoluteValue
                        val fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        val scaleValue = lerp(0.85f, 1.0f, fraction)

                        scaleY = scaleValue
                        scaleX = scaleValue
                        alpha = lerp(0.7f, 1.0f, fraction)
                    }
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 2. Dot Indicators
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(imageList.size) { index ->
                val isSelected = pagerState.currentPage == index

                Box(
                    modifier = Modifier
                        .size(if (isSelected) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            color = if (isSelected) Color(0xFFD4AF37) else Color.White.copy(alpha = 0.3f)
                        )
                )
            }
        }
    }
}
data class ContactItem(val name: String, val avatarResId: Int)
@Composable
fun ContactCarousel(
    modifier: Modifier = Modifier,
    onContactSelect: (ContactItem) -> Unit = {}
) {
    val contactsList = listOf(
        ContactItem("Sok Dara", R.drawable.designer)
    )
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(contactsList) { contact ->
            Card(
                colors = CardDefaults.cardColors(containerColor = CardColor), // Your #132D48
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(100.dp)
                    .height(120.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable { onContactSelect(contact) }
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = contact.avatarResId,
                        contentDescription = contact.name,
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = contact.name,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
@Composable
fun HomeTopBar(badgeCount: Int, modifier: Modifier) {
    Row(
        modifier = Modifier
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
                Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
        }
    }
}

@Composable
fun BalanceCard(modifier: Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
//            .border(width = 1.dp, color = colorResource(R.color.gold_premium),
//                shape = RoundedCornerShape(16.dp)
//            )
                ,
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
                val strokeWidth6 = 6f
                val strokeWidth8 = 8f
                val strokeWidth12 = 12f
                
                Canvas(modifier = Modifier.size(90.dp)) {
                    drawArc(
                        color = Gold.copy(alpha = 0.1f),
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = strokeWidth6)
                    )
                    drawArc(
                        color = LightBlue,
                        startAngle = -100f,
                        sweepAngle = 260f,
                        useCenter = false,
                        style = Stroke(width = strokeWidth8, cap = StrokeCap.Round)
                    )
                    drawArc(
                        color = Gold,
                        startAngle = 170f,
                        sweepAngle = 20f,
                        useCenter = false,
                        style = Stroke(width = strokeWidth12, cap = StrokeCap.Round)
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    DashboardIcon(
                        iconRes = R.drawable.wallet1,
                        modifier = Modifier.size(50.dp)
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
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                BalanceRow(currency = "៛", amount = "98232873", color = Gold)
                BalanceRow(currency = "$", amount = "៩៨២៧៣៨៧២", color = LightBlue)
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

@Composable
fun ServiceGrid(modifier: Modifier) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            ServiceItemLarge(
                iconRes = R.drawable.wallet,
                label = "Payments",
                modifier = Modifier.weight(1.4f)
            )
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemLarge(
                iconRes = R.drawable.add_circle,
                label = "Mobile Top-up",
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            ServiceItemSmall(iconRes = R.drawable.credit_card, label = "Cards", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            ServiceItemSmall(iconRes = R.drawable.scanic, label = "Scan QR", modifier = Modifier.weight(1f))
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
        modifier = modifier
            .height(70.dp)
//            .border(width = 1.dp, color = colorResource(R.color.gold_premium),
//                shape = RoundedCornerShape(16.dp)
//
//            )
                ,
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
                modifier = Modifier.size(40.dp),

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
            modifier = Modifier
                .fillMaxSize()
//                .border(width = 1.dp, color = colorResource(R.color.gold_premium),
//                    shape = RoundedCornerShape(16.dp)
//                )
                    ,

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DashboardIcon(
                iconRes = iconRes,
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}