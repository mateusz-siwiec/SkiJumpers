package pl.mateusz.siwiec;

public class SkiJumperValidator {


    public boolean validateJumper(SkiJumper skiJumper) {

        String regex = "^[a-zA-Z]+$";
        return skiJumper.getWinsInCareerInWorldCup() > 0
                && skiJumper.getPodiumsInCareerInWorldCup() > 0
                && skiJumper.getName() != null && skiJumper.getName().matches(regex)
                && skiJumper.getSurname() != null && skiJumper.getSurname().matches(regex)
                && skiJumper.getNation() != null;
    }
}
