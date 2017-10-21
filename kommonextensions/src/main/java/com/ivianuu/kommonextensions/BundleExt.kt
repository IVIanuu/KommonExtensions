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

import android.content.Intent
import android.os.Bundle

inline fun createBundle(func: Bundle.() -> Unit): Bundle {
    val bundle = Bundle()
    bundle.func()
    return bundle
}

inline fun createBundle(loader: ClassLoader, func: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(loader)
    bundle.func()
    return bundle
}

inline fun createBundle(capacity: Int, func: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(capacity)
    bundle.func()
    return bundle
}

inline fun createBundle(b: Bundle?, func: Bundle.() -> Unit): Bundle {
    val bundle = Bundle(b)
    bundle.func()
    return bundle
}