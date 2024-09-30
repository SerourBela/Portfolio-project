package com.serour.ranamaeak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.serour.ranamaeak.model.notifications;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotificationFragment extends Fragment {

    private List<notifications> notificationList = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_notification, container, false);
        fillDummyList();
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        NotificationAdapter nAdapter = new NotificationAdapter(notificationList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(nAdapter);
        return rootView;

    }

    private void fillDummyList() {
        notificationList = new ArrayList<>();
        Date today = Calendar.getInstance().getTime();
        notificationList.add(new notifications(1, today, 1,"حصة جديدة: إطلع على مستجدات تطور حالة طفلك و إتبع النصائح المقدمة"));
        notificationList.add(new notifications(2, today, 1, "نتيجة التشخيص: أعراض متوسطة من اضطراب طيف التوحد"));
    }
}
