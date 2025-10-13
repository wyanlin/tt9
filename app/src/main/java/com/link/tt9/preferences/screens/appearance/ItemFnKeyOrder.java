package com.link.tt9.preferences.screens.appearance;

import androidx.preference.Preference;

import com.link.tt9.preferences.items.ItemClickable;
import com.link.tt9.preferences.settings.SettingsStore;
import com.link.tt9.util.sys.DeviceInfo;

public class ItemFnKeyOrder extends ItemClickable implements ItemLayoutChangeReactive {
	public static final String NAME = "screen_fn_key_order";
	public ItemFnKeyOrder(SettingsStore settings, Preference item) {
		super(item);
		onLayoutChange(settings.getMainViewLayout());
	}

	@Override protected boolean onClick(Preference p) { return true; }

	public void onLayoutChange(int mainViewLayout) {
		if (item != null) {
			item.setVisible(mainViewLayout == SettingsStore.LAYOUT_NUMPAD && !DeviceInfo.noTouchScreen(item.getContext()));
			item.setIconSpaceReserved(false);
		}
	}
}
