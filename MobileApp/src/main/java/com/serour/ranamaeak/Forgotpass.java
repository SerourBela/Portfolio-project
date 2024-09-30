package com.serour.ranamaeak;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Forgotpass extends AppCompatActivity {

    private static Animation shakeAnimation;
    ProgressDialog pDialog;
    LinearLayout l;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        email = findViewById(R.id.email);
        l = findViewById(R.id.forgotpass);


    }

    public void Forgot(final View view) {
        int i = 1;
        if (email.getText().toString().equals("")) {
            i = 0;
            email.setError("يرجى إدخال البريد الإلكتروني");
        } else {
            String getEmailId = email.getText().toString();
            if (!isEmailValid(getEmailId)) {
                i = 0;
                email.setError("يرجى إدخال البريد الإلكتروني");
            }
        }
        if (i == 0) {
            shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
            l.setAnimation(shakeAnimation);
            return;
        }
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("يرجى الإنتظار...");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.44.174:8000/forgot",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            pDialog.dismiss();
                            JSONObject res = new JSONObject(response);
                            String result = res.getString("result");


                        } catch (JSONException e) {
                            e.printStackTrace();
                            pDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();
                Toast.makeText(view.getContext(), "لا يمكن الإتصال بالشبكة!", Toast.LENGTH_SHORT).show();
            }

        });
        queue.add(request);

    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}

