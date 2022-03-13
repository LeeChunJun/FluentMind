package com.rhyme.fluentmind.platform

import com.rhyme.fluentmind.ui.common.TextLines
import kotlinx.coroutines.CoroutineScope

/**
 * 源代码文件类
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/22 15:24
 */
interface File {
    val name: String
    val isDirectory: Boolean
    val children: List<File>
    val hasChildren: Boolean

    /**
     * 读取文件中某一行文本
     */
    fun readLines(scope: CoroutineScope) : TextLines
}