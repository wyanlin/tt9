package com.link.tt9.preferences.screens.appearance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.SwitchPreferenceCompat;

import com.link.tt9.preferences.settings.SettingsStore;
import com.link.tt9.util.sys.DeviceInfo;

public class ItemDragResize {
	public final static String NAME = "pref_drag_resize";

	private final SwitchPreferenceCompat item;
	private final SettingsStore settings;

	public ItemDragResize(@Nullable SwitchPreferenceCompat item, @NonNull SettingsStore settings) {
		this.item = item;
		this.settings = settings;
	}

	public ItemDragResize populate() {
		if (item != null) {
			item.setVisible(!DeviceInfo.noTouchScreen(item.getContext()));
			item.setChecked(settings.getDragResize());
		}

		return this;
	}
}
