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
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AppMsg {

    public static final int LENGTH_SHORT = 3000;
    public static final int LENGTH_LONG = 5000;
    public static final int LENGTH_STICKY = -1;
    public static final int PRIORITY_LOW = Integer.MIN_VALUE;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_HIGH = Integer.MAX_VALUE;

    public static final AppMsgStyle SUCCESS_APP_MSG_STYLE = new AppMsgStyle(LENGTH_SHORT, R.color.success);
    public static final AppMsgStyle INFO_APP_MSG_STYLE = new AppMsgStyle(LENGTH_SHORT, R.color.info);
    public static final AppMsgStyle WARNING_APP_MSG_STYLE = new AppMsgStyle(LENGTH_SHORT, R.color.warning);
    public static final AppMsgStyle ERROR_APP_MSG_STYLE = new AppMsgStyle(LENGTH_SHORT, R.color.error);
    public static final AppMsgStyle DELETE_APP_MSG_STYLE = new AppMsgStyle(LENGTH_SHORT, R.color.deleted);

    private Activity mActivity;
    private int mDuration = LENGTH_SHORT;
    private View mView;
    private ViewGroup mParent;
    private LayoutParams mLayoutParams;
    private boolean mFloating;
    Animation mInAnimation, mOutAnimation;
    int mPriority = PRIORITY_NORMAL;

    public AppMsg(Activity activity) {
        mActivity = activity;
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle) {
        return makeText(context, text, appMsgStyle, R.layout.toasteroid_layout);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, OnClickListener clickListener) {
        return makeText(context, text, appMsgStyle, R.layout.toasteroid_layout);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, float textSize) {
        return makeText(context, text, appMsgStyle, R.layout.toasteroid_layout, textSize);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, float textSize, OnClickListener clickListener) {
        return makeText(context, text, appMsgStyle, R.layout.toasteroid_layout, textSize, clickListener);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View customView) {
        return makeText(context, text, appMsgStyle, customView, false);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View customView, OnClickListener clickListener) {
        return makeText(context, text, appMsgStyle, customView, false, clickListener);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View view, boolean floating) {
        return makeText(context, text, appMsgStyle, view, floating, 0);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View view, boolean floating, OnClickListener clickListener) {
        return makeText(context, text, appMsgStyle, view, floating, 0, clickListener);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, int layoutId) {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(layoutId, null);
        return makeText(context, text, appMsgStyle, v, true);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, int layoutId, OnClickListener clickListener) {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(layoutId, null);
        return makeText(context, text, appMsgStyle, v, true);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, int layoutId, float textSize, OnClickListener clickListener) {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(layoutId, null);
        return makeText(context, text, appMsgStyle, v, true, textSize, clickListener);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, int layoutId, float textSize) {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(layoutId, null);
        return makeText(context, text, appMsgStyle, v, true, textSize);
    }

    public static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View view, boolean floating, float textSize) {
        AppMsg result = new AppMsg(context);

        view.setBackgroundResource(appMsgStyle.background);

        TextView tv = (TextView) view.findViewById(R.id.message);
        if (textSize > 0) tv.setTextSize(textSize);
        tv.setText(text);

        result.mView = view;
        result.mDuration = appMsgStyle.duration;
        result.mFloating = floating;

        return result;
    }

    private static AppMsg makeText(Activity context, String text, AppMsgStyle appMsgStyle, View view, boolean floating, float textSize, OnClickListener clickListener) {
        AppMsg result = new AppMsg(context);

        view.setBackgroundResource(appMsgStyle.background);
        view.setClickable(true);

        TextView tv = (TextView) view.findViewById(R.id.message);
        if (textSize > 0) tv.setTextSize(textSize);
        tv.setText(text);

        result.mView = view;
        result.mDuration = appMsgStyle.duration;
        result.mFloating = floating;

        view.setOnClickListener(clickListener);

        return result;
    }

//    public static AppMsg makeText(Activity context, int resId, Style style, View customView, boolean floating) {
//        return makeText(context, context.getResources().getText(resId), style, customView, floating);
//    }
//
//    public static AppMsg makeText(Activity context, int resId, Style style) throws Resources.NotFoundException {
//        return makeText(context, context.getResources().getText(resId), style);
//    }
//
//    public static AppMsg makeText(Activity context, int resId, Style style, int layoutId)
//            throws Resources.NotFoundException {
//        return makeText(context, context.getResources().getText(resId), style, layoutId);
//    }

    public void show() {
        MsgManager manager = MsgManager.obtain(mActivity);
        manager.add(this);
    }

    public boolean isShowing() {
        if (mFloating) {
            return mView != null && mView.getParent() != null;
        } else {
            return mView.getVisibility() == View.VISIBLE;
        }
    }

    public void cancel() {
        MsgManager.obtain(mActivity).clearMsg(this);
    }

    public static void cancelAll() {
        MsgManager.clearAll();
    }

    public static void cancelAll(Activity activity) {
        MsgManager.release(activity);
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setView(View view) {
        mView = view;
    }

    public View getView() {
        return mView;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setText(String s) {
        if (mView == null) {
            throw new RuntimeException("This AppMsg was not created with AppMsg.makeText()");
        }
        TextView tv = (TextView) mView.findViewById(R.id.message);
        if (tv == null) {
            throw new RuntimeException("This AppMsg was not created with AppMsg.makeText()");
        }
        tv.setText(s);
    }

    public LayoutParams getLayoutParams() {
        if (mLayoutParams == null) {
            mLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        }
        return mLayoutParams;
    }

    public AppMsg setLayoutParams(LayoutParams layoutParams) {
        mLayoutParams = layoutParams;
        return this;
    }

    public AppMsg setLayoutGravity(int gravity) {
        mLayoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, gravity);
        return this;
    }

    public boolean isFloating() {
        return mFloating;
    }

    public void setFloating(boolean mFloating) {
        this.mFloating = mFloating;
    }

    public AppMsg setAnimation(int inAnimation, int outAnimation) {
        return setAnimation(AnimationUtils.loadAnimation(mActivity, inAnimation), AnimationUtils.loadAnimation(mActivity, outAnimation));
    }

    public AppMsg setAnimation(Animation inAnimation, Animation outAnimation) {
        mInAnimation = inAnimation;
        mOutAnimation = outAnimation;
        return this;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public ViewGroup getParent() {
        return mParent;
    }

    public void setParent(ViewGroup parent) {
        mParent = parent;
    }

    public void setParent(int parentId) {
        setParent((ViewGroup) mActivity.findViewById(parentId));
    }

}
