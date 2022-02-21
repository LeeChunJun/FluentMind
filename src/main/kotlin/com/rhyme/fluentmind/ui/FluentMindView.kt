package com.rhyme.fluentmind.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import com.rhyme.fluentmind.mainViewSize
import com.rhyme.fluentmind.util.SplitterState
import com.rhyme.fluentmind.util.VerticalSplittable

/**
 * 程序界面
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:43
 */
@Composable
fun FluentMindView(model: FluentMind) {

    val panelState = remember { PanelState() }

    val expandedSizeMin =  mainViewSize.current.width / 4
    val expandedSizeMax = mainViewSize.current.width - expandedSizeMin
    panelState.expandedSize = expandedSizeMin

    VerticalSplittable(
        Modifier.fillMaxSize(),
        panelState.splitter,
        onResize = {
            panelState.expandedSize =
                (panelState.expandedSize + it).coerceIn(expandedSizeMin, expandedSizeMax)
        }
    ) {
        Column(modifier = Modifier.width(panelState.expandedSize).fillMaxHeight()) {
            Text("control panel")
            Text("log panel")
        }

        Box {
            Text("source panel")
        }

    }

}

private class PanelState {
    var expandedSize by mutableStateOf(0.dp)
    var isExpanded by mutableStateOf(true)
    val splitter = SplitterState()
}