package pl.mateusz.siwiec.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import pl.mateusz.siwiec.SkiJumper;

@Component
public class ListSkiJumpersRepository implements SkiJumpersRepository {
    private List<SkiJumper> skiJumpers = new ArrayList<SkiJumper>();

    /**
     *Adding ski jumper
     */
    @Override
    public void addJumper(SkiJumper skiJumper) {
        skiJumpers.add(skiJumper);
        skiJumper.assignId();
    }

    /**
     * Deleting ski jumper
     */
    @Override
    public void deleteJumper(int id) {
      SkiJumper skiJumperToRemove = findById(id);
      skiJumpers.remove(skiJumperToRemove);
    }

    /**
     * Editing ski jumper
     */
    @Override
    public void editJumper(SkiJumper skiJumper, int id) {
        SkiJumper existingSkiJumper = findById(id);
        existingSkiJumper.setName(skiJumper.getName());
        existingSkiJumper.setSurname(skiJumper.getSurname());
        existingSkiJumper.setNation(skiJumper.getNation());
        existingSkiJumper.setPodiumsInCareerInWorldCup(skiJumper.getPodiumsInCareerInWorldCup());
        existingSkiJumper.setWinsInCareerInWorldCup(skiJumper.getWinsInCareerInWorldCup());
    }

    /**
     *Getting all ski jumpers
     */
    @Override
    public List<SkiJumper> getSkiJumpers() {
        return skiJumpers;
    }

    /**
     *Getting ski jumper by id
     */
    @Override
    public SkiJumper findById(int id) {
        return skiJumpers.stream()
                .filter(skiJumper -> skiJumper.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}

