package com.serour.ranamaeak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.serour.ranamaeak.Utils.SharedPreferencesManager;

public class NoteFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText remarque;
    private Button send;
    int idparent;
    private String tok, token;

    public NoteFragment() {
    }


    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
        // SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        //idparent = Integer.parseInt(prefs.getString("id_parent",""));

        token = SharedPreferencesManager.getSharedPreference(getContext(), tok);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(
                R.layout.fragment_note, container, false);
        remarque = rootView.findViewById(R.id.observation);
        send = rootView.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (remarque.getText().toString().equals("")) {
                    Toast.makeText(rootView.getContext(), "يرجى كتابة الملاحظات", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(rootView.getContext(), "تم الإرسال", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }
}