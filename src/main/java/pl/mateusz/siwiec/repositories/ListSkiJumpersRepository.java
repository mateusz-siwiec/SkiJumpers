package pl.mateusz.siwiec.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import pl.mateusz.siwiec.SkiJumper;

@Component
public class ListSkiJumpersRepository implements SkiJumpersRepository {
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

}

