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

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable

fun Drawable.tint(color: Int,
                  mode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN,
                  mutate: Boolean = true): Drawable {
    return if (mutate) {
        mutate().apply { setColorFilter(color, mode) }
    } else {
        setColorFilter(color, mode)
        this
    }
}