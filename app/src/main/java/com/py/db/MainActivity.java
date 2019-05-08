package com.py.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText name;
    public Button button;
    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.name);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabseAccess databseAccess = DatabseAccess.getInstance(getApplicationContext());
                databseAccess.open();


                String n = name.getText().toString();
                String address = databseAccess.getAddress(n);

                result.setText(address);

                databseAccess.close();
            }
        });


    }
}
