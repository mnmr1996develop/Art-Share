package com.michaelrichards.artshare.naviagtion

sealed class Graphs(
    val graphName: String
) {
    data object MainGraph : Graphs("main-graph")
    data object SplashGraph : Graphs("splash-graph")
}