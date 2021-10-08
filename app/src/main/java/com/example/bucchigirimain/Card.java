package com.example.bucchigirimain;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class Card extends androidx.appcompat.widget.AppCompatImageView {
    int cardid;
    public Card(Context context,int id,String icon) {
        super(context);
        this.cardid=id;
        Intent i=new Intent(context,DetailsActivity2.class);
        i.putExtra("cardid",cardid);
        this.setImageResource(getResources().getIdentifier(icon,"drawable","com.example.bucchigirimain"));
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(i);
            }
        });
    }
}
