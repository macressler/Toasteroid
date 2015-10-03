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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Spinner;

import com.marcohc.toasteroid.Toasteroid;

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
    }

    /**
     * Button onClick listener.
     *
     * @param v
     */
    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.showButton:
                showAppMsg();
                break;
            case R.id.cancelButton:
                Toasteroid.dismiss();
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
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.INFO, Toasteroid.LENGTH_LONG);
                break;
            case 6:
                Toasteroid.show(this, mStyle.getSelectedItem().toString(), Toasteroid.STYLES.WARNING, Toasteroid.LENGTH_SHORT, Gravity.TOP);
                break;
        }
    }
}
