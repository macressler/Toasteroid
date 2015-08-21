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

package com.marcohc.toasteroid.sample;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Spinner;

import com.marcohc.toasteroid.AppMsg;
import com.marcohc.toasteroid.helper.Toasteroid;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Sample of Toasteroid library.
 *
 * @author Marco Hernaiz Cao
 */
public class MainActivity extends AppCompatActivity {

    private Spinner mStyle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStyle = (Spinner) findViewById(R.id.style_spnr);
        Button mButton = (Button) findViewById(R.id.show);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(v);
            }
        });
        if (SDK_INT >= JELLY_BEAN) {
            enableChangingTransition();
        }
    }

    @TargetApi(JELLY_BEAN)
    private void enableChangingTransition() {
        ViewGroup animatedRoot = (ViewGroup) findViewById(R.id.animated_root);
        animatedRoot.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    /**
     * Button onClick listener.
     *
     * @param v
     */
    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.show:
                showAppMsg();
                break;
            case R.id.cancel_all:
                AppMsg.cancelAll(this);
                break;
            default:
                return;
        }
    }

    private void showAppMsg() {

        final int positionSelected = mStyle.getSelectedItemPosition();
        switch (positionSelected) {
            case 0:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.SUCCESS);
                break;
            case 1:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.INFO);
                break;
            case 2:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.WARNING);
                break;
            case 3:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.ERROR);
                break;
            case 4:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.DELETE);
                break;
            case 5:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.INFO, 5000l);
                break;
            case 6:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.WARNING, Gravity.TOP);
                break;
            case 7:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.SUCCESS, AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left), AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // This is optional for 14+,
        // also you may want to call it at your later convenience, e.g. onDestroy
        if (SDK_INT < ICE_CREAM_SANDWICH) {
            AppMsg.cancelAll(this);
        }
    }
}
