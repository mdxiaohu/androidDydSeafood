package com.example.dhy203dydhx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    private ImageButton btn_khgl01;
    private ImageButton btn_gysgl01;
    private ImageButton btn_sprk01;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment1,container,false);

        ImageButton btn_khgl01  = (ImageButton) view.findViewById(R.id.bt_khgl0);
        ImageButton btn_gysgl01  = (ImageButton) view.findViewById(R.id.bt_gysgl0);
        ImageButton btn_sprk01  = (ImageButton) view.findViewById(R.id.bt_ddrk0);


        btn_khgl01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),gkgl.class);
                startActivity(intent);
            }
        });

        btn_gysgl01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),gysgl.class);
                startActivity(intent);
            }
        });
        btn_sprk01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),sprk.class);
                startActivity(intent);
            }
        });
        return view;//这里返回的是上面加载的view

    }

    @Override
    public void onStart() {
        LinearLayout linearLayout = getView().findViewById(R.id.textOne);

        super.onStart();
    }
}