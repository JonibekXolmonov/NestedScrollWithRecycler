package com.example.nestedscrollwithrecycler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedscrollwithrecycler.R;
import com.example.nestedscrollwithrecycler.adapter.ContactAdapter;
import com.example.nestedscrollwithrecycler.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();
    RecyclerView recyclerView;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_contacts);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        fillContactList();

        refreshAdapter();
    }

    void refreshAdapter() {
        ContactAdapter contactAdapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(contactAdapter);
    }

    void fillContactList() {
        for (int i = 1; i <= 60; i++) {
            contacts.add(new Contact("Contact" + i, "+(998)93-247-97-78"));
        }
    }
}