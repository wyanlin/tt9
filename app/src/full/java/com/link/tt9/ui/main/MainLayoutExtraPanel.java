package com.link.tt9.ui.main;

import com.link.tt9.R;
import com.link.tt9.ime.TraditionalT9;
import com.link.tt9.ui.main.BaseMainLayout;

abstract class MainLayoutExtraPanel extends BaseMainLayout {
	MainLayoutExtraPanel(TraditionalT9 tt9, int xml) {
		super(tt9, xml);
	}

	@Override
	void showKeyboard() {
		togglePanel(R.id.main_panel_extra, false);
	}

	@Override
	void showTextEditingPalette() {
		togglePanel(R.id.main_panel_extra, false);
	}

	@Override
	void showCommandPalette() {
		togglePanel(R.id.main_panel_extra, false);
	}
}
