package com.example.tablayouttest02;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tablayouttest02.unitchanger.Area;
import com.example.tablayouttest02.unitchanger.ScientistDemo;
import com.example.tablayouttest02.unitchanger.Unit;
import com.example.tablayouttest02.unitchanger.fraction.FrationDealer;

public class TabFragment_fraction extends Fragment {
    private EditText inputnumberunit1;
    private EditText inputnumberunit2;
    private EditText inputnumberunit3;
    private EditText inputnumberunit4;
    private Spinner spinner;
    private Button button;
//    private ImageView change;
//    private Spinner spinnerNow;
//    private Spinner spinnerTarget;
    private TextView showMeResult;

    public static TabFragment_fraction newInstance() {
        TabFragment_fraction fragment = new TabFragment_fraction();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_fraction, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        inputnumberunit1 = getView().findViewById(R.id.inputnumberunit1);
        inputnumberunit2 = getView().findViewById(R.id.inputnumberunit2);
        inputnumberunit3 = getView().findViewById(R.id.inputnumberunit3);
        inputnumberunit4 = getView().findViewById(R.id.inputnumberunit4);
        spinner = getView().findViewById(R.id.spinner);
        button = getView().findViewById(R.id.button);
        showMeResult = getView().findViewById(R.id.showMeResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = inputnumberunit1.getText().toString();
                String str2 = inputnumberunit2.getText().toString();
                String str3 = inputnumberunit3.getText().toString();
                String str4 = inputnumberunit4.getText().toString();
                String sign = spinner.getSelectedItem().toString();
                if(TextUtils.isEmpty(str1)|| TextUtils.isEmpty(str2)||TextUtils.isEmpty(str3)||TextUtils.isEmpty(str4))
                {
                    Toast.makeText(v.getContext(),"输入不可以有空哦",Toast.LENGTH_SHORT).show();
                }else{
                    String result = FrationDealer.FractionOper(str1,str2,str3,str4,sign);
//                    result = ScientistDemo.StandardScienceDig(result,1);
                    showMeResult.setText(result);

                }
            }
        });




//        spinnerNow = getView().findViewById(R.id.spinnerNow);
//        spinnerTarget = getView().findViewById(R.id.spinnerTarget);
//        showMeResult = getView().findViewById(R.id.showMeResult);
//        change = getView().findViewById(R.id.change);
//        change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str = inputnumberunit.getText().toString();
//                String now = spinnerNow.getSelectedItem().toString();
//                String target = spinnerTarget.getSelectedItem().toString();
//
//                if(TextUtils.isEmpty(str))
//                {
//                    Toast.makeText(v.getContext(),"输入不能为空哦!",Toast.LENGTH_SHORT).show();
//                }else{
//                    Unit unit = Area.getAreaMap().get(now);
//                    String result = unit.Transforming(str,now,target);
//                    result = ScientistDemo.StandardScienceDig(result,1);
//                    showMeResult.setText(result);
//                }
//            }
//        });
    }
}
