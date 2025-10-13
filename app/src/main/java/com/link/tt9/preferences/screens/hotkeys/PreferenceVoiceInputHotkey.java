package com.link.tt9.preferences.screens.hotkeys;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.link.tt9.ime.voice.VoiceInputOps;

public class PreferenceVoiceInputHotkey extends PreferenceHotkey {
	public PreferenceVoiceInputHotkey(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	public PreferenceVoiceInputHotkey(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public PreferenceVoiceInputHotkey(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public PreferenceVoiceInputHotkey(@NonNull Context context) {
		super(context);
	}

	@Override
	public void populate() {
		boolean isAvailable = new VoiceInputOps(getContext(), null, null, null).isAvailable();
		setVisible(isAvailable);
		if (isAvailable) {
			super.populate();
		}
	}
}
