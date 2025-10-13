package com.link.tt9.preferences;

import android.content.Context;

import androidx.annotation.NonNull;

import com.link.tt9.BuildConfig;
import com.link.tt9.util.AssetFile;

public class HelpFile extends AssetFile {
	public HelpFile(@NonNull Context context, String language) {
		super(context.getAssets(), BuildConfig.DOCS_DIR + "/help." + language + ".html");
	}

	public HelpFile(@NonNull Context context) {
		super(context.getAssets(), BuildConfig.DOCS_DIR + "/help.en.html");
	}
}
