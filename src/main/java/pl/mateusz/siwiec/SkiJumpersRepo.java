package pl.mateusz.siwiec;

import java.util.List;

public interface SkiJumpersRepo {
    void addJumper(SkiJumper jumper);

    void deleteJumper(int id);

    void editJumper(SkiJumper jumper , int id);

    List<SkiJumper> getSkiJumpers();

    SkiJumper findById(int id);
}
