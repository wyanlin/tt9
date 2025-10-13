package com.link.tt9.preferences.screens.languages;

import androidx.preference.Preference;

import com.link.tt9.R;
import com.link.tt9.db.customWords.CustomWordsExporter;
import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.preferences.items.ItemExportAbstract;

class ItemExportCustomWords extends ItemExportAbstract {
	final public static String NAME = "dictionary_export_custom";

	ItemExportCustomWords(Preference item, PreferencesActivity activity, Runnable onStart, Runnable onFinish) {
		super(item, activity, onStart, onFinish);
	}

	@Override
	protected CustomWordsExporter getProcessor() {
		return CustomWordsExporter.getInstance();
	}

	protected boolean onStartProcessing() {
		return CustomWordsExporter.getInstance().run(activity);
	}

	public void enable() {
		super.enable();
		item.setSummary(activity.getString(
			R.string.dictionary_export_custom_words_summary,
			CustomWordsExporter.getInstance().getOutputDir()
		));
	}
}
