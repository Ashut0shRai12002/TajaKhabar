package com.ashutosh.tajakhabar.presentation.onboarding

import androidx.annotation.DrawableRes
import com.ashutosh.tajakhabar.R

data class Page(
    val title : String ,
    val description : String,

    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "Welcome to AnimeWorld",
        description = "Discover thousands of anime series and movies tailored for you.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Explore New Shows",
        description = "Find trending, top-rated, and seasonal anime with ease.",
        image = R.drawable.onboarding1


    ),
    Page(
        title = "Save Your Favorites",
        description = "Bookmark and track your favorite anime anytime, anywhere.",
        image = R.drawable.onboarding1

    )
)
