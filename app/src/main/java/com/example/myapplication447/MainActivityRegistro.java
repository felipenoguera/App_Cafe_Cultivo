package com.example.myapplication447;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;

        import com.android.volley.AuthFailureError;
        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import java.net.URI;
        import java.util.HashMap;
        import java.util.Map;

public class MainActivityRegistro extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPassword, etEmail, etPhone;
    Button btnCreate;
    RequestQueue requestQueue;
    private static final String URL1 = "http://192.168.1.9/crud/save.php";
    private ImageView bnt_link;
    String _url="https://www.google.com/";
    private ImageView bnt_Link_Twit;



    @Override

    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_main_registro);


        bnt_link = findViewById(R.id.bnt_link);
        bnt_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);

            }

        });



        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();
        btnCreate.setOnClickListener(this);

    }



    private void initUI() {
        //editext
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        //buttons
        btnCreate = findViewById(R.id.btnCreate);

    }

    @Override

    public void onClick(View v) {
        int id = v.getId();


        if (id == R.id.btnCreate) {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            createuser(name,email,password,phone);
        }

    }

    private void createuser(final String name,final String email,final String password,final String phone) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivityRegistro.this, "El Usuario Se Agrego Correctamente", Toast.LENGTH_SHORT).show();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("password",password);
                params.put("phone",phone);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}