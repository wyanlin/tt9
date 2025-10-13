package com.link.tt9.preferences.settings;

import android.content.Context;

class SettingsTyping extends SettingsPunctuation {
	SettingsTyping(Context context) { super(context); }

	public int getAbcAutoAcceptTimeout() {
		int time = getStringifiedInt("pref_abc_auto_accept_time", 800);
		return time > 0 ? time + getKeyPadDebounceTime() : time;
	}
	public boolean getAutoSpace() { return prefs.getBoolean("auto_space", false); }
	public boolean getAutoTextCase() { return prefs.getBoolean("auto_text_case", false); }
	public boolean getAutoCapitalsAfterNewline() {
		return getAutoTextCase() && prefs.getBoolean("auto_capitals_after_newline", false);
	}

	public boolean getBackspaceAcceleration() {
		return prefs.getBoolean("backspace_acceleration", false);
	}

	public boolean getBackspaceRecomposing() {
		return prefs.getBoolean("backspace_recomposing", false);
	}

	public String getDoubleZeroChar() {
		String character = prefs.getString("pref_double_zero_char", ".");

		// SharedPreferences return a corrupted string when using the real "\n"... :(
		return  character.equals("\\n") ? "\n" : character;
	}

	public boolean getPredictiveMode() {
		return prefs.getBoolean("pref_predictive_mode", false);
	}

	public boolean getPredictWordPairs() {
		return prefs.getBoolean("pref_predict_word_pairs", false);
	}

	public boolean getUpsideDownKeys() { return prefs.getBoolean("pref_upside_down_keys", false); }
}
