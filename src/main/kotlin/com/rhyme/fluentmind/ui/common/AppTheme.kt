package com.rhyme.fluentmind.ui.common

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle

/**
 * 程序主题
 *
 * @author 李春俊-Rhyme
 * @since 2022/2/12 15:30
 */
object AppTheme {

    val colors  = ColorPrefer()

    val code = CodeStyle()

    class ColorPrefer(
        val backgroundDark: Color = Color(0xFF2B2B2B),
        val backgroundMedium: Color = Color(0xFF3C3F41),
        val backgroundLight: Color = Color(0xFF4E5254),

        val material: Colors = darkColors(
            background = backgroundDark,
            surface = backgroundMedium,
            primary = backgroundLight
        )
    )

    class CodeStyle(
        val simple: SpanStyle = SpanStyle(Color(0xFFA9B7C6)),
        val value: SpanStyle = SpanStyle(Color(0xFF6897BB)),
    )

}