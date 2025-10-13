package com.link.tt9.preferences.screens.modePredictive;

import android.content.Context;

import androidx.preference.DropDownPreference;

import java.util.LinkedHashMap;

import com.link.tt9.R;
import com.link.tt9.preferences.items.ItemDropDown;

class ItemSelectZeroKeyCharacter extends ItemDropDown {
	public static final String NAME = "pref_double_zero_char";

	private final Context context;

	ItemSelectZeroKeyCharacter(DropDownPreference dropDown, Context context) {
		super(dropDown);
		this.context = context;
	}

	public ItemSelectZeroKeyCharacter populate() {
		LinkedHashMap<String, String> items = new LinkedHashMap<>();
		items.put(".", ".");
		items.put(",", ",");
		items.put("\\n", context.getString(R.string.char_newline)); // SharedPreferences return a corrupted string when using the real "\n"... :(
		items.put(" ", context.getString(R.string.char_space));

		super.populate(items);
		return this;
	}
}
