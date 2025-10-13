package com.link.tt9.preferences;

import java.io.BufferedReader;
import java.io.IOException;

import com.link.tt9.ui.DocumentActivity;
import com.link.tt9.util.sys.SystemSettings;

public class HelpActivity extends DocumentActivity {
	@Override
	protected BufferedReader getDocumentReader() throws IOException {
		String systemLanguage = SystemSettings.getLocale().replaceFirst("_\\w+$", "");
		HelpFile file = new HelpFile(this, systemLanguage);
		file = file.exists() ? file : new HelpFile(this);
		return file.getReader();
	}
}
