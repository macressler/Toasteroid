/*
 * Copyright 2015 Marco Hernaiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marcohc.toasteroid;

import com.marcohc.toasteroid.helper.Toasteroid;

public class AppMsgStyle {

    final int duration;
    final int background;

    /**
     * Construct an {@link com.marcohc.toasteroid.helper.Toasteroid.STYLES} object.
     *
     * @param duration How long to display the message
     * @param resId    resource for AppMsg background
     */
    public AppMsgStyle(int duration, int resId) {
        this.duration = duration;
        this.background = resId;
    }

    /**
     * Return the duration in milliseconds.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Return the resource id of background.
     */
    public int getBackground() {
        return background;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Toasteroid.STYLES)) {
            return false;
        }
        AppMsgStyle appMsgStyle = (AppMsgStyle) o;
        return appMsgStyle.duration == duration && appMsgStyle.background == background;
    }

}
