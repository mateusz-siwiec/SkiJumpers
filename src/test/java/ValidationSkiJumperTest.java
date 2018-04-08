import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import pl.mateusz.siwiec.Nations;
import pl.mateusz.siwiec.SkiJumper;
import pl.mateusz.siwiec.SkiJumperValidator;

public class ValidationSkiJumperTest {

    @Test
    public void shouldBeInvalidWhenNameIsEmpty() {
        SkiJumper skiJumper = new SkiJumper("", "Test", Nations.POLAND, 15, 16);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeInvalidWhenSurnameIsEmpty(){
        SkiJumper skiJumper = new SkiJumper("Test", "" , Nations.POLAND , 10,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeInvalidWhenNameContainIllegalCharacters(){
        SkiJumper skiJumper = new SkiJumper("Te123st", "Test" , Nations.POLAND , 10,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeInvalidWhenSurnameContainIllegalCharacters(){
        SkiJumper skiJumper = new SkiJumper("Test", "Te1!.st" , Nations.POLAND , 10,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeInvalidWhenWinsInCareerIsLessThanZero(){
        SkiJumper skiJumper = new SkiJumper("Test", "Test" , Nations.POLAND , -5,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeInvalidWhenPodiumsInCareerIsLessThanZero(){
        SkiJumper skiJumper = new SkiJumper("Test", "Test" , Nations.POLAND , 10,-10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }
    @Test
    public void shouldBeValidWhenAllParametersAreCorrect(){
        SkiJumper skiJumper = new SkiJumper("Test", "Test" , Nations.POLAND , 5,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isTrue();
    }
    @Test
    public void shouldBeInvalidWhenNationIsNull(){
        SkiJumper skiJumper = new SkiJumper("Test", "Test" , null , -5,10);
        SkiJumperValidator skiJumperValidator = new SkiJumperValidator();
        boolean result = skiJumperValidator.validateJumper(skiJumper);
        assertThat(result).isFalse();
    }

}
