/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author chemm
 */
public class Pokemon {
    
    private SimpleStringProperty name;
    private SimpleStringProperty ability;
    private SimpleStringProperty type1;
    private SimpleStringProperty type2;
    private SimpleIntegerProperty hp;
    private SimpleIntegerProperty speed;
    private SimpleIntegerProperty attack;
    private SimpleIntegerProperty defense;
    private SimpleIntegerProperty specialAttack;
    private SimpleIntegerProperty specialDefense;
    
    public Pokemon(){
        this.name = new SimpleStringProperty("Unown");
        this.ability = new SimpleStringProperty("Levitate");
        this.type1 = new SimpleStringProperty("Psychic");
        this.type2 = new SimpleStringProperty("");
        this.hp = new SimpleIntegerProperty(0);
        this.speed = new SimpleIntegerProperty(0);
        this.attack = new SimpleIntegerProperty(0);
        this.defense = new SimpleIntegerProperty(0);
        this.specialAttack = new SimpleIntegerProperty(0);
        this.specialDefense = new SimpleIntegerProperty(0);
    }
    
    public Pokemon(String name,String ability, String type1, String type2, int hp, int speed, int attack, int defense, int specialAttack, int specialDefense){
        this.name = new SimpleStringProperty(name);
        this.ability = new SimpleStringProperty(ability);
        this.type1 = new SimpleStringProperty(type1);
        this.type2 = new SimpleStringProperty(type2);
        this.hp = new SimpleIntegerProperty(hp);
        this.speed = new SimpleIntegerProperty(speed);
        this.attack = new SimpleIntegerProperty(attack);
        this.defense = new SimpleIntegerProperty(defense);
        this.specialAttack = new SimpleIntegerProperty(specialAttack);
        this.specialDefense = new SimpleIntegerProperty(specialDefense);
    }
    
    public String getName(){
        return name.get();
    }
    
    public void setName(String name){
        this.name.set(name);
    }
    
    public SimpleStringProperty nameProperty(){
        return name;
    }
    
    public String getAbility(){
        return ability.get();
    }
    
    public void setAbility(String ability){
        this.ability.set(ability);
    }
    
    public SimpleStringProperty abilityProperty(){
        return ability;
    }
    
    public String getType1(){
        return type1.get();
    }
    
    public void setType1(String type1){
        this.type1.set(type1);
    }
    
    public SimpleStringProperty type1Property(){
        return type1;
    }
    
    public String getType2(){
        return type2.get();
    }
    
    public void setType2(String type2){
        this.type2.set(type2);
    }
    
    public SimpleStringProperty type2Property(){
        return type2;
    }
    
    public int getHP(){
        return this.hp.get();
    }
    
    public void setHP(int hp){
        this.hp.set(hp);
    }
    
    public SimpleIntegerProperty hpProperty(){
        return hp;
    }
    
    public int getSpeed(){
        return this.speed.get();
    }
    
    public void setSpeed(int speed){
        this.hp.set(speed);
    }
    
    public SimpleIntegerProperty speedProperty(){
        return speed;
    }
    
    public int getAttack(){
        return this.attack.get();
    }
    
    public void setAttack(int attack){
        this.attack.set(attack);
    }
    
    public SimpleIntegerProperty attackProperty(){
        return attack;
    }
    
    public int getDefense(){
        return this.hp.get();
    }
    
    public void setDefense(int defense){
        this.defense.set(defense);
    }
    
    public SimpleIntegerProperty defenseProperty(){
        return defense;
    }
    
    public int getSpecialAttack(){
        return this.specialAttack.get();
    }
    
    public void setspecialAttack(int specialAttack){
        this.specialAttack.set(specialAttack);
    }
    
    public SimpleIntegerProperty specialAttackProperty(){
        return specialAttack;
    }
    
    public int getSpecialDefense(){
        return this.specialDefense.get();
    }
    
    public void setSpecialDefense(int specialDefense){
        this.specialDefense.set(specialDefense);
    }
    
    public SimpleIntegerProperty specialDefenseProperty(){
        return specialDefense;
    }
}
