package com.link.tt9.ime.voice;

import android.content.Context;
import android.speech.SpeechRecognizer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.link.tt9.languages.Language;
import com.link.tt9.util.sys.DeviceInfo;

public class SpeechRecognizerSupportLegacy {
	final boolean isOnDeviceRecognitionAvailable;
	final boolean isRecognitionAvailable;

	SpeechRecognizerSupportLegacy(@NonNull Context ims) {
		isOnDeviceRecognitionAvailable = DeviceInfo.AT_LEAST_ANDROID_12 && SpeechRecognizer.isOnDeviceRecognitionAvailable(ims);
		isRecognitionAvailable = SpeechRecognizer.isRecognitionAvailable(ims);
	}

	SpeechRecognizerSupportLegacy setLanguage(Language l) { return this; }
	void checkOfflineSupport(@NonNull Runnable onSupportChecked) { onSupportChecked.run(); }
	boolean isLanguageSupportedOffline(@Nullable Language l) { return false; }
}
