package com.google.sample_jetpack_compose.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.sample_jetpack_compose.component.SpotlightCard
import com.google.sample_jetpack_compose.data.HomeRepository
import com.google.sample_jetpack_compose.ui.theme.Sample_jetpack_composeTheme

@Composable
fun HomeScreen(
    onCategoryClick: () -> Unit,
    onMenuItemClick: () -> Unit,
) {

    val data = HomeRepository.getHomeData()

    Scaffold(
        // can add a TopAppBar like "Sample App" but we don't want just it is urgly

        topBar = {
            TopAppBar(
                title = { Text(text = "Home Page") }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "${data.user.name}!",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                LazyRow {
                    item { Spacer(modifier = Modifier.width(16.dp)) }
                    items(data.categories) { category ->
                        SpotlightCard(
                            title = category.name,
                            imageUrl = category.image,
                            onClick = onCategoryClick
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Popular",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            items(data.popularMenuItems) { menuItem ->
                MenuItemCard(
                    menuItem = menuItem,
                    onClick = onMenuItemClick
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

@Preview("HomeScreen")
@Composable
private fun HomeScreenPreview() {
    Sample_jetpack_composeTheme() {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}

@Preview("HomeScreen • Dark")
@Composable
private fun HomeScreenDarkPreview() {
    Sample_jetpack_composeTheme(darkTheme = true) {
        HomeScreen(
            onCategoryClick = {},
            onMenuItemClick = {},
        )
    }
}