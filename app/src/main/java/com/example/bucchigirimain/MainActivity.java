package com.example.bucchigirimain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlexboxLayout flex=findViewById(R.id.flex);
        String path="/data/data/com.example.bucchigirimain/nsc.db";
        ArrayList<String> iconlist=new ArrayList(10);
        CardMaker cm= new CardMaker(this,flex);
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        Cursor resultSet = db.query("carddetails", new String[]{"card_image"},null,null,null,null,"cardno");
        resultSet.moveToFirst();
        String image = resultSet.getString(0);  //gets image file's name
        iconlist.add("i"+resultSet.getString(0));
        while(resultSet.moveToNext()){
            iconlist.add("i"+resultSet.getString(0));
        }       //adds the image names to a arraylist
        for(int i=0;i<iconlist.size();i++){
            System.out.println(iconlist.get(i)+i);
            Card card= new Card(this,i+1,iconlist.get(i));
            flex.addView(card);
        }
        System.out.println(iconlist.get(1));
        db.close();
    }
}