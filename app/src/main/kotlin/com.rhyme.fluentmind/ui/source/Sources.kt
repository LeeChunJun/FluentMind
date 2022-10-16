package com.rhyme.fluentmind.ui.source

import androidx.compose.runtime.mutableStateListOf
import com.rhyme.fluentmind.platform.File

/**
 * 源代码逻辑
 *
 * @author 李春俊-Rhyme
 * @since 2021/12/14 8:16
 */
class Sources {

    /*当前选中的源代码页*/
    private val selection = SingleSelection()

    /*当前所有的源代码页面集合*/
    var sources = mutableStateListOf<Source>()
        private set

    /*当前视图是否有代码页存在*/
    val active: Source?
        get() = selection.selected as Source?

    fun open(file: File) {
        val source = Source(file)
        source.selection = selection
        source.close = {
            close(source)
        }
        sources.add(source)
        source.activate()
    }

    private fun close(source: Source) {
        val index = sources.indexOf(source)
        sources.remove(source)
        if(source.isActive) {
            selection.selected = sources.getOrNull(index.coerceAtMost(sources.lastIndex))
        }
    }



}