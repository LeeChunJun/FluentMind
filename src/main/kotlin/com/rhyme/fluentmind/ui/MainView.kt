package com.rhyme.fluentmind.ui

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.rhyme.fluentmind.ui.control.Controls
import com.rhyme.fluentmind.ui.log.Logs
import com.rhyme.fluentmind.ui.source.Sources

/**
 * 程序主视图
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:29
 */
@Composable
fun MainView() {

    val fluentMind = remember {
        /*操作部分*/
        val controls = Controls()

        /*源码部分*/
        val sources = Sources()

        /*日志记录部分*/
        val logs = Logs()

        FluentMind(
            controls = controls, sources = sources, logs = logs
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