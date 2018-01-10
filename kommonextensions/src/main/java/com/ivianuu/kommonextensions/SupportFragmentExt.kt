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

import android.app.Activity
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

inline val Fragment.appCompatActivity get() = activity as AppCompatActivity?

inline fun Fragment.getContextOrThrow(): Context {
    context?.let { return it }
    throw IllegalStateException("not attached")
}

inline fun Fragment.getActivityOrThrow(): Activity {
    activity?.let { return it }
    throw IllegalStateException("not attached")
}

inline fun Fragment.getAppCompatActivityOrThrow(): Activity {
    activity?.let { return it as AppCompatActivity }
    throw IllegalStateException("not attached")
}

inline fun Fragment.hideInputMethod() {
    activity?.hideInputMethod()
}

inline fun Fragment.showInputMethod(view: View) {
    activity?.showInputMethod(view)
}

inline fun Fragment.inflate(@LayoutRes resourceId: Int, root: ViewGroup?, attachToRoot: Boolean = false): View =
        LayoutInflater.from(activity).inflate(resourceId, root, attachToRoot)
