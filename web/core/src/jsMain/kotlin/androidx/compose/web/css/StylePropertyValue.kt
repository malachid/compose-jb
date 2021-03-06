/*
 * Copyright 2020-2021 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

@file:Suppress("UNUSED", "NOTHING_TO_INLINE", "FunctionName")
package org.jetbrains.compose.web.css

external interface StylePropertyValue

external interface StylePropertyNumber: StylePropertyValue
external interface StylePropertyString: StylePropertyValue

inline fun StylePropertyValue(value: String): StylePropertyString = value.unsafeCast<StylePropertyString>()
inline fun StylePropertyValue(value: Number): StylePropertyNumber = value.unsafeCast<StylePropertyNumber>()

fun StylePropertyValue.asString(): String? = if (jsTypeOf(this) == "string") this.unsafeCast<String>() else null

fun StylePropertyValue.asNumber(): Number? = if (jsTypeOf(this) == "number") this.unsafeCast<Number>() else null

fun StylePropertyValue.asCSSStyleValue(): CSSStyleValue? = if (jsTypeOf(this) == "object") this.unsafeCast<CSSStyleValue>() else null

external interface CSSStyleValue: StylePropertyValue {
    override fun toString(): String
}

inline fun CSSStyleValue(value: String): CSSStyleValue = StylePropertyValue(value).unsafeCast<CSSStyleValue>()
