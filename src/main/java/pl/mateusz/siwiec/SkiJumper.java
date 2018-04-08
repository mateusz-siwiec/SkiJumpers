package pl.mateusz.siwiec;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SkiJumper {

    private static int counter = 1;

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private Nations nation;
    private int winsInCareerInWorldCup;
    private int podiumsInCareerInWorldCup;

    public SkiJumper(String name, String surname, Nations nation, int winsInCareerInWorldCup, int podiumsInCareerInWorldCup) {
        this.name = name;
        this.surname = surname;
        this.nation = nation;
        this.winsInCareerInWorldCup = winsInCareerInWorldCup;
        this.podiumsInCareerInWorldCup = podiumsInCareerInWorldCup;
    }

    public SkiJumper() {
    }
    public void assignId(){
    this.id = counter++;
    }

    public int getId(){
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        SkiJumper.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Nations getNation() {
        return nation;
    }

    public void setNation(Nations nation) {
        this.nation = nation;
    }

    public int getWinsInCareerInWorldCup() {
        return winsInCareerInWorldCup;
    }

    public void setWinsInCareerInWorldCup(int winsInCareerInWorldCup) {
        this.winsInCareerInWorldCup = winsInCareerInWorldCup;
    }

    public int getPodiumsInCareerInWorldCup() {
        return podiumsInCareerInWorldCup;
    }

    public void setPodiumsInCareerInWorldCup(int podiumsInCareerInWorldCup) {
        this.podiumsInCareerInWorldCup = podiumsInCareerInWorldCup;
    }

    public void setId(int id) {
        this.id = id;
    }
}
