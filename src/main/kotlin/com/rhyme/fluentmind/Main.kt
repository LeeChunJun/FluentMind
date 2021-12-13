package com.rhyme.fluentmind

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.rhyme.fluentmind.ui.MainView


/**
 * 程序入口
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:29
 */
@Composable
@Preview
fun App() {
    MainView()
}

fun main() = singleWindowApplication(
    title = "Fluent Mind",
    state = WindowState(width = 1280.dp, height = 768.dp),
    icon = BitmapPainter(useResource("ic_launcher.png", ::loadImageBitmap))
) {
    App()
}
