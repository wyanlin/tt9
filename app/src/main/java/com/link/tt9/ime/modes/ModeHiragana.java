package com.link.tt9.ime.modes;

import com.link.tt9.hacks.InputType;
import com.link.tt9.ime.helpers.TextField;
import com.link.tt9.ime.modes.predictions.KanaPredictions;
import com.link.tt9.languages.Language;
import com.link.tt9.preferences.settings.SettingsStore;

public class ModeHiragana extends ModeKanji {
	protected ModeHiragana(SettingsStore settings, Language lang, InputType inputType, TextField textField) {
		super(settings, lang, inputType, textField);
		NAME = "ひらがな";
	}

	@Override
	protected void initPredictions() {
		predictions = new KanaPredictions(settings, textField, seq, false);
		predictions.setWordsChangedHandler(this::onPredictions);
	}

	@Override
	public int getId() {
		return MODE_HIRAGANA;
	}
}
