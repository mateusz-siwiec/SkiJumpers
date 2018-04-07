package pl.mateusz.siwiec;

import java.util.List;

public interface SkiJumpersRepo {
    void addJumper(SkiJumper jumper);

    void deleteJumper(SkiJumper jumper);

    void editJumper(SkiJumper jumper);

    List<SkiJumper> getSkiJumpers();

    SkiJumper findById(int id);
}
