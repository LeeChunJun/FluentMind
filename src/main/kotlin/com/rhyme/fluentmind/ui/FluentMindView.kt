package com.rhyme.fluentmind.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.coerceIn
import androidx.compose.ui.unit.dp
import com.rhyme.fluentmind.mainViewSize
import com.rhyme.fluentmind.ui.common.SplitterState
import com.rhyme.fluentmind.ui.common.VerticalSplittable
import com.rhyme.fluentmind.ui.source.SourceEmptyView

/**
 * 程序界面
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:43
 */
@Composable
fun FluentMindView(model: FluentMind) {

    val panelState = remember { PanelState() }

    val expandedSizeMin = mainViewSize.current.width / 4
    val expandedSizeMax = mainViewSize.current.width - expandedSizeMin
    panelState.expandedSize = expandedSizeMin

    Column {
        /*操作面板及源代码面板*/
        VerticalSplittable(
            Modifier.fillMaxWidth().weight(1f),
            panelState.splitter,
            onResize = {
                panelState.expandedSize =
                    (panelState.expandedSize + it).coerceIn(expandedSizeMin, expandedSizeMax)
            }
        ) {
            Column(modifier = Modifier.width(panelState.expandedSize).fillMaxHeight()) {
                Text("control panel")
            }
            Box {
                if (model.sources.active != null) {
                    Text("source panel")
                } else {
                    SourceEmptyView()
                }
            }
        }
        /*日志记录面板*/
        Box {
            Text("log panel")
        }
    }
}

private class PanelState {
    var expandedSize by mutableStateOf(0.dp)
    var isExpanded by mutableStateOf(true)
    val splitter = SplitterState()
}