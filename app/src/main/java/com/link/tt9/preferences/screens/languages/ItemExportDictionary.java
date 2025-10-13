package com.link.tt9.preferences.screens.languages;

import androidx.preference.Preference;

import com.link.tt9.db.customWords.DictionaryExporter;
import com.link.tt9.languages.LanguageCollection;
import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.preferences.items.ItemExportAbstract;
import com.link.tt9.preferences.items.ItemProcessCustomWordsAbstract;
import com.link.tt9.util.Logger;

class ItemExportDictionary extends ItemExportAbstract {
	final public static String NAME = "dictionary_export";

	ItemExportDictionary(Preference item, PreferencesActivity activity, Runnable onStart, Runnable onFinish) {
		super(item, activity, onStart, onFinish);
	}

	@Override
	public ItemProcessCustomWordsAbstract refreshStatus() {
		if (item != null) {
			item.setVisible(Logger.isDebugLevel());
		}
		return super.refreshStatus();
	}

	@Override
	protected DictionaryExporter getProcessor() {
		return DictionaryExporter.getInstance();
	}

	protected boolean onStartProcessing() {
		return DictionaryExporter.getInstance()
			.setLanguages(LanguageCollection.getAll(activity.getSettings().getEnabledLanguageIds()))
			.run(activity);
	}

	public void enable() {
		super.enable();
		item.setSummary("");
	}
}
