package pl.mateusz.siwiec.repositories;

import java.util.List;

import pl.mateusz.siwiec.SkiJumper;

/**
 * This is a interface for ski jumper
 */
public interface SkiJumpersRepository {
    void addJumper(SkiJumper jumper);

    void deleteJumper(int id);

    void editJumper(SkiJumper jumper, int id);

    List<SkiJumper> getSkiJumpers();

    SkiJumper findById(int id);
}
