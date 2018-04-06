package pl.mateusz.siwiec;

public class SkiJumper {
    private String name;
    private String surname;
    private String nation;
    private int winsInCareerInWorldCup;
    private int podiumsInCareerInWorldCup;

    public SkiJumper(String name, String surname, String nation, int winsInCareerInWorldCup, int podiumsInCareerInWorldCup) {
        this.name = name;
        this.surname = surname;
        this.nation = nation;
        this.winsInCareerInWorldCup = winsInCareerInWorldCup;
        this.podiumsInCareerInWorldCup = podiumsInCareerInWorldCup;
    }
}
