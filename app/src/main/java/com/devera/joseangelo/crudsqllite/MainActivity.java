package com.devera.joseangelo.crudsqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eLname;
    EditText eFname;
    EditText ePoint;
    DBHelper helper;
    Cursor res;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         eLname = findViewById(R.id.etLname);
         eFname = findViewById(R.id.etFname);
         ePoint = findViewById(R.id.etPoint);
         helper = new DBHelper(this);
        res = helper.getRecords();
    }

    public void insertValue(View v){

        String lname = eLname.getText().toString();
        String fname = eFname.getText().toString();
        int point = Integer.parseInt(ePoint.getText().toString());
        Boolean bool = helper.insert(fname,lname,point);
        if(bool){
            Toast.makeText(this,"Record inserted successfully",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Record failed",Toast.LENGTH_LONG).show();
        }



    }

    public void updateValue(View v){
        String lname = eLname.getText().toString();
        String fname = eFname.getText().toString();
        int point = Integer.parseInt(ePoint.getText().toString());
        int position = res.getPosition();
        Boolean bool = helper.update((position+1)+"" ,fname,lname,point);
        if(bool){
            Toast.makeText(this,"Record updated successfully",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Record failed",Toast.LENGTH_LONG).show();
        }

        res = helper.getRecords();
        res.moveToPosition(position);

    }

    public void moveFirst(View v){
        res.moveToFirst();
        String fname = res.getString(1);
        String lname = res.getString(2);
        String point = res.getString(3);
        eLname.setText(lname);
        eFname.setText(fname);
        ePoint.setText(point);

        Toast.makeText(this,res.getPosition()+"",Toast.LENGTH_SHORT).show();

    }
    public void moveLast(View v){
        res.moveToLast();
        String fname = res.getString(1);
        String lname = res.getString(2);
        String point = res.getString(3);
        eLname.setText(lname);
        eFname.setText(fname);
        ePoint.setText(point);

        Toast.makeText(this,res.getPosition()+"",Toast.LENGTH_SHORT).show();

    }

    public void moveNext(View v){
        res.moveToNext();
        String fname = res.getString(1);
        String lname = res.getString(2);
        String point = res.getString(3);
        eLname.setText(lname);
        eFname.setText(fname);
        ePoint.setText(point);

        Toast.makeText(this,res.getPosition()+"",Toast.LENGTH_SHORT).show();

    }
    public void movePrevious(View v){
        res.moveToPrevious();
        String fname = res.getString(1);
        String lname = res.getString(2);
        String point = res.getString(3);
        eLname.setText(lname);
        eFname.setText(fname);
        ePoint.setText(point);

        Toast.makeText(this,res.getPosition()+"",Toast.LENGTH_SHORT).show();

    }


}
