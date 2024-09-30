package com.serour.ranamaeak.memorygame.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.serour.ranamaeak.R;
import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.model.GameState;

public class PopupManager {
	public static void showPopupWon(GameState gameState) {
		RelativeLayout popupContainer = (RelativeLayout) Shared.activity.findViewById(R.id.popup_container);
		popupContainer.removeAllViews();

		// popup
		PopupWonView popupWonView = new PopupWonView(Shared.context);
		popupWonView.setGameState(gameState);
		int width = Shared.context.getResources().getDimensionPixelSize(R.dimen.popup_won_width);
		int height = Shared.context.getResources().getDimensionPixelSize(R.dimen.popup_won_height);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		popupContainer.addView(popupWonView, params);

		// animate all together
		ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(popupWonView, "scaleX", 0f, 1f);
		ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(popupWonView, "scaleY", 0f, 1f);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
		animatorSet.setDuration(500);
		animatorSet.setInterpolator(new DecelerateInterpolator(2));
		popupWonView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		animatorSet.start();
	}

	public static void closePopup() {
		final RelativeLayout popupContainer = (RelativeLayout) Shared.activity.findViewById(R.id.popup_container);
		int childCount = popupContainer.getChildCount();
		if (childCount > 0) {
			View background = null;
			View viewPopup = null;
			if (childCount == 1) {
				viewPopup = popupContainer.getChildAt(0);
			} else {
				background = popupContainer.getChildAt(0);
				viewPopup = popupContainer.getChildAt(1);
			}

			AnimatorSet animatorSet = new AnimatorSet();
			ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(viewPopup, "scaleX", 0f);
			ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(viewPopup, "scaleY", 0f);
			if (childCount > 1) {
				ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(background, "alpha", 0f);
				animatorSet.playTogether(scaleXAnimator, scaleYAnimator, alphaAnimator);
			} else {
				animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
			}
			animatorSet.setDuration(300);
			animatorSet.setInterpolator(new AccelerateInterpolator(2));
			animatorSet.addListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					popupContainer.removeAllViews();
				}
			});
			animatorSet.start();
		}
	}

	public static boolean isShown() {
		RelativeLayout popupContainer = (RelativeLayout) Shared.activity.findViewById(R.id.popup_container);
		return popupContainer.getChildCount() > 0;
	}
}
