package com.rhyme.fluentmind.ui

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.rhyme.fluentmind.ui.common.AppTheme
import com.rhyme.fluentmind.ui.navigation.Navigations
import com.rhyme.fluentmind.ui.operation.Operations
import com.rhyme.fluentmind.ui.source.Sources

/**
 * 程序主视图
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:29
 * @version 1.0
 */
@Composable
fun MainView() {

    val fluentMind = remember {
        /*导航区部分*/
        val navigations = Navigations()

        /*源码区部分*/
        val sources = Sources()

        /*操控区部分*/
        val operations = Operations()

        FluentMind(
            navigations = navigations, sources = sources, operations = operations
        )
    }

    DisableSelection {
        MaterialTheme(
            colors = AppTheme.colors.material
        ) {
            Surface {
                FluentMindView(fluentMind)
            }
        }
    }
}