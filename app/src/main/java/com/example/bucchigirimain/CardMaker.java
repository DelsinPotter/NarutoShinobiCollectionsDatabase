package com.example.bucchigirimain;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.google.android.flexbox.FlexboxLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardMaker  {
    Context context;
    String path="/data/data/com.example.bucchigirimain/nsc.db";
    FlexboxLayout fl;
    public CardMaker(Context c,FlexboxLayout flex) {
        context=c;
        this.fl=flex;
        makeDatabase();



    }
    public void makeDatabase() {
        SQLiteDatabase sqldb=SQLiteDatabase.openOrCreateDatabase(path,null);
        try {
           InputStream is =context.getAssets().open("nsc.db");
            String outputfile=path;
            OutputStream mOutput = new FileOutputStream(outputfile);
            byte[] mBuffer = new byte[2024];
            int mLength;
            while ((mLength = is.read(mBuffer)) > 0) {
                mOutput.write(mBuffer, 0, mLength);
            }
            mOutput.flush();
            mOutput.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
