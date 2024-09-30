package com.serour.ranamaeak;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.serour.ranamaeak.model.seancetraitements;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<seancetraitements> seanceList = new ArrayList<>();
    private SeanceAdapter sAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<String> commentaries= new ArrayList<>();
    ArrayList<String> conseilsparents= new ArrayList<>();



    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
                R.layout.fragment_home, container, false);
        fillDummyList();
        SearchView searchView = rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // we are doing nothing on pressing the submit button as we have already set the IME action to done
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            // automatically filter the list upon entering text in the search field
            @Override
            public boolean onQueryTextChange(String newText) {
                sAdapter.getFilter().filter(newText);
                return false;
            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        sAdapter = new SeanceAdapter(seanceList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);
        return rootView;

    }

    private void fillDummyList() {
        seanceList = new ArrayList<>();
        dates.add("21/09/2020");
        commentaries.add("تطور مهارات التواصل اللفظي تكوين جملة");
        conseilsparents.add("لا تتذمر عند نطقه للكلمات بطريقة خاطئة بل ساعده على تذكر الكلمات التي تعلمها");
        dates.add("20/09/2020");
        commentaries.add("تطور مهارات التواصل اللفظي اذ تعلم كلمات جديدة");
        conseilsparents.add("ساعد علي على تذكر الكلمات التي تعلمها مثل: (باب، ماء، أبي)و لا تتذمر عند عكسه للحروف");
        dates.add("19/09/2020");
        commentaries.add("ضعف في التواصل غير اللفظي");
        conseilsparents.add("على الأم أن تتواصل مع ابنها حتى و ان لم يستجب لذلك");
        for (int i = 0; i < commentaries.size(); i++) {
            seancetraitements s = new seancetraitements();
            s.setDate(dates.get(i));
            s.setCommentaire(commentaries.get(i));
            s.setConseils(conseilsparents.get(i));
            seanceList.add(s);
        }
    }}
/*            final RequestQueue queue = Volley.newRequestQueue(getContext());
            final StringRequest request = new StringRequest(Request.Method.GET,
                    "http://192.168.43.175:8000/api/getseance",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject res = new JSONObject(response);
                                JSONArray arr = res.getJSONArray("seance");

                                dates = new ArrayList<Date>();
                                commentaries = new ArrayList<String>();
                                conseilsparents = new ArrayList<String>();


                                for(int i=0; i < arr.length() ; i++) {
                                    String date = arr.getJSONObject(i).getString("date");
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date SeanceDate = sdf.parse(date);
                                    String com = arr.getJSONObject(i).getString("commentaire");
                                    String conseils = arr.getJSONObject(i).getString("conseilsparents");

                                    dates.add(SeanceDate);
                                    commentaries.add(com);
                                    conseilsparents.add(conseils);
                                }
                                for (int i = 0; i < commentaries.size(); i++) {
                                    seancetraitements s = new seancetraitements();
                                    s.setDate(dates.get(i));
                                    s.setCommentaire(commentaries.get(i));
                                    s.setConseils(conseilsparents.get(i));
                                    seanceList.add(s);
                                }

                                sAdapter.notifyDataSetChanged();

                            } catch (JSONException | ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(),"لا يمكن الإتصال بالشبكة!", Toast.LENGTH_SHORT).show();

                }
            });

            queue.add(request);
        }
    }*/

