package me.lesmtech.nestedcategoryview.lib;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Author te.lin
 * @Since 9/9/16
 */
public class BottomShitBehavior extends BottomSheetBehavior {

  @Override
  public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent event) {
    return super.onInterceptTouchEvent(parent, child, event);
  }
}
