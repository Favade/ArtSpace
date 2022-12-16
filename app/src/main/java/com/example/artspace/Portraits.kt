package com.example.artspace

import androidx.annotation.DrawableRes

data class Portraits(
    val id: Int,
    val img: Int,
    val artName: String,
    val authorName: String,
    val year: String
)


val monalisa = Portraits(1, R.drawable.monalisa,"The Mona Lisa" , "Leonardo da Vinci ",
    "(1503-1506)"
)

val strawHat = Portraits(
    2, R.drawable.strawhat,"Self-Portrait with a Straw Hat", "Vincent Van Gogh",
    "(1887)"
)

val rembrandt = Portraits(
    3, R.drawable.rembrandt,"Self-Portrait", "Rembrandt",
    "(1660)"
)

val herman = Portraits(4, R.drawable.herman, "Herman von Wedigh III", "Hans Holbein the Younger",
    "(1532)"
)
val sailor = Portraits(5, R.drawable.sailorshouse, "Girl in a sailor’s blouse", "Amedeo Modigliani",
    "(1918)"
)