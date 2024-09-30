package com.serour.ranamaeak;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static Animation shakeAnimation;
    String tok;
    LinearLayout l;
    ProgressDialog pDialog;
    private EditText email, password;
    private CheckBox show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        show = findViewById(R.id.show_hide_password);
        l = findViewById(R.id.login_layout);

        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton button,
                                         boolean isChecked) {
                if (isChecked) {

                    show.setText("إخفاء كلمة المرور");
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    password.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                } else {
                    show.setText("إظهار كلمة المرور");
                    // checkbox
                    // text

                    password.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());
                }
            }
        });


        TextView forgot = findViewById(R.id.forgot);

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent u = new Intent(LoginActivity.this, Forgotpass.class);
                startActivity(u);

            }
        });
    }


    public void Login(final View view) {
        int i = 1;

        if (email.getText().toString().equals("") || password.getText().toString().equals("")) {
            i = 0;
            if (email.getText().toString().equals("")) {
                email.setError("يرجى إدخال البريد الإلكتروني");
            }
            if (password.getText().toString().equals("")) {
                password.setError("يرجى إدخال كلمة المرور");
            }

        }
        String getEmailId = email.getText().toString();
        if (!isEmailValid(getEmailId)) {
            i = 0;
            email.setError("يرجى إدخال البريد الإلكتروني");
        }


        if (i == 0) {
            shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
            l.setAnimation(shakeAnimation);
            return;
        } else {

            pDialog = new ProgressDialog(this);
            pDialog.setMessage("تسجيل الدخول...");
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(false);
            pDialog.show();
            Toast.makeText(view.getContext(), "مرحبا", Toast.LENGTH_SHORT).show();
            Intent u = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(u);
            pDialog.dismiss();
        }
    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
       /* RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST,
                "http://192.168.43.175:8000/api/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            pDialog.dismiss();
                            JSONObject res = new JSONObject(response);
                            String result = res.getString("result");
                            if (result.equals("wrong email or password")) {
                                Toast.makeText(view.getContext(), result, Toast.LENGTH_SHORT).show();
                            } else {
                                pDialog.dismiss();
                                SharedPreferencesManager.setSharedPreference(LoginActivity.this, tok, result);
                                Toast.makeText(view.getContext(), "مرحبا", Toast.LENGTH_SHORT).show();
                                Intent u = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(u);
                            }

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
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                String em = email.getText().toString();
                String pass = password.getText().toString();
                params.put("email", em);
                params.put("password", pass);
                return params;
            }

        };
        queue.add(request);

    }
*/




