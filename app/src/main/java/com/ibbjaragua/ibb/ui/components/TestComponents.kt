package com.ibbjaragua.ibb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibbjaragua.ibb.R
import com.ibbjaragua.ibb.ui.theme.Pink40
import com.ibbjaragua.ibb.ui.theme.Purple40

@Preview(showBackground = true)
@Composable
fun PersonalizadoPreview() {
    Column(
        Modifier
            .padding(all = 8.dp)
            .background(color = Color.Cyan)
            .padding(all = 12.dp)
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row(
            Modifier
                .padding(8.dp)
                .background(color = Color.Green)) {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box(
            Modifier
                .padding(8.dp)
                .background(color = Color.Red)) {
            Row(
                Modifier
                    .padding(12.dp)
                    .background(color = Color.Blue)
                    .fillMaxWidth()) {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column(
                Modifier
                    .padding(32.dp)
                    .background(color = Color.Yellow)) {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }
}


// -------- Desafio Card de item na horizontal --------


@Preview(showBackground = true)
@Composable
fun ProductItemHorizontal() {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
        modifier = Modifier.padding(12.dp)
    ) {
        Row(
            Modifier
                .heightIn(min = 150.dp, max = 200.dp)
                .widthIn(min = 400.dp, max = 600.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(imageSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple40, Pink40
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do Produto",
                    modifier = Modifier
                        .size(imageSize)
                        .offset(x = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center)
                        .border(
                            width = 2.dp,
                            shape = CircleShape,
                            brush = Brush.verticalGradient(colors = listOf(Pink40, Purple40))
                        )
                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))
            Text(
                text = LoremIpsum(20).values.first(),
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 24.sp
            )
        }
    }
}

// -------- FIM --------


// -------- Desafio descrição dentro do item com scroll vertical --------
@Preview(showBackground = true)
@Composable
fun ProductDescriptionSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProductItemDescription(LoremIpsum(50).values.first())
            ProductItemDescription()
            ProductItemDescription(LoremIpsum(20).values.first())
        }
    }
}

@Composable
fun ProductItemDescription(description: String = "") {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(min = 250.dp, max = 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40, Pink40
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do Produto",
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = LoremIpsum(20).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 12,00",
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (description.isNotBlank()){
                Text(
                    text = description,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(16.dp, top = 8.dp),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}

// -------- FIM --------