package com.example.salttechnicaltest.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder

@Composable
fun Modifier.shimmer(isVisible : Boolean) : Modifier {
    return this.placeholder(
        visible = isVisible,
        color = Color.Blue,
        shape = RoundedCornerShape(16.dp),
        highlight = PlaceholderHighlight.shimmer()
    )
}

@Composable
fun Modifier.roundedShimmer(isVisible : Boolean) : Modifier {
    return this.placeholder(
        visible = isVisible,
        color = Color.White,
        shape = RoundedCornerShape(0.5f),
        highlight = PlaceholderHighlight.shimmer()
    )
}