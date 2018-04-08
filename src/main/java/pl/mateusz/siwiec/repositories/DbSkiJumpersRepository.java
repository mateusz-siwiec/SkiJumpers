package pl.mateusz.siwiec.repositories;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.mateusz.siwiec.SkiJumper;

@Primary
@Component
public class DbSkiJumpersRepository implements SkiJumpersRepository {

  @Autowired
  private SpringDbSkiJumpersRepository springDbSkiJumpersRepository;

  @Override
  public void addJumper(SkiJumper jumper) {
    springDbSkiJumpersRepository.save(jumper);
  }

  @Override
  public void deleteJumper(int id) {
    springDbSkiJumpersRepository.deleteById(id);
  }

  @Override
  public void editJumper(SkiJumper jumper, int id) {
    jumper.setId(id);
    springDbSkiJumpersRepository.save(jumper);
  }

  @Override
  public List<SkiJumper> getSkiJumpers() {
    Iterable<SkiJumper> skiJumpersFromDb = springDbSkiJumpersRepository.findAll();

    List<SkiJumper> skiJumpers = new LinkedList<>();
    for (SkiJumper skiJumper : skiJumpersFromDb) {
      skiJumpers.add(skiJumper);
    }
    return skiJumpers;
  }

  @Override
  public SkiJumper findById(int id) {
    return springDbSkiJumpersRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ski jumper not found"));
  }

}
