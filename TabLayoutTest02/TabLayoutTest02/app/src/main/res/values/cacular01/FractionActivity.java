package com.example.cacular01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cacular01.tools.unitchanger.fraction.FrationDealer;

public class FractionActivity extends AppCompatActivity {
    private EditText inputy1;
    private EditText inputy2;
    private TextView result;
    private EditText inputtf1n;
     private EditText inputtf1d;
    private EditText inputtf2n;
    private EditText inputtf2d;
    private EditText inputjf1n;
    private EditText inputjf1d;
    private EditText inputjf2n;
    private EditText inputjf2d;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction);
    initView();
    }
    public void initView()
    {
        inputy1 = findViewById(R.id.f1numerior);
        inputy2 = findViewById(R.id.f1dnumeroir);
    }

    public void reduce(View view) {
        String s = inputy1.getText().toString();
        String s1 = inputy2.getText().toString();
        String s2 = FrationDealer.FrationOper(s, s1);
        inputy2.setText(s2);
    }
}