package pl.mateusz.siwiec;

import java.util.ArrayList;
import java.util.List;

public class SkiJumpersRepository implements SkiJumpersRepo {
    List<SkiJumper> skiJumpers = new ArrayList<SkiJumper>();
    @Override
    public void addJumper(SkiJumper jumpers) {
        skiJumpers.add(jumpers);
    }
    @Override
    public void deleteJumper(SkiJumper jumpers) {
        skiJumpers.remove(jumpers);
    }
    @Override
    public void editJumper(SkiJumper jumpers) {

    }

    @Override
    public List<SkiJumper> getSkiJumpers() {
        return null;
    }
}
