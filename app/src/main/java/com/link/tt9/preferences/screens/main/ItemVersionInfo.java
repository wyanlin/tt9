package com.link.tt9.preferences.screens.main;

import androidx.preference.Preference;

import com.link.tt9.BuildConfig;
import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.preferences.items.ItemClickable;
import com.link.tt9.preferences.screens.debug.DebugScreen;

class ItemVersionInfo extends ItemClickable {
	static final String NAME = "version_info";

	private final PreferencesActivity activity;

	ItemVersionInfo(Preference item, PreferencesActivity activity) {
		super(item);
		this.activity = activity;
	}

	@Override
	protected boolean onClick(Preference p) {
		if (!activity.getSettings().getDemoMode()) {
			activity.displayScreen(DebugScreen.NAME);
		}

		return true;
	}

	ItemVersionInfo populate() {
		if (item != null) {
			item.setSummary(BuildConfig.VERSION_FULL);
		}
		return this;
	}
}
