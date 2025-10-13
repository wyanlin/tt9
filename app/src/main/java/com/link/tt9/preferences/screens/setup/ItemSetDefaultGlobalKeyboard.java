package com.link.tt9.preferences.screens.setup;

import androidx.preference.Preference;

import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.preferences.items.ItemClickable;
import com.link.tt9.ui.UI;

class ItemSetDefaultGlobalKeyboard extends ItemClickable {
	private final PreferencesActivity activity;

	ItemSetDefaultGlobalKeyboard(Preference item, PreferencesActivity prefs) {
		super(item);
		this.activity = prefs;
	}

	@Override
	protected boolean onClick(Preference p) {
		UI.showChangeKeyboardDialog(activity);
		return false;
	}
}
