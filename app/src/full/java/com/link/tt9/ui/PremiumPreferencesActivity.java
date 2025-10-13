package com.link.tt9.ui;

import androidx.annotation.Nullable;

import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.preferences.screens.BaseScreenFragment;
import com.link.tt9.ui.ActivityWithNavigation;

/**
 * Implemented in the "premium" source set. The open-source version
 * has no premium features, so this class has only minimal functionality.
 */
public class PremiumPreferencesActivity extends ActivityWithNavigation {
	protected BaseScreenFragment getScreen(PreferencesActivity prefsActivity, @Nullable String ignored) {
		return null;
	}
}
