package me.hkgumbs.just_write.actions;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;

public class Theme implements MyMenuAction {

    @Override
    public void execute(final Activity activity, final ViewPager pager) {

	// toggle prefrence
	final SharedPreferences sp = activity
		.getPreferences(Context.MODE_PRIVATE);
	int p = pager.getCurrentItem();
	String position = p == 0 ? "" : Integer.toString(p);
	boolean dark = sp.getBoolean("DARK_THEME" + position, false);
	sp.edit().putBoolean("DARK_THEME" + position, !dark).apply();

	// redraw
	View current = pager.findViewWithTag("TAG" + position);
	current.invalidate();
    }

}
