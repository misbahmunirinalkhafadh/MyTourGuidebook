package com.dikoding.picodiploma.mytourguidebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView profilePhoto;
    private TextView tvNama, tvEmail, tvTelepone, tvAlamat;
//    private ArrayList<User> list = new ArrayList<>();

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //load element
        ImageView btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        //load element data
        profilePhoto = findViewById(R.id.image_user);
        tvNama = findViewById(R.id.tv_nama);
        tvEmail = findViewById(R.id.tv_email);
        tvTelepone = findViewById(R.id.tv_telepone);
        tvAlamat = findViewById(R.id.tv_alamat);

    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent goBackPage = new Intent(MyProfileActivity.this, MainActivity.class);
                startActivity(goBackPage);
                break;
        }
    }
}
