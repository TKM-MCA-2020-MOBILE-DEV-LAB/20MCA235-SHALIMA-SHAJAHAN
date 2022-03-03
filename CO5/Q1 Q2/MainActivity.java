package com.example.sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,contact,dob;
    Button insert,update,delete,view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextTextPersonName2);
        contact=findViewById(R.id.editTextTextPersonName2);
        dob=findViewById(R.id.editTextTextPersonName3);
        insert=findViewById(R.id.button);
        update=findViewById(R.id.button2);
        delete=findViewById(R.id.button3);
        view=findViewById(R.id.button4);
        DB=new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String dobTXT=dob.getText().toString();

                Boolean checkinsertdata =DB.insertuserdata(nameTXT,contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this,"new data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"new data not inserted",Toast.LENGTH_LONG).show();
            }
        });



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String dobTXT=dob.getText().toString();

                Boolean checkupdatedata =DB.updateuserdata(nameTXT,contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this," data updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this," data not updated",Toast.LENGTH_LONG).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();

                Boolean checkdeletedata =DB.deleteuserdata(nameTXT,null,null);
                if(checkdeletedata==true)
                    Toast.makeText(MainActivity.this," data deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"data not deleted",Toast.LENGTH_LONG).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "NO ENTRY EXISTS", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name:"+res.getString(0)+"\n");
                    buffer.append("Contact:"+res.getString(1)+"\n");
                    buffer.append("DOB:"+res.getString(2)+"\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("User Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}