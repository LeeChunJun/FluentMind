package com.rhyme.fluentmind.ui.source

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 源码页空白占位显示界面
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/23 15:21
 * @version 1.0
 */
@Composable
fun SourceEmptyView() = Box(Modifier.fillMaxSize()) {
    Column(Modifier.align(Alignment.Center)) {
        Icon(
            painter = BitmapPainter(useResource("ic_launcher.png", ::loadImageBitmap)),
            contentDescription = null,
            tint = LocalContentColor.current.copy(alpha = 0.6f),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "open file to view source code",
            color = LocalContentColor.current.copy(alpha = 0.6f),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
        )
    }
}