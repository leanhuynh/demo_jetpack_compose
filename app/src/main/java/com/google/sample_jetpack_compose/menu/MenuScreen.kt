package com.google.sample_jetpack_compose.menu

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.sample_jetpack_compose.component.Icon
import com.google.sample_jetpack_compose.home.MenuViewModel
import com.google.sample_jetpack_compose.model.Menu
import com.google.sample_jetpack_compose.ui.theme.Sample_jetpack_composeTheme

@ExperimentalAnimationApi
@Composable
fun MenuScreen(
    onBackClick: () -> Unit,
) {

    val viewModel: MenuViewModel = viewModel()

    val data by viewModel.data.observeAsState(Menu(emptyList(), emptyList()))

    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu Item") },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(Icons.Rounded.ArrowBack)
                    }
                }
            )
        }
    ) {
        Box {
            Column {

                LazyColumn(
                    state = lazyListState
                ) {
                    for (category in data.categories) {
                        item {
                            Text(
                                text = category.name,
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        val menuItems = data.menuItems.filter { it.categoryId == category.id }
                        itemsIndexed(menuItems) { index, menuItem ->
                            MenuItem(
                                menuItem = menuItem,
                                onClick = { },
                            )
                            if (index != menuItems.lastIndex)
                                Divider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview("MenuScreen")
@Composable
private fun MenuScreenPreview() {
    Sample_jetpack_composeTheme {
        MenuScreen(
            onBackClick = {},
        )
    }
}

@ExperimentalAnimationApi
@Preview("MenuScreen • Dark")
@Composable
private fun MenuScreenDarkPreview() {
    Sample_jetpack_composeTheme(darkTheme = true) {
        MenuScreen(
            onBackClick = {},
        )
    }
}