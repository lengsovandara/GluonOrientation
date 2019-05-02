package com.gluonhq.charm.down.plugins;

import javafx.geometry.Orientation;

public interface CMOrientationService {
	void coerceOrientation(Orientation orientation );

	void releaseOrientation();
}
