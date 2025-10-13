package com.link.tt9.ui;

import android.view.HapticFeedbackConstants;
import android.view.View;

import androidx.annotation.NonNull;

import com.link.tt9.preferences.settings.SettingsStore;
import com.link.tt9.ui.main.keys.BaseClickableKey;
import com.link.tt9.ui.main.keys.SoftKeyNumber;
import com.link.tt9.util.sys.DeviceInfo;

public class Vibration {
	@NonNull private final SettingsStore settings;
	private final View view;

	public Vibration(@NonNull SettingsStore settings, View view) {
		this.settings = settings;
		this.view = view;
	}

	public static int getNoVibration() {
		return -1;
	}

	public static int getPressVibration(BaseClickableKey key) {
		return key instanceof SoftKeyNumber ? HapticFeedbackConstants.KEYBOARD_TAP : HapticFeedbackConstants.VIRTUAL_KEY;
	}

	public static int getHoldVibration() {
		if (DeviceInfo.AT_LEAST_ANDROID_11) {
			return HapticFeedbackConstants.CONFIRM;
		} else {
			return HapticFeedbackConstants.VIRTUAL_KEY;
		}
	}

	public static int getReleaseVibration() {
		if (DeviceInfo.AT_LEAST_ANDROID_8_1) {
			return HapticFeedbackConstants.KEYBOARD_RELEASE;
		} else {
			return HapticFeedbackConstants.VIRTUAL_KEY;
		}
	}

	public void vibrate(int vibrationType) {
		if (settings.getHapticFeedback() && view != null) {
			view.performHapticFeedback(vibrationType, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
		}
	}

	public void vibrate() {
		vibrate(getPressVibration(null));
	}
}
