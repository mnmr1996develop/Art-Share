package com.michaelrichards.artshare.screens.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michaelrichards.artshare.R
import com.michaelrichards.artshare.components.AnimatedPaletteIcon
import com.michaelrichards.artshare.components.FloatingPaintBrushes
import com.michaelrichards.artshare.components.LoadingDots
import kotlinx.coroutines.delay

@Composable
fun SplashComposable(
    modifier: Modifier = Modifier,
    onSplashComplete: () -> Unit
    ) {

    var animationState by remember { mutableFloatStateOf(0f) }
    val infiniteTransition = rememberInfiniteTransition()

    val brushRotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    LaunchedEffect(Unit) {
        // Animate from 0 to 1 over 2 seconds
        animate(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = tween(2000, easing = FastOutSlowInEasing)
        ) { value, _ ->
            animationState = value
        }

        // Wait a bit then navigate away
        delay(2500)
        onSplashComplete()
    }



    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF6A11CB),
                        Color(0xFF2575FC)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // Animated background elements
        FloatingPaintBrushes(animationProgress = animationState, rotation = brushRotation)

        // Main content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(pulse)
        ) {
            // Animated palette icon
            AnimatedPaletteIcon(animationState)

            Spacer(modifier = Modifier.height(32.dp))

            // App name with fade-in animation
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.alpha(animationState)
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = stringResource(R.string.tagline),
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.alpha((animationState - 0.3f).coerceAtLeast(0f))
            )
        }

        // Loading progress at bottom
        LoadingDots(animationProgress = animationState)
    }
}

@Preview
@Composable
private fun SplashPreview() {
    SplashComposable(){

    }
}