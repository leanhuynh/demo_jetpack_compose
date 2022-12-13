package com.google.sample_jetpack_compose.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints
import androidx.constraintlayout.compose.Dimension.Companion.wrapContent
import com.google.sample_jetpack_compose.component.NetworkImage
import com.google.sample_jetpack_compose.model.MenuItem
import com.google.sample_jetpack_compose.ui.theme.Sample_jetpack_composeTheme

@Composable
fun MenuItemCard(
    menuItem: MenuItem,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        color = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (card, name, price, image) = createRefs()

            val primary_1 = Color(red = 228, green = 225, blue = 225)
            val primary_2 = Color(red = 183, green = 54, blue = 54)

            val LightColorPalate = lightColors(
                primary = primary_1
            )

            val DarkColorPalate = darkColors(
                primary = primary_2
            )

            MaterialTheme(
                colors = if (MaterialTheme.colors.isLight) LightColorPalate else DarkColorPalate
            ) {
                // Card
                Surface(
                    modifier = Modifier
                        .constrainAs(card) {
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                            top.linkTo(parent.top, margin = 32.dp)
                            bottom.linkTo(parent.bottom)

                            width = fillToConstraints
                            height = fillToConstraints
                        },
                    shape = MaterialTheme.shapes.medium,
                    color = MaterialTheme.colors.primary
                ) {
                    Row(modifier = Modifier.clickable(onClick = onClick)) {}
                }
            }


            Text(
                text = menuItem.name,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(card.start, margin = 16.dp)
                        end.linkTo(image.start)
                        top.linkTo(card.top, margin = 16.dp)

                        width = fillToConstraints
                        height = wrapContent
                    }
            )

            Text(
                text = "$" + "%.2f".format(menuItem.price),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .constrainAs(price) {
                        start.linkTo(card.start, margin = 16.dp)
                        end.linkTo(image.start)
                        bottom.linkTo(card.bottom, margin = 16.dp)

                        width = fillToConstraints
                        height = wrapContent
                    }
            )

            NetworkImage(
                imageUrl = menuItem.image,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1.40f)
                    .constrainAs(image) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}

@Preview("Menu Item Card")
@Composable
private fun MenuItemCardPreview() {
    Sample_jetpack_composeTheme(darkTheme = false) {
        MenuItemCard(
            menuItem = MenuItem(
                id = 0,
                name = "Double Quarter Pounder with Cheese Meal",
                description = "",
                image = "",
                price = 0.00,
                categoryId = 0
            ),
            onClick = {}
        )
    }
}

@Preview("Menu Item Card • Dark")
@Composable
private fun MenuItemCardDarkPreview() {
    Sample_jetpack_composeTheme(darkTheme = true) {
        MenuItemCard(
            menuItem = MenuItem(
                id = 0,
                name = "Double Quarter Pounder with Cheese Meal",
                description = "",
                image = "",
                price = 0.00,
                categoryId = 0
            ),
            onClick = {}
        )
    }
}
