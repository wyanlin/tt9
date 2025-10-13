package com.link.tt9.preferences.screens.punctuation;

import androidx.preference.DropDownPreference;
import androidx.preference.Preference;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.link.tt9.languages.Language;
import com.link.tt9.languages.LanguageCollection;
import com.link.tt9.preferences.items.ItemDropDown;
import com.link.tt9.preferences.settings.SettingsStore;
import com.link.tt9.util.ConsumerCompat;

class ItemPunctuationOrderLanguage extends ItemDropDown {
	public static final String NAME = "punctuation_order_language";

	private ConsumerCompat<String> onChangeCallback;
	private final SettingsStore settings;

	ItemPunctuationOrderLanguage(SettingsStore settings, DropDownPreference item) {
		super(item);
		this.settings = settings;
	}

	@Override
	public ItemDropDown populate() {
		populateLanguages();
		return this;
	}


	private void populateLanguages() {
		if (item == null) {
			return;
		}

		LinkedHashMap<String, String> values = new LinkedHashMap<>();
		ArrayList<Language> languages = LanguageCollection.getAll(settings.getEnabledLanguageIds(), true);
		if (languages.isEmpty()) {
			return;
		}

		for (Language lang : languages) {
			values.put(String.valueOf(lang.getId()), lang.getName());
		}

		super.populate(values);
		super.setValue(String.valueOf(languages.get(0).getId()));
	}

	ItemPunctuationOrderLanguage onChange(ConsumerCompat<String> callback) {
		onChangeCallback = callback;
		return this;
	}

	@Override
	protected boolean onClick(Preference preference, Object newKey) {
		if (super.onClick(preference, newKey)) {
			if (onChangeCallback != null) {
				onChangeCallback.accept(newKey.toString());
			}
			return true;
		}

		return false;
	}
}
