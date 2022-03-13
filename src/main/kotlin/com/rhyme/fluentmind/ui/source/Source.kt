package com.rhyme.fluentmind.ui.source

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.rhyme.fluentmind.platform.File
import com.rhyme.fluentmind.ui.common.CodeType
import com.rhyme.fluentmind.ui.common.EmptyTextLines
import kotlinx.coroutines.CoroutineScope

/**
 * 单个展示的源代码文件
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/22 10:48
 */
class Source(
    val fileName: String,
    val lines: (backgroundScope: CoroutineScope) -> Lines,
) {

    /*页面关闭动作*/
    var close: (() -> Unit)? = null

    /*当前页面的选中值，由外界设定*/
    lateinit var selection: SingleSelection

    /*当前页面是否处于活动状态*/
    val isActive: Boolean
        get() = selection.selected === this

    /*让当前页面处于活动状态*/
    fun activate() {
        selection.selected = this
    }

    /*单行文本*/
    class Content(val value: State<String>, val codeType: CodeType)

    /*每一行对应的行号、文本内容*/
    class Line(val number: Int, val content: Content)

    interface Lines {

        /*整页面的代码行数*/
        val size: Int

        /*代码行数的数字位数*/
        val lineNumberDigitCount: Int
            get() = size.toString().length

        /*获取指定代码行的行号和内容*/
        operator fun get(index: Int): Line
    }
}

fun Source(file: File) = Source(
    fileName = file.name
) { backgroundScope ->
    val textLines = try {
        file.readLines(backgroundScope)
    } catch (e: Throwable) {
        e.printStackTrace()
        EmptyTextLines
    }
    val codeType = judgeCodeType(file.name)

    /*指定行对应的代码内容*/
    fun content(index: Int): Source.Content {
        val text = textLines.get(index)
        val state = mutableStateOf(text)
        return Source.Content(state, codeType)
    }

    object : Source.Lines {
        override val size: Int
            get() = textLines.size

        override fun get(index: Int) = Source.Line(
            number = index + 1, content = content(index)
        )
    }

}

/**
 * 根据文件后缀名判断代码类型
 */
fun judgeCodeType(fileName: String): CodeType {
    return if (fileName.endsWith(".kt", ignoreCase = true)) {
        CodeType.Kotlin
    } else if (fileName.endsWith(".java", ignoreCase = true)) {
        CodeType.Java
    } else if (fileName.endsWith(".py", ignoreCase = true)) {
        CodeType.Python
    } else {
        CodeType.NotSupportCodeType
    }
}
