package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list=findViewById(R.id.listview);
        String[] item=new String[]{"Recent","Offline","Bin","Settings","Backups","Help and Feedback"};
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,item);
        list.setAdapter(myAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public  void  onItemClick(AdapterView<?> parent,View view,int position,long id) {
                String item_name=item[position];
                Toast.makeText(MainActivity.this,item_name, Toast.LENGTH_SHORT).show();
            }

        });
    }
}