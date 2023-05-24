package com.example.myapplication447;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivityBuscar extends AppCompatActivity implements View.OnClickListener{

    Button btnFetch;
    EditText etId;

    RequestQueue requestQueue;
    private static final String URL1 = "http://192.168.1.9/crud/save.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar);
        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();

        btnFetch.setOnClickListener(this);
    }
    private void initUI() {
        //editext
        etId = findViewById(R.id.etId);
        //Buttons
        btnFetch =findViewById(R.id.btnFetch);
    }
    @Override

    public void  onClick(View V) {
        int id = V.getId();

        if (id ==R.id.btnFetch) {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("id", etId.getText().toString().trim());
            startActivity(intent);
            Toast.makeText(MainActivityBuscar.this, "Buscando Usuario", Toast.LENGTH_SHORT).show();

        }

    }
}











