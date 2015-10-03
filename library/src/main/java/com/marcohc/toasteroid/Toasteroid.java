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

package com.marcohc.toasteroid;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Toasteroid {

    private static ImageView toastImage;
    private static TextView toastMessage;
    private static ViewGroup toastContainer;
    private static Toast myToast;
    private static View toastView;
    private static int marginBottom;

    public enum STYLES {
        SUCCESS, INFO, WARNING, ERROR, DELETE
    }

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    private static final int DEFAULT_GRAVITY = Gravity.BOTTOM;

    public static void show(Activity activity, String message, STYLES style) {
        show(activity, message, style, LENGTH_SHORT, DEFAULT_GRAVITY);
    }

    public static void show(Activity activity, String message, STYLES style, int duration) {
        show(activity, message, style, duration, DEFAULT_GRAVITY);
    }

    public static void show(Activity activity, String message, STYLES style, int duration, int gravity) {

        toastView = getToastView(activity);
        toastImage.setImageResource(getStyleIcon(style));
        toastContainer.setBackgroundResource(getStyleBackgroundColor(style));
        toastMessage.setText(message);

        myToast = new Toast(activity);

        myToast.setDuration(duration);
        myToast.setMargin(0, 0);
        myToast.setGravity(gravity, 0, marginBottom);
        myToast.setView(toastView);
        myToast.show();
    }

    private static View getToastView(Activity activity) {
        if (toastView == null) {
            toastView = activity.getLayoutInflater().inflate(R.layout.toasteroid_layout, null);
            toastImage = (ImageView) toastView.findViewById(R.id.toastImage);
            toastMessage = (TextView) toastView.findViewById(R.id.toastMessage);
            toastContainer = (ViewGroup) toastView.findViewById(R.id.toastContainer);
            marginBottom = (int) activity.getResources().getDimension(R.dimen.padding);
        }
        return toastView;
    }

    private static int getStyleIcon(STYLES style) {
        int resourceId;
        switch (style) {
            case SUCCESS:
                resourceId = R.drawable.ic_toasteroid_success;
                break;
            case INFO:
                resourceId = R.drawable.ic_toasteroid_info;
                break;
            case WARNING:
                resourceId = R.drawable.ic_toasteroid_warning;
                break;
            case ERROR:
                resourceId = R.drawable.ic_toasteroid_error;
                break;
            case DELETE:
                resourceId = R.drawable.ic_toasteroid_delete;
                break;
            default:
                resourceId = R.drawable.ic_toasteroid_info;
        }
        return resourceId;
    }

    private static int getStyleBackgroundColor(STYLES style) {
        int color;
        switch (style) {
            case SUCCESS:
                color = R.color.toasteroid_success;
                break;
            case INFO:
                color = R.color.toasteroid_info;
                break;
            case WARNING:
                color = R.color.toasteroid_warning;
                break;
            case ERROR:
                color = R.color.toasteroid_error;
                break;
            case DELETE:
                color = R.color.toasteroid_deleted;
                break;
            default:
                color = R.color.toasteroid_info;
                break;
        }
        return color;
    }

    public static void dismiss() {
        myToast.cancel();
    }

    public static boolean isShowing() {
        if (toastView != null && toastView.getVisibility() == View.VISIBLE) {
            return true;
        } else {
            return false;
        }
    }
}
