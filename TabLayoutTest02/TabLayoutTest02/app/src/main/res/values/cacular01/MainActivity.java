package com.example.cacular01;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cacular01.tools.unitchanger.Length;
import com.example.cacular01.tools.unitchanger.Unit;

public class MainActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    private EditText inputnumberunit;
    private ImageView change;
    private Spinner spinnerNow;
    private Spinner spinnerTarget;
    private TextView showMeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout01);

        toolbar = (Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar!=null)
//        {
//            actionBar.hide();
//        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        inputnumberunit = findViewById(R.id.inputnumberunit);
        spinnerNow = findViewById(R.id.spinnerNow);
        spinnerTarget = findViewById(R.id.spinnerTarget);
        showMeResult = findViewById(R.id.showMeResult);

        change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = inputnumberunit.getText().toString();
                String now = spinnerNow.getSelectedItem().toString();
                String target = spinnerTarget.getSelectedItem().toString();

                Unit unit = Length.getLengthMap().get(now);
                String result = unit.Transforming(str,now,target);
                showMeResult.setText(result);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar01,menu);
        return true;
    }
}