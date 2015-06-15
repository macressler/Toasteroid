/*
 * Copyright 2015 Marco Hernaiz Cao
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

package com.marcohc.toasteroid.helper;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.marcohc.toasteroid.AppMsg;
import com.marcohc.toasteroid.AppMsgStyle;
import com.marcohc.toasteroid.R;

public class Toasteroid {

    public enum STYLES {
        SUCCESS, INFO, WARNING, ERROR, DELETE
    }

    private static AppMsg toast;
    private static final int DEFAULT_DISPLAY_DURATION = 2500;

    private static void show(Activity activity, String message, STYLES style, int gravity, Animation inAnimation, Animation outAnimation) {
        show(activity, message, style, -1, gravity, inAnimation, outAnimation);
    }

    private static void show(Activity activity, String message, STYLES style, long duration, int gravity) {
        show(activity, message, style, duration, gravity, null, null);
    }

    private static void show(Activity activity, String message, STYLES style, long duration, Animation inAnimation, Animation outAnimation) {
        show(activity, message, style, duration, -1, inAnimation, outAnimation);
    }

    public static void show(Activity activity, String message, STYLES style, Animation inAnimation, Animation outAnimation) {
        show(activity, message, style, -1, -1, inAnimation, outAnimation);
    }

    public static void show(Activity activity, String message, STYLES style, int gravity) {
        show(activity, message, style, -1, gravity, null, null);
    }

    public static void show(Activity activity, String message, STYLES style, long duration) {
        show(activity, message, style, duration, -1, null, null);
    }

    public static void show(Activity activity, String message, STYLES style) {
        show(activity, message, style, -1, -1, null, null);
    }

    private static void show(Activity activity, String message, STYLES style, long duration, int gravity, Animation inAnimation, Animation outAnimation) {

        View view = activity.getLayoutInflater().inflate(R.layout.toasteroid_layout, null);
        ImageView notificationImage = (ImageView) view.findViewById(R.id.image);

        AppMsgStyle appMsgStyle = getAppMsgStyle(style);
        notificationImage.setImageResource(getIconByStyle(style));

        if (toast != null) {
            toast.clear();
            toast.cancel();
            toast = null;
        }

        toast = AppMsg.makeText(activity, message, appMsgStyle, view, true);

        if (inAnimation != null && outAnimation != null) {
            toast.setAnimation(inAnimation, outAnimation);
        }

        if (duration != -1) {
            toast.setDuration((int) duration);
        } else {
            toast.setDuration(DEFAULT_DISPLAY_DURATION);
        }

        if (gravity != -1) {
            toast.setLayoutGravity(gravity);
        } else {
            toast.setLayoutGravity(Gravity.BOTTOM);
        }

        toast.show();
    }

    private static int getIconByStyle(STYLES style) {
        int resourceId;
        switch (style) {
            case SUCCESS:
                resourceId = R.drawable.ic_success;
                break;
            case INFO:
                resourceId = R.drawable.ic_info;
                break;
            case WARNING:
                resourceId = R.drawable.ic_warning;
                break;
            case ERROR:
                resourceId = R.drawable.ic_error;
                break;
            case DELETE:
                resourceId = R.drawable.ic_delete;
                break;
            default:
                resourceId = R.drawable.ic_info;
        }
        return resourceId;
    }

    private static AppMsgStyle getAppMsgStyle(STYLES style) {
        AppMsgStyle styleForAppMsg;
        switch (style) {
            case SUCCESS:
                styleForAppMsg = AppMsg.SUCCESS_APP_MSG_STYLE;
                break;
            case INFO:
                styleForAppMsg = AppMsg.INFO_APP_MSG_STYLE;
                break;
            case WARNING:
                styleForAppMsg = AppMsg.WARNING_APP_MSG_STYLE;
                break;
            case ERROR:
                styleForAppMsg = AppMsg.ERROR_APP_MSG_STYLE;
                break;
            case DELETE:
                styleForAppMsg = AppMsg.DELETE_APP_MSG_STYLE;
                break;
            default:
                styleForAppMsg = AppMsg.INFO_APP_MSG_STYLE;
                break;
        }
        return styleForAppMsg;
    }

    public static void dismiss() {
        if (toast != null && toast.isShowing()) {
            toast.cancel();
            toast = null;
        }
    }

    public static boolean isShowing() {
        if (toast != null && toast.isShowing()) {
            return true;
        } else {
            return false;
        }
    }
}
