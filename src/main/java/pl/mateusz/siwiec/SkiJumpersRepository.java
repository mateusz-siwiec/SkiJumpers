package pl.mateusz.siwiec;

import java.util.ArrayList;
import java.util.List;

public class SkiJumpersRepository implements SkiJumpersRepo {
    List<SkiJumper> skiJumpers = new ArrayList<SkiJumper>();

    @Override
    public void addJumper(SkiJumper skiJumper) {
        skiJumpers.add(skiJumper);
        skiJumper.assignId();
    }

    @Override
    public void deleteJumper(int id) {
        skiJumpers.remove(id);
    }

    @Override
    public void editJumper(SkiJumper skiJumper, int id) {
        SkiJumper existingSkiJumper = findById(id);
        existingSkiJumper.setName(skiJumper.getName());
        existingSkiJumper.setSurname(skiJumper.getSurname());
        existingSkiJumper.setNation(skiJumper.getNation());
        existingSkiJumper.setPodiumsInCareerInWorldCup(skiJumper.getPodiumsInCareerInWorldCup());
        existingSkiJumper.setWinsInCareerInWorldCup(skiJumper.getWinsInCareerInWorldCup());
    }

    @Override
    public List<SkiJumper> getSkiJumpers() {
        return skiJumpers;
    }

    @Override
    public SkiJumper findById(int id) {
        return skiJumpers.stream()
                .filter(skiJumper -> skiJumper.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public boolean validateJumper(SkiJumper skiJumper) {
        String regex = "^[a-zA-Z]+$";
        return skiJumper.getWinsInCareerInWorldCup() > 0
                && skiJumper.getPodiumsInCareerInWorldCup() > 0
                && skiJumper.getName().matches(regex) && skiJumper.getName().length() > 1
                && skiJumper.getNation().matches(regex) && skiJumper.getNation().length() > 1
                && skiJumper.getSurname().matches(regex) && skiJumper.getSurname().length() > 1;
    }

}

