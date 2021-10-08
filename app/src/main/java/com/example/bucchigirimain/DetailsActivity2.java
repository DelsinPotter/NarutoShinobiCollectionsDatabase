package com.example.bucchigirimain;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        Bundle id=getIntent().getExtras();
        int cardid= (int) id.get("cardid");
        TextView name=findViewById(R.id.textView);
        TextView s1name=findViewById(R.id.textView2);
        TextView s1=findViewById(R.id.textView4);
        s1.setMovementMethod(new ScrollingMovementMethod());
        TextView s2name=findViewById(R.id.textView3);
        TextView s2=findViewById(R.id.textView5);
        s2.setMovementMethod(new ScrollingMovementMethod());
        String dbpath="/data/data/com.example.bucchigirimain/nsc.db";
        SQLiteDatabase db = SQLiteDatabase.openDatabase(dbpath,null,SQLiteDatabase.OPEN_READWRITE);
        //Cursor resultSet = db.query("carddetails", new String[]{"card_image"},null,null,null,null,"cardno");
        Cursor resultset=db.rawQuery("select * from carddetails where cardno="+cardid,null);
        resultset.moveToFirst();
        name.setText(resultset.getString(1));
        String image=resultset.getString(2);
        ImageView cardimage=findViewById(R.id.imageView);
        cardimage.setImageResource(getResources().getIdentifier(image,"drawable",getPackageName()));
        s1name.setText(resultset.getString(3));
        s1.setText(resultset.getString(4));
        s2name.setText(resultset.getString(5));
        s2.setText(resultset.getString(6));

    }
}