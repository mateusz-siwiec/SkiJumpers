package pl.mateusz.siwiec.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mateusz.siwiec.SkiJumper;

public interface SpringDbSkiJumpersRepository extends CrudRepository<SkiJumper, Integer> {

}
