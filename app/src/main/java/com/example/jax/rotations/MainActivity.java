package com.example.jax.rotations;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mMainLayout;
    private EditText mMessageField;
    private ArrayList<String> mMessages= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainLayout = (LinearLayout) findViewById(R.id.ll);
        mMessageField = (EditText) findViewById(R.id.et);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mMessages = savedInstanceState.getStringArrayList("messages");
        try {
            for(String message:mMessages){
                addMessage(message);
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("messages",mMessages);
    }

    public void addMessageButton(View clickedButton){
        String message = mMessageField.getText().toString();
        if(!message.isEmpty()){
            mMessages.add(message);
            addMessage(message);
        }
    }
    // hiển thị message
    private void addMessage(String message){
        TextView textV= new TextView(this);
        textV.setText(message);
        mMainLayout.addView(textV);
    }
}
