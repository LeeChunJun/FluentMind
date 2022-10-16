package com.rhyme.fluentmind.ui

import com.rhyme.fluentmind.ui.control.Controls
import com.rhyme.fluentmind.ui.log.Logs
import com.rhyme.fluentmind.ui.source.Sources

/**
 * 程序界面组成定义
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:41
 */
class FluentMind(
    val controls: Controls, val sources: Sources, val logs: Logs
)