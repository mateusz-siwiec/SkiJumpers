package pl.mateusz.siwiec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkiJumpersRepository implements SkiJumpersRepo {
    List<SkiJumper> skiJumpers = new ArrayList<SkiJumper>();
    @Override
    public void addJumper(SkiJumper jumpers) {
       skiJumpers.add(jumpers);
    }
    @Override
    public void deleteJumper(int id) {
        skiJumpers.remove(id);
    }
    @Override
    public void editJumper(SkiJumper jumpers , int id) {
        SkiJumper existingSkiJumper = findById(id);
        existingSkiJumper.setName(jumpers.getName());
        existingSkiJumper.setSurname(jumpers.getSurname());
        existingSkiJumper.setNation(jumpers.getNation());
        existingSkiJumper.setPodiumsInCareerInWorldCup(jumpers.getPodiumsInCareerInWorldCup());
        existingSkiJumper.setWinsInCareerInWorldCup(jumpers.getWinsInCareerInWorldCup());
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
}
