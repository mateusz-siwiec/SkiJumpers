package pl.mateusz.siwiec.repositories;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.mateusz.siwiec.Nations;
import pl.mateusz.siwiec.SkiJumper;

public class ListSkiJumpersRepositoryTest {

  @Test
  public void addCorrectSkiJumpers() {
    SkiJumper skiJumper = new SkiJumper("Test", "Test", Nations.AUSTRIA, 15, 16);
    SkiJumper skiJumper2 = new SkiJumper("Test 2", "Test 2", Nations.FRANCE, 17, 19);

    ListSkiJumpersRepository listSkiJumpersRepository = new ListSkiJumpersRepository();
    listSkiJumpersRepository.addJumper(skiJumper);
    listSkiJumpersRepository.addJumper(skiJumper2);

    assertThat(listSkiJumpersRepository.getSkiJumpers().size()).isEqualTo(2);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0)).isEqualTo(skiJumper);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getId()).isGreaterThan(0);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getName()).isEqualTo("Test");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getSurname()).isEqualTo("Test");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getNation()).isEqualTo(Nations.AUSTRIA);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getWinsInCareerInWorldCup()).isEqualTo(15);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getPodiumsInCareerInWorldCup()).isEqualTo(16);

    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1)).isEqualTo(skiJumper2);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getId()).isGreaterThan(0);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getName()).isEqualTo("Test 2");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getSurname()).isEqualTo("Test 2");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getNation()).isEqualTo(Nations.FRANCE);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getWinsInCareerInWorldCup()).isEqualTo(17);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(1).getPodiumsInCareerInWorldCup()).isEqualTo(19);
  }

  @Test
  public void addAndDeleteSkiJumper() {
    SkiJumper skiJumper = new SkiJumper("Test", "Test", Nations.POLAND, 15, 16);

    ListSkiJumpersRepository listSkiJumpersRepository = new ListSkiJumpersRepository();
    listSkiJumpersRepository.addJumper(skiJumper);
    listSkiJumpersRepository.deleteJumper(skiJumper.getId());

    assertThat(listSkiJumpersRepository.getSkiJumpers().size()).isEqualTo(0);
  }

  @Test
  public void editJumper() {
    SkiJumper skiJumper = new SkiJumper("Test", "Test", Nations.RUSSIA, 15, 16);
    SkiJumper editedJumper = new SkiJumper("Edited", "Edited", Nations.CZECH_REPUBLIC, 77, 77);

    ListSkiJumpersRepository listSkiJumpersRepository = new ListSkiJumpersRepository();
    listSkiJumpersRepository.addJumper(skiJumper);
    listSkiJumpersRepository.editJumper(editedJumper, skiJumper.getId());

    assertThat(listSkiJumpersRepository.getSkiJumpers().size()).isEqualTo(1);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getName()).isEqualTo("Edited");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getSurname()).isEqualTo("Edited");
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getNation()).isEqualTo(Nations.CZECH_REPUBLIC);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getWinsInCareerInWorldCup()).isEqualTo(77);
    assertThat(listSkiJumpersRepository.getSkiJumpers().get(0).getPodiumsInCareerInWorldCup()).isEqualTo(77);
  }

  @Test
  public void findById() {
    SkiJumper skiJumper = new SkiJumper("Test", "Test", Nations.POLAND, 15, 16);
    SkiJumper skiJumper2 = new SkiJumper("Test 2", "Test 2", Nations.GERMANY, 17, 19);

    ListSkiJumpersRepository listSkiJumpersRepository = new ListSkiJumpersRepository();
    listSkiJumpersRepository.addJumper(skiJumper);
    listSkiJumpersRepository.addJumper(skiJumper2);
    SkiJumper skiJumperById = listSkiJumpersRepository.findById(skiJumper2.getId());

    assertThat(skiJumperById).isNotNull();
    assertThat(skiJumperById.getName()).isEqualTo("Test 2");
  }

}