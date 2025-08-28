package com.michaelrichards.artshare.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedPaletteIcon(progress: Float) {
    val size = 120.dp
    val strokeWidth = 8.dp

    Canvas(
        modifier = Modifier.size(size)
    ) {
        // Base circle
        drawCircle(
            color = Color.White.copy(alpha = 0.2f),
            radius = size.toPx() / 2,
            style = Stroke(width = strokeWidth.toPx())
        )

        // Animated arc
        val sweepAngle = progress * 360f
        drawArc(
            color = Color.White,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )

        // Paint brush icon in the center (appears when animation completes)
        if (progress > 0.8f) {
            val brushAlpha = ((progress - 0.8f) * 5f).coerceIn(0f, 1f)
            drawCircle(
                color = Color.White.copy(alpha = brushAlpha),
                center = center,
                radius = 20f
            )
        }
    }
}