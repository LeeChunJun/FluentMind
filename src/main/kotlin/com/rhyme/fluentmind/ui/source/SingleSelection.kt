package com.rhyme.fluentmind.ui.source

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * 源代码视图选中的代码页面
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/22 11:18
 */
class SingleSelection {
    var selected: Any? by mutableStateOf(null)
}