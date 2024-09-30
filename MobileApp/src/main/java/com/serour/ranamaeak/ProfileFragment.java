package com.serour.ranamaeak;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.serour.ranamaeak.Utils.SharedPreferencesManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String tok, token;
    private EditText phone, email, locjob;
    private Button edit;
    ProgressDialog pDialog;
    private final static int SOCKET_TIMEOUT_MS = 180000;
    public ProfileFragment() {
    }


    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(
                R.layout.fragment_profile, container, false);
        info();
        token = SharedPreferencesManager.getSharedPreference(getContext(), tok);
        phone = rootView.findViewById(R.id.phone);
        email = rootView.findViewById(R.id.email);
        locjob = rootView.findViewById(R.id.locjob);
        edit = rootView.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
                Matcher m = p.matcher(email.getText().toString());
                if (email.getText().toString().equals("") || phone.getText().toString().equals("")
                        || locjob.getText().toString().equals("")) {
                    if (email.getText().toString().equals("")) {
                        email.setError("يرجى كتابة البريد الإلكتروني");
                    }
                    if (locjob.getText().toString().equals("")) {
                        locjob.setError("يرجى كتابة مكان العمل");
                    }
                    if (phone.getText().toString().equals("")) {
                        phone.setError("يرجى كتابة رقم الهاتف");
                    }
                }
                    if (!m.find()) {
                       email.setError("أعد كتابة البريد الإلكتروني");
                    }
                RequestQueue queue = Volley.newRequestQueue(getContext());
                StringRequest request = new StringRequest(
                        Request.Method.POST,
                        "http://192.168.44.174:8000/api/update",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pDialog.dismiss();
                                try {
                                    JSONObject res = new JSONObject(response);
                                    String result = res.getString("result");
                                    Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "لا يمكن الإتصال بالشبكة!", Toast.LENGTH_SHORT).show();
                    }}) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        String em = email.getText().toString();
                        String nbr = phone.getText().toString();
                        String loc = locjob.getText().toString();

                        params.put("email", em);
                        params.put("numTel", nbr);
                        params.put("lieuTravail", loc);

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("token", token);
                        return params;
                    }

                };
                queue.add(request);
            }

        });
        return rootView;
    }
    public void info() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.44.174:8000/api/get_parent_info",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject res = new JSONObject(response);
                            String a = res.getString("email");
                            email.setText(a);
                            String b = res.getString("name");
                            phone.setText(b);
                            String c = res.getString("phone");
                            locjob.setText(c);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getContext(), "لا يمكن الإتصال بالشبكة!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("token", token);
                return params;
            }
        };
        queue.add(request);


    }

}