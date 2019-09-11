package com.dikoding.picodiploma.mytourguidebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dikoding.picodiploma.mytourguidebook.adapter.ListWisataAdapter;
import com.dikoding.picodiploma.mytourguidebook.model.Wisata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference reference;
    ListWisataAdapter adapter;

    private ImageView userPhoto;
    private RecyclerView rvWisata;
    private ArrayList<Wisata> list; // inisiasi data from wisata.java

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load element from layout
        userPhoto = findViewById(R.id.user_photo); // layout/activity_main.xml
        rvWisata = findViewById(R.id.rv_thumbnails);

        userPhoto.setOnClickListener(this);
        rvWisata.setHasFixedSize(true);

        rvWisata.setLayoutManager(new LinearLayoutManager(this));

        reference = FirebaseDatabase.getInstance().getReference().child("wisatas");
        reference.addValueEventListener(new ValueEventListener() {
            /**
             *
             * @param dataSnapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Wisata wisata = dataSnapshot1.getValue(Wisata.class);
                    list.add(wisata);
                }
                adapter = new ListWisataAdapter(MainActivity.this, list);
                rvWisata.setAdapter(adapter);
            }

            /**
             *
             * @param databaseError
             */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Opsss... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_photo:
                Intent gotoMyProfile = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(gotoMyProfile);
                break;
        }
    }
}