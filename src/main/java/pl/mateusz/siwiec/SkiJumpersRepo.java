package pl.mateusz.siwiec;

import java.util.List;

public interface SkiJumpersRepo {
    void addJumper(SkiJumper jumpers);

    void deleteJumper(SkiJumper jumpers);

    void editJumper(SkiJumper jumpers);

    List<SkiJumper> getSkiJumpers();
}
