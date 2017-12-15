package com.example.tonym.teamdota2.model;

import java.io.Serializable;

public class Team implements Serializable {
    private String team_id;
    private String rating;
    private String wins;
    private String losses;
    private String last_match_time;
    private String name;
    private String tag;
    private String logo_url;

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getLast_match_time() {
        return last_match_time;
    }

    public void setLast_match_time(String last_match_time) {
        this.last_match_time = last_match_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    @Override
    public String toString() {
        return name;
    }
}
