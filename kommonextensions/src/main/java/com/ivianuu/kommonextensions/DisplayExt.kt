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
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.support.annotation.Px
import android.util.DisplayMetrics
import android.view.Surface
import android.view.WindowManager
import androidx.content.systemService

private val systemMetrics: DisplayMetrics get() = Resources.getSystem().displayMetrics

val Int.dp: Float get() = (this * systemMetrics.density)

val Int.sp: Float get() = (this * systemMetrics.scaledDensity)

fun Context.isPortrait(): Boolean = !isLandscape()

fun Context.isLandscape(): Boolean {
    val rotation = getRotation()
    return rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270
}

fun Context.getRotation(): Int = windowManager.defaultDisplay.rotation

private val displayMetrics = DisplayMetrics()

@Px
fun Context.getScreenHeight(): Int {
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}

@Px
fun Context.getScreenWidth(): Int {

    windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenHeight(): Int {
    windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics.heightPixels
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@Px
fun Context.getRealScreenWidth(): Int {
    windowManager.defaultDisplay.getRealMetrics(displayMetrics)
    return displayMetrics.widthPixels
}