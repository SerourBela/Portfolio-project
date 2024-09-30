package com.serour.ranamaeak.memorygame.utils;

public class Clock {
	private static PauseTimer mPauseTimer = null;
	private static Clock mInstance = null;

	private Clock()
	{
	}

	public static class PauseTimer extends CountDownClock {
		private OnTimerCount mOnTimerCount = null;

		public PauseTimer(long millisOnTimer, long countDownInterval, boolean runAtStart, OnTimerCount onTimerCount) {
			super(millisOnTimer, countDownInterval, runAtStart);
			mOnTimerCount = onTimerCount;
		}

		@Override
		public void onTick(long millisUntilFinished) {
			if (mOnTimerCount != null) {
				mOnTimerCount.onTick(millisUntilFinished);
			}
		}

		@Override
		public void onFinish() {
			if (mOnTimerCount != null) {
				mOnTimerCount.onFinish();
			}
		}

	}

	public static Clock getInstance() {
		if (mInstance == null) {
			mInstance = new Clock();
		}
		return mInstance;
	}

	public void startTimer(long millisOnTimer, long countDownInterval, OnTimerCount onTimerCount) {
		if (mPauseTimer != null) {
			mPauseTimer.cancel();
		}
		mPauseTimer = new PauseTimer(millisOnTimer, countDownInterval, true, onTimerCount);
		mPauseTimer.create();
	}

	public void pause() {
		if (mPauseTimer != null) {
			mPauseTimer.pause();
		}
	}

	public void resume() {
		if (mPauseTimer != null) {
			mPauseTimer.resume();
		}
	}


	public long getPassedTime() {
		return mPauseTimer.timePassed();
	}

	public interface OnTimerCount {
		public void onTick(long millisUntilFinished);

		public void onFinish();
	}

}
