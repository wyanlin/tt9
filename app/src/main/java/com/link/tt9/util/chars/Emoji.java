package com.link.tt9.util.chars;

import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Arrays;

import com.link.tt9.util.sys.DeviceInfo;

class Emoji extends Punctuation {
	final public static boolean NO_EMOJI_SUPPORT = !DeviceInfo.AT_LEAST_ANDROID_6;

	final private static ArrayList<String> TextEmoticons = new ArrayList<>(Arrays.asList(
		":)", ":D", ":P", ";)", "\\m/", ":-O", ":|", ":("
	));

	final private static ArrayList<ArrayList<String>> Emoji = new ArrayList<>(Arrays.asList(
		// positive
		new ArrayList<>(Arrays.asList(
			"🙂", "😀", "🤣", "🤓", "😎", "😛", "😉"
		)),
		// negative
		new ArrayList<>(Arrays.asList(
			"🙁", "😢", "😭", "😱", "😲", "😳", "😐", "😠"
		)),
		// hands
		new ArrayList<>(Arrays.asList(
			"👍", "👋", "✌️", "👏", "🖖", "🤘", "🤝", "💪", "👎"
		)),
		// emotions
		new ArrayList<>(Arrays.asList(
			"❤", "🤗", "😍", "😘", "😇", "😈", "🍺", "🎉", "🥱", "🤔", "🥶", "😬"
		))
	));

	public static boolean isGraphic(char ch) {
		return !(ch < 256 || Character.isLetterOrDigit(ch) || Character.isAlphabetic(ch));
	}

	public static ArrayList<String> getEmoji(int level) {
		if (NO_EMOJI_SUPPORT) {
			return new ArrayList<>(TextEmoticons);
		}

		if (level < 0 || level >= Emoji.size()) {
			return new ArrayList<>();
		}

		Paint paint = new Paint();
		ArrayList<String> availableEmoji = new ArrayList<>();
		for (String emoji : Emoji.get(level)) {
			if (paint.hasGlyph(emoji)) {
				availableEmoji.add(emoji);
			}
		}

		return availableEmoji.isEmpty() ? new ArrayList<>(TextEmoticons) : availableEmoji;
	}

	public static int getMaxEmojiLevel() {
		return NO_EMOJI_SUPPORT ? 1 : Emoji.size();
	}

	public static boolean isBuiltInEmoji(String emoji) {
		for (ArrayList<String> group : Emoji) {
			if (group.contains(emoji)) {
				return true;
			}
		}

		return false;
	}
}
