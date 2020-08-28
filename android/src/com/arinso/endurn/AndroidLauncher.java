package com.arinso.endurn;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class AndroidLauncher extends AndroidApplication implements AdHandler, RewardedVideoAdListener {
	private static final String TAG = "AndroidLauncher";
	private static final String APP_ID="ca-app-pub-8943470956577194~7383369464";
	private static final String BANNER_AD_ID="ca-app-pub-8943470956577194/9017135866";
	private static final String REWARDED_AD_ID="ca-app-pub-3940256099942544/5224354917";
	//private static final String REWARDED_AD_ID="ca-app-pub-8943470956577194/5692005465";
	private final int SHOW_ADS = 1;
	private final int HIDE_ADS = 0;
	protected AdView adView;
	private RewardedVideoAd mAd;
	public static Boolean REWARD;


	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
				case SHOW_ADS:
					adView.setVisibility(View.VISIBLE);
					break;
				case HIDE_ADS:
					adView.setVisibility(View.GONE);
					break;
			}
		}
	};

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		RelativeLayout layout = new RelativeLayout(this);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.numSamples = 2;

		View gameView = initializeForView(new GameClass(this), config);
		layout.addView(gameView);

		adView = new AdView(this);
		adView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				int visibility = adView.getVisibility();
				adView.setVisibility(AdView.GONE);
				adView.setVisibility(visibility);
				Log.i(TAG, "Ad Loaded...");
			}
		});
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(BANNER_AD_ID);

		AdRequest.Builder builder = new AdRequest.Builder();
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);

		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		adParams.addRule(RelativeLayout.CENTER_IN_PARENT);

		layout.addView(adView, adParams);
		adView.loadAd(builder.build());


		MobileAds.initialize(this, APP_ID);
		mAd = MobileAds.getRewardedVideoAdInstance(this);
		mAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
			@Override
			public void onRewardedVideoAdLoaded() {}

			@Override
			public void onRewardedVideoAdOpened() {}

			@Override
			public void onRewardedVideoStarted() {}

			@Override
			public void onRewardedVideoAdClosed() {
				loadRewardedVideoAd();
			}

			@Override
			public void onRewarded(RewardItem rewardItem) {
				GameClass.prefs.putInteger("Coin",GameClass.prefs.getInteger("Coin")+10);
				loadRewardedVideoAd();  // Load for next Reward Point
			}

			@Override
			public void onRewardedVideoAdLeftApplication() {}

			@Override
			public void onRewardedVideoAdFailedToLoad(int i) {}
		});
		loadRewardedVideoAd();

		setContentView(layout);
	}

	@Override
	public void showAds(boolean show) {
		handler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
	}

	@Override
	public void showVideoAd(){
		runOnUiThread(new Runnable() {
			public void run() {
				if (mAd.isLoaded()) {
					mAd.show();
				} else {
					loadRewardedVideoAd();
				}
			}
		});
	}

	private void loadRewardedVideoAd() {
		mAd.loadAd(REWARDED_AD_ID, new AdRequest.Builder().build());
	}


	@Override
	public void onRewardedVideoAdLoaded() {

	}

	@Override
	public void onRewardedVideoAdOpened() {

	}

	@Override
	public void onRewardedVideoStarted() {

	}

	@Override
	public void onRewardedVideoAdClosed() {

	}

	@Override
	public void onRewarded(RewardItem rewardItem) {

	}

	@Override
	public void onRewardedVideoAdLeftApplication() {

	}

	@Override
	public void onRewardedVideoAdFailedToLoad(int i) {

	}
}