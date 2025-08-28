package com.michaelrichards.artshare.components

import android.animation.Keyframe
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random


@Composable
fun FloatingPaintBrushes(animationProgress: Float, rotation: Float) {
    val brushCount = 8

    for (i in 0 until brushCount) {
        val offsetProgress = (i.toFloat() / brushCount) * animationProgress
        val random = Random(i)




        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val angle = (i * 360f / brushCount) + rotation
            val distance = size.minDimension * 0.4f * offsetProgress
            val centerX = size.width / 2
            val centerY = size.height / 2

            val x = centerX + distance * cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = centerY + distance * sin(Math.toRadians(angle.toDouble())).toFloat()

            rotate(angle) {
                drawCircle(
                    color = Color.White.copy(alpha = offsetProgress),
                    center = Offset(x, y),
                    radius = 16f * offsetProgress
                )

                // Brush handle
                drawRect(
                    color = Color(0xFFFFD700).copy(offsetProgress),
                    topLeft = Offset(x - 4f, y - 20f),
                    size = Size(8f, 40f)
                )

                // Brush bristles
                drawCircle(
                    color = Color(0xFFFFD700).copy(alpha = offsetProgress),
                    center = Offset(x, y + 25f),
                    radius = 12f * offsetProgress
                )
            }
        }
    }
}