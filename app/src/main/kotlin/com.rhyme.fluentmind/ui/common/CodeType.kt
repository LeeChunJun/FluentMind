package com.rhyme.fluentmind.ui.common

/**
 * 当前可支持的代码类型
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/22 14:13
 * @version 1.0
 */
sealed class CodeType {
    object Kotlin: CodeType()
    object Java: CodeType()
    object Python: CodeType()
    object NotSupportCodeType : CodeType()
}
