package com.gluonhq.charm.down.plugins.android;

import android.content.pm.ActivityInfo;
import com.gluonhq.charm.down.plugins.CMOrientationService;
import javafx.geometry.Orientation;
import javafxports.android.FXActivity;

public class AndroidCMOrientationService implements CMOrientationService {
	private final FXActivity instance = FXActivity.getInstance();
	@Override
	public void coerceOrientation( Orientation orientation ) {
		if (orientation.equals(Orientation.HORIZONTAL)) {
			instance.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
		} else if (orientation.equals(Orientation.VERTICAL)) {
			instance.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
		instance.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
	}

	@Override
	public void releaseOrientation() {
		instance.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
	}
}
