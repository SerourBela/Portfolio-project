package com.serour.ranamaeak.memorygame.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;

import com.serour.ranamaeak.R;
import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.events.ui.FlipCardEvent;
import com.serour.ranamaeak.memorygame.model.BoardArrangment;
import com.serour.ranamaeak.memorygame.model.BoardConfiguration;
import com.serour.ranamaeak.memorygame.model.Game;
import com.serour.ranamaeak.memorygame.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryPhoto extends LinearLayout {

	private LayoutParams mRowLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	private LayoutParams mTileLayoutParams;
	private int mScreenWidth;
	private int mScreenHeight;
	private BoardConfiguration mBoardConfiguration;
	private BoardArrangment mBoardArrangment;
	private Map<Integer, PhotoView> mViewReference;
	private List<Integer> flippedUp = new ArrayList<Integer>();
	private boolean mLocked = false;
	private int mSize;

	public MemoryPhoto(Context context) {
		this(context, null);
	}

	public MemoryPhoto(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		setOrientation(LinearLayout.VERTICAL);
		setGravity(Gravity.CENTER);
		int padding = getResources().getDimensionPixelSize(R.dimen.board_padding);
		mScreenHeight = getResources().getDisplayMetrics().heightPixels  - padding*2;
		mScreenWidth = getResources().getDisplayMetrics().widthPixels - padding*2 - Utils.px(20);
		mViewReference = new HashMap<Integer, PhotoView>();
		setClipToPadding(false);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
	}

	public static MemoryPhoto fromXml(Context context, ViewGroup parent) {
		return (MemoryPhoto) LayoutInflater.from(context).inflate(R.layout.photos_view, parent, false);
	}

	public void setBoard(Game game) {
		mBoardConfiguration = game.boardConfiguration;
		mBoardArrangment = game.boardArrangment;
		// calc prefered tiles in width and height
		int singleMargin = getResources().getDimensionPixelSize(R.dimen.card_margin);
		float density = getResources().getDisplayMetrics().density;
		singleMargin = Math.max((int) (1 * density), (int) (singleMargin - mBoardConfiguration.difficulty * 2 * density));
		int sumMargin = 0;
		for (int row = 0; row < mBoardConfiguration.numRows; row++) {
			sumMargin += singleMargin * 2;
		}
		int tilesHeight = (mScreenHeight - sumMargin) / mBoardConfiguration.numRows;
		int tilesWidth = (mScreenWidth - sumMargin) / mBoardConfiguration.numTilesInRow;
		mSize = Math.min(tilesHeight, tilesWidth);

		mTileLayoutParams = new LayoutParams(mSize, mSize);
		mTileLayoutParams.setMargins(singleMargin, singleMargin, singleMargin, singleMargin);

		// build the ui
		buildBoard();
	}


	private void buildBoard() {

		for (int row = 0; row < mBoardConfiguration.numRows; row++) {
			// add row
			addBoardRow(row);
		}

		setClipChildren(false);
	}

	private void addBoardRow(int rowNum) {

		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setGravity(Gravity.CENTER);

		for (int tile = 0; tile < mBoardConfiguration.numTilesInRow; tile++) {
			addTile(rowNum * mBoardConfiguration.numTilesInRow + tile, linearLayout);
		}

		// add to this view
		addView(linearLayout, mRowLayoutParams);
		linearLayout.setClipChildren(false);
	}

	private void addTile(final int id, ViewGroup parent) {
		final PhotoView tileView = PhotoView.fromXml(getContext(), parent);
		tileView.setLayoutParams(mTileLayoutParams);
		parent.addView(tileView);
		parent.setClipChildren(false);
		mViewReference.put(id, tileView);

		new AsyncTask<Void, Void, Bitmap>() {

			@Override
			protected Bitmap doInBackground(Void... params) {
				return mBoardArrangment.getTileBitmap(id, mSize);
			}

			@Override
			protected void onPostExecute(Bitmap result) {
				tileView.setTileImage(result);
			}
		}.execute();

		tileView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!mLocked && tileView.isFlippedDown()) {
					tileView.flipUp();
					flippedUp.add(id);
					if (flippedUp.size() == 2) {
						mLocked = true;
					}
					Shared.eventBus.notify(new FlipCardEvent(id));
				}
			}
		});

		ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(tileView, "scaleX", 0.8f, 1f);
		scaleXAnimator.setInterpolator(new BounceInterpolator());
		ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(tileView, "scaleY", 0.8f, 1f);
		scaleYAnimator.setInterpolator(new BounceInterpolator());
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
		animatorSet.setDuration(500);
		tileView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		animatorSet.start();
	}

	public void flipDownAll() {
		for (Integer id : flippedUp) {
			mViewReference.get(id).flipDown();
		}
		flippedUp.clear();
		mLocked = false;
	}

	public void hideCards(int id1, int id2) {
		animateHide(mViewReference.get(id1));
		animateHide(mViewReference.get(id2));
		flippedUp.clear();
		mLocked = false;
	}

	protected void animateHide(final PhotoView v) {
		ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 0f);
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				v.setLayerType(View.LAYER_TYPE_NONE, null);
				v.setVisibility(View.INVISIBLE);
			}
		});
		animator.setDuration(100);
		v.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		animator.start();
	}

}
