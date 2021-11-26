package com.example.tablayouttest02;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tablayouttest02.unitchanger.Length;
import com.example.tablayouttest02.unitchanger.ScientistDemo;
import com.example.tablayouttest02.unitchanger.Unit;

public class TabFragment_length extends Fragment {

    private EditText inputnumberunit;
    private ImageView change;
    private Spinner spinnerNow;
    private Spinner spinnerTarget;
    private TextView showMeResult;

    public static TabFragment_length newInstance() {
        TabFragment_length fragment = new TabFragment_length();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_length, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        inputnumberunit = getView().findViewById(R.id.inputnumberunit);
        spinnerNow = getView().findViewById(R.id.spinnerNow);
        spinnerTarget = getView().findViewById(R.id.spinnerTarget);
        showMeResult = getView().findViewById(R.id.showMeResult);
        change = getView().findViewById(R.id.change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = inputnumberunit.getText().toString();
                String now = spinnerNow.getSelectedItem().toString();
                String target = spinnerTarget.getSelectedItem().toString();

                if(TextUtils.isEmpty(str))
                {
                    Toast.makeText(v.getContext(),"输入不能为空哦!",Toast.LENGTH_SHORT).show();
                }else{
                    Unit unit = Length.getLengthMap().get(now);
                    String result = unit.Transforming(str,now,target);
                    result = ScientistDemo.StandardScienceDig(result,1);
                    showMeResult.setText(result);
                }


            }
        });
    }
}
