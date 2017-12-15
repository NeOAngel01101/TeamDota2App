package com.example.tonym.teamdota2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonym.teamdota2.model.Team;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    ImageView mImageViewImagen;
    TextView mTextViewName;
    TextView mTextViewTag;
    TextView mTextViewRating;
    TextView mTextViewWins;
    TextView mTextViewLosses;
    Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Team team = new Team();

        mImageViewImagen = findViewById(R.id.team_logo_image_view);
        mTextViewName = findViewById(R.id.team_name_text_view);
        mTextViewTag = findViewById(R.id.tag_text_view);
        mTextViewRating = findViewById(R.id.rating_text_view);
        mTextViewWins = findViewById(R.id.win_text_view);
        mTextViewLosses = findViewById(R.id.losses_text_view);

        Intent detailIntent = DetailActivity.this.getIntent();

        if(detailIntent.hasExtra("team")){
            team = (Team)detailIntent.getSerializableExtra("team");
        }

        Log.d("DetailActivity", "Image Src: " + team.getName());

        Picasso.with(this).load(team.getLogo_url()).into(mImageViewImagen);
        mTextViewName.setText(team.getName());
        mTextViewTag.setText(team.getTag());
        mTextViewRating.setText(team.getRating());
        mTextViewWins.setText(team.getWins());
        mTextViewLosses.setText(team.getLosses());
    }
}