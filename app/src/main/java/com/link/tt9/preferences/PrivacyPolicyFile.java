package com.link.tt9.preferences;

import android.content.Context;

import androidx.annotation.NonNull;

import com.link.tt9.BuildConfig;
import com.link.tt9.util.AssetFile;

public class PrivacyPolicyFile extends AssetFile {
	public PrivacyPolicyFile(@NonNull Context context) {
		super(context.getAssets(), BuildConfig.DOCS_DIR + "/privacy.html");
	}
}
