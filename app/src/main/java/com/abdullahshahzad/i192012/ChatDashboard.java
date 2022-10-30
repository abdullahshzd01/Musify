package com.abdullahshahzad.i192012;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ChatDashboard extends Activity {
    RecyclerView contacts_rv, chats_rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_dashboard);

        contacts_rv=findViewById(R.id.contacts_rv);
        chats_rv=findViewById(R.id.chats_rv);
    }
}
