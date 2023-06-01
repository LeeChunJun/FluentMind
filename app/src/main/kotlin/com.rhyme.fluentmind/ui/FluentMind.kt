package com.rhyme.fluentmind.ui

import com.rhyme.fluentmind.ui.navigation.Navigations
import com.rhyme.fluentmind.ui.operation.Operations
import com.rhyme.fluentmind.ui.source.Sources

/**
 * 程序界面组成定义
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:41
 * @version 1.0
 */
class FluentMind(
    val navigations: Navigations, val sources: Sources, val operations: Operations
)