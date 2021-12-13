package com.rhyme.fluentmind.ui

import com.rhyme.fluentmind.ui.control.ControlsView
import com.rhyme.fluentmind.ui.log.LogView
import com.rhyme.fluentmind.ui.source.SourceView

/**
 * 程序界面组成定义
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/12 22:41
 */
class FluentMind(
    val controlView: ControlsView, val sourceView: SourceView, val logView: LogView
)