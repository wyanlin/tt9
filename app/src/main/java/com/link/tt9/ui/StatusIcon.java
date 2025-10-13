package com.link.tt9.ui;

import androidx.annotation.Nullable;

import java.util.HashMap;

import com.link.tt9.R;
import com.link.tt9.ime.modes.InputMode;
import com.link.tt9.ime.modes.InputModeKind;
import com.link.tt9.languages.Language;
import com.link.tt9.preferences.settings.SettingsStore;

public class StatusIcon {
	private static final HashMap<String, Integer> ICONS = new HashMap<>();
	public final int resourceId;


	public StatusIcon(@Nullable SettingsStore settings, @Nullable InputMode mode, @Nullable Language language, int textCase) {
		if (ICONS.isEmpty()) {
			generateIconsCache();
		}
		resourceId = resolveResourcePerMode(settings, mode, language, textCase);
	}


	/**
	 * Generates a cache of icons for different input modes and languages.
	 * WARNING: This method is auto-generated and should not be modified manually.
	 * To update the icons, run the `updateStatusIcons` gradle task.
	 */
	private void generateIconsCache() { ICONS.put("ic_lang_en_cp", R.drawable.ic_lang_en_cp);ICONS.put("ic_lang_en_lo", R.drawable.ic_lang_en_lo);ICONS.put("ic_lang_en_up", R.drawable.ic_lang_en_up);ICONS.put("ic_lang_hn_cp", R.drawable.ic_lang_hn_cp);ICONS.put("ic_lang_hn_lo", R.drawable.ic_lang_hn_lo);ICONS.put("ic_lang_hn_up", R.drawable.ic_lang_hn_up);ICONS.put("ic_lang_latin_lo", R.drawable.ic_lang_latin_lo);ICONS.put("ic_lang_latin_up", R.drawable.ic_lang_latin_up);ICONS.put("ic_lang_zh_pinyin", R.drawable.ic_lang_zh_pinyin); }


	private int resolveResourcePerMode(@Nullable SettingsStore settings, @Nullable InputMode mode, @Nullable Language language, int textCase) {
		if (language == null || mode == null || settings == null || InputModeKind.isPassthrough(mode) || !settings.isStatusIconEnabled()) {
			return 0;
		}

		if (InputModeKind.isHiragana(mode)) {
			return R.drawable.ic_lang_hiragana;
		} else if (InputModeKind.isKatakana(mode)) {
			return R.drawable.ic_lang_katakana;
		} else if (InputModeKind.is123(mode)) {
			return R.drawable.ic_lang_123;
		} else if (InputModeKind.isABC(mode)) {
			return getResourceId(getResourceName(mode, language, textCase), R.drawable.ic_keyboard);
		} else if (InputModeKind.isPredictive(mode)) {
			return getResourceId(getResourceName(mode, language, textCase), R.drawable.ic_keyboard);
		}

		return R.drawable.ic_keyboard;
	}


	@Nullable
	private String getResourceName(@Nullable InputMode mode, @Nullable Language language, int textCase) {
		if (mode == null || language == null) {
			return null;
		}

		final StringBuilder key = new StringBuilder();
		key.append(InputModeKind.isABC(mode) ? language.getIconABC() : language.getIconT9());

		switch (textCase) {
			case InputMode.CASE_UPPER:
				key.append("_up");
				break;
			case InputMode.CASE_LOWER:
				key.append("_lo");
				break;
			case InputMode.CASE_CAPITALIZE:
				key.append("_cp");
				break;
		}

		return key.toString();
	}


	private int getResourceId(@Nullable String key, int defaultValue) {
		Integer resId = null;
		if (key != null && ICONS.containsKey(key)) {
			resId = ICONS.get(key);
		}

		return resId != null ? resId : defaultValue;
	}
}
