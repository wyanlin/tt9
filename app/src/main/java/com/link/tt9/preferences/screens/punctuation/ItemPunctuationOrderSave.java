package com.link.tt9.preferences.screens.punctuation;

import androidx.preference.Preference;

import com.link.tt9.R;
import com.link.tt9.languages.Language;
import com.link.tt9.preferences.items.ItemClickable;

public class ItemPunctuationOrderSave extends ItemClickable {
	public static final String NAME = "punctuation_order_save";
	private final Runnable clickHandler;

	public ItemPunctuationOrderSave(Preference item, Runnable clickHandler) {
		super(item);
		this.clickHandler = clickHandler;
	}

	ItemPunctuationOrderSave setLanguage(Language language) {
		if (item != null) {
			item.setTitle(item.getContext().getString(R.string.punctuation_order_save, language.getName()));
		}
		return this;
	}

	@Override
	protected boolean onClick(Preference p) {
		if (clickHandler == null) {
			return false;
		}

		clickHandler.run();
		return true;
	}
}
