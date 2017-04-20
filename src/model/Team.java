package model;


import java.util.ArrayList;
import java.util.List;
import model.Pokemon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chemm
 */
public class Team {
    
    private ArrayList<Pokemon> team;
    private int teamID;
    
    public Team(){
        this.team = new ArrayList<>();
        this.teamID = 1;
    }

    public Team(ArrayList<Pokemon> team, int teamID) {
        this.team = team;
        this.teamID = teamID;
    }

    public Team(List<Pokemon> teamList) {
        this.team = new ArrayList<>();
        this.teamID = 1;
    }

    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Pokemon> team) {
        this.team = team;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void add(Pokemon p) {
        team.add(p);
    }

    public int size() {
        return team.size();
    }
    
}
