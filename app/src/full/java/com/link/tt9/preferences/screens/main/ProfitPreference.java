package com.link.tt9.preferences.screens.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.link.tt9.BuildConfig;
import com.link.tt9.R;
import com.link.tt9.preferences.PreferencesActivity;
import com.link.tt9.ui.UI;
import com.link.tt9.util.Logger;

public class ProfitPreference extends Preference {
	public static final String NAME = "screen_profit";

	public ProfitPreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context);
	}

	public ProfitPreference(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public ProfitPreference(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ProfitPreference(@NonNull Context context) {
		super(context);
		init(context);
	}


	protected void init(@NonNull Context context) {
		setTitle(context.getString(R.string.donate_title));
		String appName = context.getString(R.string.app_name_short);
		setSummary(
			context.getString(R.string.donate_summary, appName) + " " + context.getString(R.string.donate_hold_to_open)
		);
	}


	@Override
	public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
		super.onBindViewHolder(holder);
		holder.itemView.setOnLongClickListener(this::onLongClick);
	}


	public ProfitPreference populate(@NonNull PreferencesActivity activity, boolean isTT9On) {
		boolean isVisible = isTT9On && !activity.getSettings().getDemoMode() && activity.getSettings().getDonationsVisible();
		setVisible(isVisible);
		setIconSpaceReserved(false);

		return this;
	}


	@Override
	protected void onClick() {
		super.onClick();
		UI.toastShortSingle(getContext(), R.string.donate_hold_to_open);
	}


	private boolean onLongClick(View v) {
		try {
			getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.DONATION_URL)));
			return true;
		} catch (Exception e) {
			Logger.w(getClass().getSimpleName(), "Cannot navigate to the donation page. " + e.getMessage() + " (do you have a browser?)");
			return false;
		}
	}
}
