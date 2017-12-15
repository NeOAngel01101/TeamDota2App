package com.example.tonym.teamdota2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import com.example.tonym.teamdota2.model.Team;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView mListViewTeams;
    ArrayList<Team> mListaTeams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewTeams = findViewById(R.id.list_view_teams);

        final ArrayAdapter<Team> adapter = new ArrayAdapter<Team>(
                this,
                R.layout.list_item_team,
                R.id.text_view_team,
                mListaTeams
        );

        mListViewTeams.setAdapter(adapter);

        mListViewTeams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(
                        MainActivity.this,
                        DetailActivity.class);
                detailIntent.putExtra("team", mListaTeams.get(position));
                startActivity(detailIntent);
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.opendota.com/api/teams",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("MainActivity", "Error al cargar los equipos!!!");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("MainActivity", "OK->Response:" + responseString);
                        Gson gson = new GsonBuilder().create();
                        Team[] teams = gson.fromJson(responseString, Team[].class);
                        adapter.clear();
                        for (Team team : teams) {
                            adapter.add(team);
                        }
                    }
                });
    }
}
