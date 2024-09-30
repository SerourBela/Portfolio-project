package com.serour.ranamaeak.memorygame.engine;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ImageView;

import com.serour.ranamaeak.R;
import com.serour.ranamaeak.memorygame.common.Music;
import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.events.EventObserverAdapter;
import com.serour.ranamaeak.memorygame.events.engine.FlipDownCardsEvent;
import com.serour.ranamaeak.memorygame.events.engine.GameWonEvent;
import com.serour.ranamaeak.memorygame.events.engine.HidePairCardsEvent;
import com.serour.ranamaeak.memorygame.events.ui.BackGameEvent;
import com.serour.ranamaeak.memorygame.events.ui.DifficultySelectedEvent;
import com.serour.ranamaeak.memorygame.events.ui.FlipCardEvent;
import com.serour.ranamaeak.memorygame.events.ui.NextGameEvent;
import com.serour.ranamaeak.memorygame.events.ui.ResetBackgroundEvent;
import com.serour.ranamaeak.memorygame.events.ui.StartEvent;
import com.serour.ranamaeak.memorygame.events.ui.ThemeSelectedEvent;
import com.serour.ranamaeak.memorygame.model.BoardArrangment;
import com.serour.ranamaeak.memorygame.model.BoardConfiguration;
import com.serour.ranamaeak.memorygame.model.Game;
import com.serour.ranamaeak.memorygame.model.GameState;
import com.serour.ranamaeak.memorygame.themes.Theme;
import com.serour.ranamaeak.memorygame.themes.Themes;
import com.serour.ranamaeak.memorygame.ui.PopupManager;
import com.serour.ranamaeak.memorygame.utils.Clock;
import com.serour.ranamaeak.memorygame.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Engine extends EventObserverAdapter {

	private static Engine mInstance = null;
	private Game mPlayingGame = null;
	private int mFlippedId = -1;
	private int mToFlip = -1;
	private ScreenController mScreenController;
	private Theme mSelectedTheme;
	private ImageView mBackgroundImage;
	private Handler mHandler;

	private Engine() {
		mScreenController = ScreenController.getInstance();
		mHandler = new Handler();
	}

	public static Engine getInstance() {
		if (mInstance == null) {
			mInstance = new Engine();
		}
		return mInstance;
	}

	public void start() {
		Shared.eventBus.listen(DifficultySelectedEvent.TYPE, this);
		Shared.eventBus.listen(FlipCardEvent.TYPE, this);
		Shared.eventBus.listen(StartEvent.TYPE, this);
		Shared.eventBus.listen(ThemeSelectedEvent.TYPE, this);
		Shared.eventBus.listen(BackGameEvent.TYPE, this);
		Shared.eventBus.listen(NextGameEvent.TYPE, this);
		Shared.eventBus.listen(ResetBackgroundEvent.TYPE, this);
	}



	@Override
	public void onEvent(ResetBackgroundEvent event) {
		Drawable drawable = mBackgroundImage.getDrawable();
		if (drawable != null) {
			((TransitionDrawable) drawable).reverseTransition(2000);
		} else {
			new AsyncTask<Void, Void, Bitmap>() {

				@Override
				protected Bitmap doInBackground(Void... params) {
					Bitmap bitmap = Utils.scaleDown(R.drawable.background);
					return bitmap;
				}

				protected void onPostExecute(Bitmap bitmap) {
					mBackgroundImage.setImageBitmap(bitmap);
				};

			}.execute();
		}
	}

	@Override
	public void onEvent(StartEvent event) {
		mScreenController.openScreen(ScreenController.Screen.THEME_SELECT);
	}

	@Override
	public void onEvent(NextGameEvent event) {
		PopupManager.closePopup();
		int difficulty = mPlayingGame.boardConfiguration.difficulty;
		if (mPlayingGame.gameState.achievedStars == 3 && difficulty < 6) {
			difficulty++;
		}
		Shared.eventBus.notify(new DifficultySelectedEvent(difficulty));
	}

	@Override
	public void onEvent(BackGameEvent event) {
		PopupManager.closePopup();
		mScreenController.openScreen(ScreenController.Screen.DIFFICULTY);
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		mSelectedTheme = event.theme;
		mScreenController.openScreen(ScreenController.Screen.DIFFICULTY);
		AsyncTask<Void, Void, TransitionDrawable> task = new AsyncTask<Void, Void, TransitionDrawable>() {

			@Override
			protected TransitionDrawable doInBackground(Void... params) {
				Bitmap bitmap = Utils.scaleDown(R.drawable.background);
				Bitmap backgroundImage = Themes.getBackgroundImage(mSelectedTheme);
				Drawable backgrounds[] = new Drawable[2];
				backgrounds[0] = new BitmapDrawable(Shared.context.getResources(), bitmap);
				backgrounds[1] = new BitmapDrawable(Shared.context.getResources(), backgroundImage);
				TransitionDrawable crossfader = new TransitionDrawable(backgrounds);
				return crossfader;
			}

			@Override
			protected void onPostExecute(TransitionDrawable result) {
				super.onPostExecute(result);
				mBackgroundImage.setImageDrawable(result);
				result.startTransition(2000);
			}
		};
		task.execute();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		mFlippedId = -1;
		mPlayingGame = new Game();
		mPlayingGame.boardConfiguration = new BoardConfiguration(event.difficulty);
		mPlayingGame.theme = mSelectedTheme;
		mToFlip = mPlayingGame.boardConfiguration.numTiles;

		// arrange board
		arrangeBoard();

		// start the screen
		mScreenController.openScreen(ScreenController.Screen.GAME);
	}

	private void arrangeBoard() {
		BoardConfiguration boardConfiguration = mPlayingGame.boardConfiguration;
		BoardArrangment boardArrangment = new BoardArrangment();

		// build pairs
		// result {0,1,2,...n} // n-number of tiles
		List<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < boardConfiguration.numTiles; i++) {
			ids.add(i);
		}
		// shuffle
		// result {4,10,2,39,...}
		Collections.shuffle(ids);

		// place the board
		List<String> tileImageUrls = mPlayingGame.theme.tileImageUrls;
		Collections.shuffle(tileImageUrls);
		boardArrangment.pairs = new HashMap<>();
		boardArrangment.tileUrls = new HashMap<>();
		int j = 0;
		for (int i = 0; i < ids.size(); i++) {
			if (i + 1 < ids.size()) {
				// {4,10}, {2,39}, ...
				boardArrangment.pairs.put(ids.get(i), ids.get(i + 1));
				// {10,4}, {39,2}, ...
				boardArrangment.pairs.put(ids.get(i + 1), ids.get(i));
				// {4,
				boardArrangment.tileUrls.put(ids.get(i), tileImageUrls.get(j));
				boardArrangment.tileUrls.put(ids.get(i + 1), tileImageUrls.get(j));
				i++;
				j++;
			}
		}

		mPlayingGame.boardArrangment = boardArrangment;
	}

	@Override
	public void onEvent(FlipCardEvent event) {
		int id = event.id;
		if (mFlippedId == -1) {
			mFlippedId = id;
		} else {
			if (mPlayingGame.boardArrangment.isPair(mFlippedId, id)) {
				Shared.eventBus.notify(new HidePairCardsEvent(mFlippedId, id), 1000);
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						Music.playCorrent();
					}
				}, 1000);
				mToFlip -= 2;
				if (mToFlip == 0) {
					int passedSeconds = (int) (Clock.getInstance().getPassedTime() / 1000);
					Clock.getInstance().pause();
					int totalTime = mPlayingGame.boardConfiguration.time;
					GameState gameState = new GameState();
					mPlayingGame.gameState = gameState;
					// remained seconds
					gameState.remainedSeconds = totalTime - passedSeconds;
					gameState.passedSeconds = passedSeconds;

					// calc stars
					if (passedSeconds <= totalTime / 2) {
						gameState.achievedStars = 3;
					} else if (passedSeconds <= totalTime - totalTime / 5) {
						gameState.achievedStars = 2;
					} else if (passedSeconds < totalTime) {
						gameState.achievedStars = 1;
					} else {
						gameState.achievedStars = 0;
					}

					// calc score
					gameState.achievedScore = mPlayingGame.boardConfiguration.difficulty * gameState.remainedSeconds * mPlayingGame.theme.id;

					Shared.eventBus.notify(new GameWonEvent(gameState), 1200);
				}
			} else {
				// send event - flip all down
				Shared.eventBus.notify(new FlipDownCardsEvent(), 1000);
			}
			mFlippedId = -1;
		}
	}

	public Game getActiveGame() {
		return mPlayingGame;
	}


	public void setBackgroundImageView(ImageView backgroundImage) {
		mBackgroundImage = backgroundImage;
	}
}
