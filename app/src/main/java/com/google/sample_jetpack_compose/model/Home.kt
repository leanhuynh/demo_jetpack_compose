package com.google.sample_jetpack_compose.model

data class Home(
    val user: User,
    val categories: List<Category>,
    val popularMenuItems: List<MenuItem>,
    val recommendedMenuItems: List<MenuItem>
)