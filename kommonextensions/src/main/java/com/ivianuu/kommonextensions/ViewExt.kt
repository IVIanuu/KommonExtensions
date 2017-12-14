/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.kommonextensions

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import android.view.ViewGroup

inline fun View.setVisible() {
    visibility = View.VISIBLE
}

inline fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

inline fun View.setVisible(predicate: () -> Boolean) = setVisible(predicate())

inline fun View.setInvisible() {
    visibility = View.INVISIBLE
}

inline fun View.setInvisible(invisible: Boolean) {
    visibility = if (invisible) View.INVISIBLE else View.VISIBLE
}

inline fun View.setInvisible(predicate: () -> Boolean) = setInvisible(predicate())

inline fun View.setGone() {
    visibility = View.GONE
}

inline fun View.setGone(gone: Boolean) {
    visibility = if (gone) View.GONE else View.VISIBLE
}

inline fun View.setGone(predicate: () -> Boolean) = setGone(predicate())

inline fun View.isVisible() = visibility == View.VISIBLE

inline fun View.isInvisible() = visibility == View.INVISIBLE

inline fun View.isGone() = visibility == View.GONE

inline fun View.setPaddingLeft(padding: Int) = setPadding(padding, paddingTop, paddingRight, paddingBottom)

inline fun View.setPaddingRight(padding: Int) = setPadding(paddingLeft, paddingTop, padding, paddingBottom)

inline fun View.setPaddingTop(padding: Int) = setPadding(paddingLeft, padding, paddingRight, paddingBottom)

inline fun View.setPaddingBottom(padding: Int) = setPadding(paddingLeft, paddingTop, paddingRight, padding)

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun View.setPaddingStart(padding: Int) = setPaddingRelative(padding, paddingTop, paddingEnd, paddingBottom)

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun View.setPaddingEnd(padding: Int) = setPaddingRelative(paddingStart, paddingTop, padding, paddingBottom)

inline fun View.setAllPadding(padding: Int) {
    setPadding(padding, padding, padding, padding)
}

inline fun View.setOptionalPadding(left: Int = paddingLeft,
                            top: Int = paddingTop,
                            right: Int = paddingRight,
                            bottom: Int = paddingBottom) {
    setPadding(left, top, right, bottom)
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun View.setOptionalRelativePadding(start: Int = paddingStart,
                                    top: Int = paddingTop,
                                    end: Int = paddingEnd,
                                    bottom: Int = paddingBottom) {
    setPaddingRelative(start, top, end, bottom)
}

inline var View.marginLeft
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.leftMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.leftMargin = value }

inline var View.marginTop
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.topMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.topMargin = value }

inline var View.marginRight
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.rightMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.rightMargin = value }

inline var View.marginBottom
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.bottomMargin ?: 0
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.bottomMargin = value }

inline var View.marginStart
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.marginStart ?: 0
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.marginStart = value }

inline var  View.marginEnd
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get() = (layoutParams as ViewGroup.MarginLayoutParams?)?.marginEnd ?: 0
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    set(value) { (layoutParams as ViewGroup.MarginLayoutParams?)?.marginEnd = value }

inline fun View.setAllMargin(int: Int) {
    setOptionalMargin(int, int, int, int)
}

inline fun View.setAllRelativeMargin(int: Int) {
    setOptionalRelativeMargin(int, int, int, int)
}

inline fun View.setOptionalMargin(left: Int = marginLeft,
                           top: Int = marginTop,
                           right: Int = marginRight,
                           bottom: Int = marginBottom) {
    marginLeft = left
    marginTop = top
    marginRight = right
    marginBottom = bottom
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun View.setOptionalRelativeMargin(start: Int = marginStart,
                                   top: Int = marginTop,
                                   end: Int = marginEnd,
                                   bottom: Int = marginBottom) {
    marginStart = start
    marginTop = top
    marginEnd = end
    marginBottom = bottom
}

inline fun View.setHeight(height: Int) {
    resize(height = height)
}

inline fun View.setWidth(width: Int) {
    resize(width = width)
}

inline fun View.resize(width: Int = getWidth(), height: Int = getHeight()) {
    layoutParams?.let {
        it.width = width
        it.height = height
        layoutParams = it
    }
}