package com.example.a3_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    ListView listView;
    List date;
    ArrayAdapter<String> listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.date = new ArrayList<>();
        this.listView=findViewById(R.id.listView);
        this.btn1=findViewById(R.id.btn1);

        listadapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, date);
        listView.setAdapter(listadapter);

        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                String currentDate = sdf.format(new Date());
                listadapter.add(currentDate);
            }
    });
    }

}
