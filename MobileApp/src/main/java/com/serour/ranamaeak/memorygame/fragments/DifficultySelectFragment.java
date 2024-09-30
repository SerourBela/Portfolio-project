package com.serour.ranamaeak.memorygame.fragments;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.serour.ranamaeak.R;
import com.serour.ranamaeak.memorygame.common.Shared;
import com.serour.ranamaeak.memorygame.events.ui.DifficultySelectedEvent;

public class DifficultySelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(Shared.context).inflate(R.layout.difficulty_select_fragment, container, false);

        Button difficulty1 = view.findViewById(R.id.select_difficulty_1);
        setOnClick(difficulty1, 1);

        Button difficulty2 = view.findViewById(R.id.select_difficulty_2);
        setOnClick(difficulty2, 2);

        Button difficulty3 =  view.findViewById(R.id.select_difficulty_3);
        setOnClick(difficulty3, 3);


        animate(difficulty1, difficulty2, difficulty3);
        return view;

    }

    private void animate(View... view) {
        AnimatorSet animatorSet = new AnimatorSet();
        Builder builder = animatorSet.play(new AnimatorSet());
        for (int i = 0; i < view.length; i++) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view[i], "scaleX", 0.8f, 1f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view[i], "scaleY", 0.8f, 1f);
            builder.with(scaleX).with(scaleY);
        }
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.start();
    }

    private void setOnClick(View view, final int difficulty) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared.eventBus.notify(new DifficultySelectedEvent(difficulty));
            }
        });
    }


}
