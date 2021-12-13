package com.rhyme.fluentmind.ui

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.rhyme.fluentmind.ui.control.ControlsView
import com.rhyme.fluentmind.ui.log.LogView
import com.rhyme.fluentmind.ui.source.SourceView

/**
 * 程序主视图
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:29
 */
@Composable
fun MainView() {

    val fluentMind = remember {
        /*操作部分视图*/
        val controlView = ControlsView()

        /*源码部分视图*/
        val sourceView = SourceView()

        /*日志记录部分视图*/
        val logView = LogView()

        FluentMind(
            controlView = controlView,
            sourceView = sourceView,
            logView = logView
        )
    }

    DisableSelection {
        DesktopMaterialTheme {
            Surface {
                FluentMindView(fluentMind)
            }
        }
    }
}