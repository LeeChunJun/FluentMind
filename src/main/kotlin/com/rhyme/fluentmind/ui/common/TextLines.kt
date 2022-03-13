package com.rhyme.fluentmind.ui.common

/**
 * 代码行接口
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/22 14:04
 */
interface TextLines {
    val size: Int
    fun get(index: Int): String
}

/**
 * 默认代码行对象
 */
object EmptyTextLines: TextLines {
    override val size: Int
        get() = 0

    override fun get(index: Int): String = ""
}